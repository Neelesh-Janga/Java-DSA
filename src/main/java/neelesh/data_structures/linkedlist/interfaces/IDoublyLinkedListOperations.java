package main.java.neelesh.data_structures.linkedlist.interfaces;

import main.java.neelesh.data_structures.linkedlist.nodes.DoublyLinkedListNode;

public interface IDoublyLinkedListOperations extends ILinkedListOperations<DoublyLinkedListNode> {
    void forwardTraversal(DoublyLinkedListNode head);
    void backwardTraversal(DoublyLinkedListNode head);
}
