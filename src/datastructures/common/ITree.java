package datastructures.common;

import java.util.List;

/*
* a Base interface for how a tree should look like */
public interface ITree<T> {
    void insert(T value);
    void delete(T value);
    boolean search(T value);
    List<T> printPreorder();
    List<T> printInorder(INode<T> root);
    List<T> printPostorder(INode<T> root);
    List<T> printLevelorder(INode<T> root);
    void depth();
}
