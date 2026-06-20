package datastructures.lists.singlyll;

import datastructures.common.IList;

public class SinglyLL<T> implements IList<T> {
   private SinglyLLNode<T> head;
   private Integer size;
   public SinglyLL(){
       this.head = null;
       this.size = 0;
   }
    public Integer getSize(){
       return size;
    }
    @Override
    public void print(){
        if(head == null){
            System.out.println("Empty List");
        }
        SinglyLLNode<T> curr = head;
        while(curr != null){
            System.out.print(curr.getValue() + "->");
            curr = curr.getNext();
        }
        System.out.print("null");
    }

    @Override
    public void append(T value) {
       if(head == null){
          head = new SinglyLLNode<>(value);
          size++;
          return;
       }
       SinglyLLNode<T> curr = head;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(new SinglyLLNode<>(value));
        size++;
    }
   @Override
   public void prepend(T value){
       SinglyLLNode<T> newNode = new SinglyLLNode<>(value);
       newNode.setNext(head);
       head = newNode; // re adjust the head pointer
       size++;
   }
    /**
 * @param value is the value held by the node at the position pos
 */
    @Override
    public void insert(T value, Integer pos) {
        if(size < pos || pos < 0){
            System.out.print("Invalid position");
            return;
        }
        if(pos.equals(size)){
            append(value);
        } else if (pos == 0) {
            prepend(value);
        }else {
            SinglyLLNode<T> curr = head;
            int index = 0;
            while (curr != null) {
                if(index == pos-1){
                    SinglyLLNode<T> newNode = new SinglyLLNode<>(value);
                    newNode.setNext(curr.getNext());
                    curr.setNext(newNode);
                    size++;
                    return;
                }
                curr = curr.getNext();
                index++;
            }
        }
    }

    @Override
    public void pop_back() {
        if(head == null) return;
        if( head.getNext() == null){
            head = null;
            size--;
            return;
        }
        SinglyLLNode<T> curr = head;
        while(curr.getNext().getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(null);
        size--;
    }

    @Override
    public void pop_front() {
        if(head == null) return;
        SinglyLLNode<T> freeNode = head;
        head = head.getNext();
        freeNode.setNext(null);
        size--;
    }

    @Override
    public T at(int index) {
        if(index < 0 || head == null || index >= this.size){
            return null;
        }
        SinglyLLNode<T> curr = head;
        while(index < this.size){
            curr = curr.getNext();
            index++;
        }
        return  curr.getValue();
    }

    @Override
    public boolean search(T value) {
        if(head == null) {
            return false;
        }
        SinglyLLNode<T> curr = head;
        while(curr != null ){
            if(curr.getValue().equals(value)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void delete(Integer pos) {
        if(pos == size-1) {
            pop_back();
        } else if (pos == 0) {
            pop_front();
        } else if (pos < 0 || pos >= size) {
            System.out.println("Invalid position!");
        }else{
           SinglyLLNode<T> curr = head;
           int index = 0;
           while(curr != null){
                if(index == pos-1){
                    SinglyLLNode<T> temp = curr.getNext();
                    curr.setNext(curr.getNext().getNext());
                    temp.setNext(null);
                    size--;
                    return;
                }
               index++;
               curr = curr.getNext();
           }
        }
    }


}
