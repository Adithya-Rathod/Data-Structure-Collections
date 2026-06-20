package datastructures.trees.bst;

import datastructures.common.INode;
import datastructures.common.ITree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> implements ITree<T> {
    private BinaryNode<T> root;
    private Integer size;

    public Integer getSize(){
        return size;
    }

    @Override
    public void insert(T value) {
        if(root == null) {
            root = new BinaryNode<>(value);
            size++;
            return;
        }
    }

    @Override
    public void delete(T value) {

    }

    @Override
    public boolean search(T value) {
        return false;
    }

    @Override
    public List<T> printPreorder() {
        return null;
    }

    @Override
    public List<T> printInorder(INode<T> root) {
        return List.of();
    }

    @Override
    public List<T> printPostorder(INode<T> root) {
        return List.of();
    }

    @Override
    public List<T> printLevelorder(INode<T> root) {
        return List.of();
    }


    @Override
    public void depth() {

    }
}
