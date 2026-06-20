package datastructures.trees.bst;

import datastructures.common.INode;

public class BinaryNode<T> implements INode<T>{
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    public BinaryNode(T value) {
        this.value = value;
        left=null;
        right=null;
    }
    public BinaryNode<T> getLeft(){
       try {
           return this.left;
       }catch(Exception e) {
           System.out.println("left node is calling to a null pointer" + e);
           return null;
       }
    }
    public BinaryNode<T> getRight(){
        try {
            return this.right;
        } catch (Exception e) {
            System.out.println("right node is calling to a null pointer" + e);
            return null;
        }
    }
    public void setLeft(BinaryNode<T> left){
        this.left = left;
    }
    public void setRight(BinaryNode<T> right){
        this.right = right;
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
