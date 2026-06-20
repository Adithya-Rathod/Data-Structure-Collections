#include<iostream>
using namespace std;
// memory effi doubly linked list
template<typename t>
class Node{
    t value;
    Node* ptrDiff;

    public Node(t val){
        this.value = val;
        ptrDiff = nullptr;
    }
};

template<typename t>
class DoublyLL{
    Node* head;

   DoublyLL(){this.head = nullptr;}

   public append(t val){
    if(head == nullptr){
        head = new Node(t);
    }
    while(head!=nullptr)
   }
};


