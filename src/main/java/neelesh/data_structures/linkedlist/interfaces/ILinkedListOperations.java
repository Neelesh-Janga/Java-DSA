package main.java.neelesh.data_structures.linkedlist.interfaces;

import main.java.neelesh.data_structures.linkedlist.nodes.Node;

public interface ILinkedListOperations<N extends Node> {
    N create(int... varArgs);

    N insert(N head, int number, int index);

    int find(N head, int number);

    int findLength(N head);

    N concat(N list1, N list2);

    N delete(N head, int number);

    int findMiddleNumber(N head);

    boolean isPalindrome(N head);

    N copy(N head);

    N deleteEntireList(N head);

    N mergeSortedLinkedLists(N list1, N list2, boolean ascending);

    N findUnion(N list1, N list2);

    N reverse(N head);

    N reverseUsingRecursion(N head);
}
