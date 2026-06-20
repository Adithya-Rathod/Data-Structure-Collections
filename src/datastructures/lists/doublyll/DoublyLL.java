package datastructures.lists.doublyll;

import datastructures.common.IList;

public class DoublyLL<T> implements IList<T> {
    private DoublyLLNode<T> head;
    private Integer size;
    public Integer getSize(){
        return size;
    }
    @Override
    public void print() {
        if(head == null){
            System.out.println("Empty List!");
            return;
        }
        DoublyLLNode<T> curr = head;
        while(curr != null){
            System.out.print(curr.getValue() + "->");
            curr = curr.getNext();
        }
        System.out.print("null");
}

    @Override
    public void append(T value) {
        if(head == null){
            head = new DoublyLLNode<>(value);
            size++;
            return;
        }
        DoublyLLNode<T> curr = head;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        DoublyLLNode<T> newNode = new DoublyLLNode<>(value);
        curr.setNext(newNode);
        newNode.setPrev(curr);
        size++;
    }

    @Override
    public void prepend(T value) {
        if(head == null){
            head = new DoublyLLNode<>(value);
            size++;
            return;
        }
        DoublyLLNode<T> newNode = new DoublyLLNode<>(value);
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        size++;
    }

    @Override
    public boolean search(T value) {
        if(head == null){
            System.out.println("Empty list");
            return false;
        }
        DoublyLLNode<T> curr= head;
        while(curr != null){
            if(curr.getValue().equals(value)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void delete(Integer pos) {
        if(pos == 0){
            pop_front();
        }else if(pos == size -1){
            pop_back();
        }else if(pos < 0 || pos >= size){
                System.out.println("Invalid position!");
        }else{
            DoublyLLNode<T> curr = head;
            int index = 0;
            while(curr != null){
                if(index == pos-1){
                    DoublyLLNode<T> temp = curr.getNext();
                    temp.getNext().setPrev(curr);
                    curr.setNext(temp.getNext());
                    temp.setNext(null);
                    temp.setPrev(null);
                    size--;
            }
                index++;
                curr = curr.getNext();
            }
        }
    }

    @Override
    public void insert(T value, Integer pos) {
        if(pos > size || pos < 0){
            System.out.println("Invalid position");
            return;
        }
        if(pos.equals(size))
            append(value);
        else if (pos == 0) {
            prepend(value);
        }else{
            DoublyLLNode<T> curr = head;
            int index =0;
            while(curr != null){
                if(index == pos- 1){
                    DoublyLLNode<T> newNode = new DoublyLLNode<>(value);
                    newNode.setNext(curr.getNext());
                    newNode.setPrev((curr));
                    curr.getNext().setPrev(newNode);
                    curr.setNext(newNode);
                    size++;
                    return;
                }
                index++;
                curr = curr.getNext();
            }
        }
    }

    @Override
    public void pop_back() {
        if(head == null){
            System.out.println("Nothing to pop!");
            return;
        }
        DoublyLLNode<T> curr= head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        DoublyLLNode<T> temp = curr.getPrev();
        temp.setNext(null);
        curr.setPrev(null);
        size--;
    }

    @Override
    public void pop_front() {
        if(head == null){
            System.out.println("Nothing to pop!");
            return;
        }
        DoublyLLNode<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        head.setPrev(null);
        size--;
    }

    @Override
    public T at(int index) {
        return null;
    }
}
