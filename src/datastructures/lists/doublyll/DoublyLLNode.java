package datastructures.lists.doublyll;

import datastructures.common.INode;

/**
 * A memory optimized approach for implementing dll exist by storing the pointer diff of the previous and the next pointer,
 * head.ptrDiff = NULL ^ next  => 2nd node
 * tail.ptrDiff = prev ^ NULL => last 2nd node
 * But this can't be implemented in java cos no pointers :)
 * @param <T>
 */

public class DoublyLLNode<T> implements INode<T>{
    T value;
    DoublyLLNode<T> next;
    DoublyLLNode<T> prev;
    public DoublyLLNode(T value){
        this.value = value;
        next = null;
        prev = null;
    }
    public void setNext(DoublyLLNode<T> node){
        this.next = node;
    }
    public void setPrev(DoublyLLNode<T> node){
        this.next = node;
    }
    public DoublyLLNode<T> getNext(){
        return this.next ;
    }
    public DoublyLLNode<T> getPrev(){
        return this.next;
    }
    @Override
    public T getValue(){
       return this.value;
    }

    @Override
    public void setValue(T value) {
       this.value = value;
    }
}
