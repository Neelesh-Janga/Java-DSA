package main.java.neelesh.data_structures.linkedlist.nodes;

public class SinglyLinkedListNode implements Node {
    public int val;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
}