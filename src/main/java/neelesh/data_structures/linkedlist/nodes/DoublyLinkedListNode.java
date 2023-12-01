package main.java.neelesh.data_structures.linkedlist.nodes;

public class DoublyLinkedListNode implements Node {

    public DoublyLinkedListNode prev;
    public int val;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}