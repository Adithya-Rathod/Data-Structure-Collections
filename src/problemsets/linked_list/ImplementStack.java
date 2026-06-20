package problemsets.linked_list;

import datastructures.lists.singlyll.SinglyLLNode;

import javax.swing.*;

public class ImplementStack<T>
    {
        private SinglyLLNode<T> head;
        private int size;
        public ImplementStack(){
            head = null;
            size = 0;
        }
        public T top(){
            if(head != null){
                return head.getValue();
            }
            return null;
        }
        public T pop(){
            if (head == null) {
                System.out.println("cant pop when there are no elements");
                return null;
            }
            SinglyLLNode<T> temp = head;
            head = head.getNext();
            T val = temp.getValue();
            temp.setNext(null);
            size--;
            return val;
        }
        public  void push(T val){
            if(head == null){
                head = new SinglyLLNode<>(val);
                size++;
                return;
            }
            SinglyLLNode<T> newNode = new SinglyLLNode<>(val);
            newNode.setNext(head);
            head = newNode;
            size++;
        }
        public int size() {
            return size;
        }
        public void print(){
            SinglyLLNode<T> curr = head;
            while(curr != null){
                System.out.print(curr.getValue() + "->");
                curr = curr.getNext();
                if(curr == null){
                    System.out.print("null");
                }
            }
        }
}

