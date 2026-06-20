package datastructures.lists.unrolledll;

import datastructures.common.IList;
import datastructures.lists.circularll.CircularLL;
import datastructures.lists.singlyll.SinglyLLNode;
/**
 * Assume that there are no more than n elements in unrolled list at a time and every block except the last one has exactly ceil(sqrt(n)) elements as circular linked list
 */
public class UnrolledLL<T> implements IList<T> {
    CircularLL<T> block;
    SinglyLLNode<CircularLL<T>> head;

    UnrolledLL(){
        head = null;
        block = new CircularLL<>();
    }

    @Override
    public void print() {

    }

    @Override
    public void append(T value) {

    }

    @Override
    public void prepend(T value) {

    }

    @Override
    public boolean search(T value) {
        return false;
    }

    @Override
    public void delete(Integer pos) {

    }

    @Override
    public void insert(T value, Integer pos) {

    }

    @Override
    public void pop_back() {

    }

    @Override
    public void pop_front() {

    }

    @Override
    public T at(int index) {
        return null;
    }
}
