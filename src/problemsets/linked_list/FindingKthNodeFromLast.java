package problemsets.linked_list;
import datastructures.lists.singlyll.SinglyLLNode;

public class FindingKthNodeFromLast {
    public static SinglyLLNode<Integer> find(SinglyLLNode<Integer> head,  int k){
        if ( head == null){
            return null;
        }
        // find the lenght of the ll
        SinglyLLNode<Integer> curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.getNext();
        }
        // the kth node from end is n-k+1 the node from beginning
        curr = head;
        for (int i=1 ;i<=size-k && curr !=null; i++){
         curr = curr.getNext();
        }
        return curr;
    }
    // given k will be always less than size of ll
    public static SinglyLLNode<Integer> findOptimized(SinglyLLNode<Integer> head , int k){
        if(head == null){
            return null;
        }

        SinglyLLNode<Integer> p = head, temp = head;
        for(int i=0; i<k-1; i++){
            temp = temp.getNext();
        }
        while(temp.getNext() != null){
            temp = temp.getNext();
            p = p.getNext();
        }
        return p;
    }
}