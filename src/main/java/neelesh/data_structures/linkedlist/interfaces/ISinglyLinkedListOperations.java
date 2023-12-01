package main.java.neelesh.data_structures.linkedlist.interfaces;

import main.java.neelesh.data_structures.linkedlist.nodes.SinglyLinkedListNode;

public interface ISinglyLinkedListOperations extends ILinkedListOperations<SinglyLinkedListNode> {

    void display(SinglyLinkedListNode head);
    boolean isLooped(SinglyLinkedListNode head);
    void removeLoop(SinglyLinkedListNode head);
    SinglyLinkedListNode getIntersectionNode(SinglyLinkedListNode list1, SinglyLinkedListNode list2);
}
