package datastructures.lists;

import datastructures.common.INode;
import datastructures.lists.singlyll.SinglyLLNode;

public class util {

    public static <T> void printList(INode<T> head){
        if(head == null){
            System.out.println("Empty List");
        }
        if(head instanceof SinglyLLNode<T> curr){
            while(curr != null){
                System.out.print(curr.getValue() + "->");
                curr = curr.getNext();
            }
            System.out.print("null\n");
        }
    }
}
