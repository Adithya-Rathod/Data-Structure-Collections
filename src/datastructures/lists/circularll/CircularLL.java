package datastructures.lists.circularll;

import datastructures.common.IList;
import datastructures.common.INode;
import datastructures.lists.singlyll.SinglyLLNode;

public class CircularLL<T> implements IList<T> {
    private SinglyLLNode<T> tail;
    private Integer size;

    public CircularLL() {
        this.tail = null;
        this.size = 0;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public void print() {
        if (tail == null) {
            System.out.println("Empty List");
        } else {
            SinglyLLNode<T> curr = tail.getNext();
            while (curr != tail) {
                System.out.print(curr.getValue() + "->");
                curr = curr.getNext();
            }
            System.out.print(curr.getValue());
        }
    }

    @Override
    public void append(T value) {
        //Append is basically adding it before the head and incrementing the tail by 1 :)
        prepend(value);
        tail = tail.getNext();
    }

    @Override
    public void prepend(T value) {
        if (tail == null) {
            tail = new SinglyLLNode<>(value);
            tail.setNext(tail);
        } else {
            SinglyLLNode<T> head = tail.getNext();
            tail.setNext(new SinglyLLNode<>(value));
            tail.getNext().setNext(head);
        }
        size++;
    }

    @Override
    public boolean search(T value) {
        if (tail == null) {
            return false;
        }
        if (tail.getValue().equals(value)) return true;
        SinglyLLNode<T> curr = tail.getNext();
        while (curr != tail) {
            if (curr.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(Integer pos) {
        pos = (pos % size + size) % size;
        if (pos == 0) {
            pop_front();
        } else if (pos.equals(size - 1)) {
            pop_back();
        } else {
            SinglyLLNode<T> curr = tail.getNext();
            Integer index = 0;
            while (index != pos - 1) {
                curr = curr.getNext();
                index++;
            }
            SinglyLLNode<T> temp = curr.getNext();
            curr.setNext(temp.getNext());
            temp.setNext(null);
            size--;
        }
    }

    @Override
    public void insert(T value, Integer pos) {
        pos = (pos % size + size) % size;
        if (pos == 0) {
            prepend(value);
        } else if (pos.equals(size-1)) {
            append(value);
        } else {
            // in circular LL there isn't any fixed range from 0 to size-1, its circular so need to wrap around a modular operator
            SinglyLLNode<T> curr = tail.getNext();
            Integer index = 0;
            while (index != pos - 1) {
                curr = curr.getNext();
                index++;
            }
            SinglyLLNode<T> newNode = new SinglyLLNode<>(value);
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            size++;
        }
    }

    @Override
    public void pop_back() {
        if (tail == null) {
            return;
        }
        if (tail.getNext().equals(tail)) { //meaning only one node
            tail = null;
            size--;
            return;
        }
        SinglyLLNode<T> curr = tail.getNext();
        while (curr.getNext() != tail) {
            curr = curr.getNext();
        }
        curr.setNext(tail.getNext());
        tail.setNext(null);
        tail = curr;
        size--;
    }

    @Override
    public void pop_front() {
        if (tail == null) {
            return;
        }
        if (tail.getNext().equals(tail)) { //meaning only one node
            tail = null;
            size--;
            return;
        }
        SinglyLLNode<T> temp = tail.getNext();
        tail.setNext(temp.getNext());
        temp.setNext(null);
        size--;
    }

    @Override
    public T at(int index) {
        return null;
    }

    /**
     * A seperate count function to count the nodes in a circular linked list
     * Its  NO_POWER(n) function, can directly get the size of the linked list from the getSize();
     */
    public int count(){
        if(tail == null) return 0;
        SinglyLLNode<T> mem = tail;
        int len = 1;
        while(!tail.getNext().equals(tail)){
            len ++;
            tail.setNext(tail.getNext());
        }
        return len;
    }
}
