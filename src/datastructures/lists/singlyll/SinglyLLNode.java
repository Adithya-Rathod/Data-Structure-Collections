package datastructures.lists.singlyll;
import datastructures.common.INode;
public class SinglyLLNode<T> implements INode<T> {
    private T value;
    private SinglyLLNode<T> next;
    // node constructor
    public SinglyLLNode(){
    }
    public SinglyLLNode(T value){
        this.value = value;
        next = null;
    }
    public SinglyLLNode<T> getNext(){
        return this.next;
    }
    public void setNext(SinglyLLNode<T> node){
        this.next = node;
    }
    @Override
    public T getValue() {
        return value;
    }
    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
