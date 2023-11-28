package main.java.neelesh.data_structures.linkedlist.interfaces;

import main.java.neelesh.data_structures.linkedlist.nodes.SinglyLinkedListNode;

public interface ISinglyLinkedListOperations extends ILinkedListOperations<SinglyLinkedListNode> {

    SinglyLinkedListNode reverse(SinglyLinkedListNode head);

    SinglyLinkedListNode reverseUsingRecursion(SinglyLinkedListNode head);

    boolean isLooped(SinglyLinkedListNode head);

    void removeLoop(SinglyLinkedListNode head);
}
