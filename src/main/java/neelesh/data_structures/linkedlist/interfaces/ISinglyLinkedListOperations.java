package main.java.neelesh.data_structures.linkedlist.interfaces;

import main.java.neelesh.data_structures.linkedlist.nodes.SinglyLinkedListNode;

public interface ISinglyLinkedListOperations {
    SinglyLinkedListNode create(int... varArgs);

    void display(SinglyLinkedListNode head);

    SinglyLinkedListNode insert(SinglyLinkedListNode head, int number, int index);

    int find(SinglyLinkedListNode head, int number);

    int findLength(SinglyLinkedListNode head);

    SinglyLinkedListNode concat(SinglyLinkedListNode list1, SinglyLinkedListNode list2);

    SinglyLinkedListNode reverse(SinglyLinkedListNode head);

    SinglyLinkedListNode reverseUsingRecursion(SinglyLinkedListNode head);

    boolean isLooped(SinglyLinkedListNode head);

    SinglyLinkedListNode delete(SinglyLinkedListNode head, int number);

    int findMiddleNumber(SinglyLinkedListNode head);

    boolean isPalindrome(SinglyLinkedListNode head);

    SinglyLinkedListNode copy(SinglyLinkedListNode head);

    SinglyLinkedListNode getIntersectionNode(SinglyLinkedListNode list1, SinglyLinkedListNode list2);

    SinglyLinkedListNode deleteEntireList(SinglyLinkedListNode head);
}
