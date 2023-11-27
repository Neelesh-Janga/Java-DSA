package main.java.neelesh.data_structures.linkedlist;

import main.java.neelesh.data_structures.linkedlist.interfaces.ILinkedListOperations;
import main.java.neelesh.data_structures.linkedlist.interfaces.ISinglyLinkedListOperations;
import main.java.neelesh.data_structures.linkedlist.nodes.Node;
import main.java.neelesh.data_structures.linkedlist.nodes.SinglyLinkedListNode;

public class SinglyLinkedList implements ISinglyLinkedListOperations {

    @Override
    public SinglyLinkedListNode create(int... varArgs) {
        SinglyLinkedListNode head = null, tail = null;
        for (int num : varArgs) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(num);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    @Override
    public void display(SinglyLinkedListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + " --> ");
            else
                System.out.println(head.val);

            head = head.next;
        }
    }

    @Override
    public SinglyLinkedListNode insert(SinglyLinkedListNode head, int number, int index) {
        if (head == null && index != 0) {
            System.out.println("Invalid index for an empty list");
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(number);
        int length = 0;
        if (index == 0 || (head == null && index == 0)) {
            newNode.next = head;
            head = newNode;
        } else {
            SinglyLinkedListNode tail = head;
            while (index != 1 && tail.next != null) {
                tail = tail.next;
                index--;
            }
            if (index > 1) {
                System.out.println("Not a valid Index. Length of Singly LinkedList is " + length + 1);
                return head;
            }
            newNode.next = tail.next;
            tail.next = newNode;
        }

        return head;
    }

    @Override
    public int find(SinglyLinkedListNode head, int number) {
        SinglyLinkedListNode ptr = head;
        int index = 0;

        while (ptr != null) {
            if (ptr.val == number) return index;
            index++;
            ptr = ptr.next;
        }

        return -1;
    }

    @Override
    public int findLength(SinglyLinkedListNode head) {
        SinglyLinkedListNode ptr = head;
        int length = 0;

        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        return length;
    }

    @Override
    public SinglyLinkedListNode concat(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        SinglyLinkedListNode head = list1;

        while (head.next != null) {
            head = head.next;
        }

        head.next = list2;

        return list1;
    }

    @Override
    public SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return head;

        SinglyLinkedListNode first = head.next, last = null;

        while (head.next != null) {
            head.next = last;
            last = head;
            head = first;
            first = first.next;
        }

        head.next = last;

        return head;
    }

    @Override
    public SinglyLinkedListNode reverseUsingRecursion(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return head;

        SinglyLinkedListNode newHead = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    @Override
    public boolean isLooped(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return false;

        SinglyLinkedListNode fast = head.next.next, slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    @Override
    public SinglyLinkedListNode delete(SinglyLinkedListNode head, int number) {
        SinglyLinkedListNode ptr = head;
        while (head != null && head.val == number) {
            head = head.next;
            ptr.next = null;
            ptr = head;
        }

        if (head == null) return null;

        SinglyLinkedListNode first = head.next, last = null;

        while (ptr.next != null) {
            if (ptr.val == number) {
                ptr.next = null;
                last.next = first;
            } else {
                last = ptr;
            }
            ptr = first;
            first = first.next;
        }

        if (ptr.val == number) {
            last.next = null;
        }

        return head;
    }

    @Override
    public int findMiddleNumber(SinglyLinkedListNode head) {
        if (head == null) return 0;
        if (head.next == null) return head.val;

        SinglyLinkedListNode fast = head.next.next, slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;
    }

    @Override
    public boolean isPalindrome(SinglyLinkedListNode head) {
        SinglyLinkedListNode list = copy(head);
        SinglyLinkedListNode reversedHead = reverse(list);

        while (reversedHead != null) {
            if (reversedHead.val != head.val) return false;
            reversedHead = reversedHead.next;
            head = head.next;
        }

        return true;
    }

    @Override
    public SinglyLinkedListNode copy(SinglyLinkedListNode head) {
        SinglyLinkedListNode newHead = null, tail = null, ptr = head;

        while (ptr != null) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(ptr.val);
            if (newHead == null) {
                newHead = newNode;
                tail = newHead;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            ptr = ptr.next;
        }

        return newHead;
    }

    @Override
    public SinglyLinkedListNode getIntersectionNode(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        if (list1 == null || list2 == null) return null;
        SinglyLinkedListNode l1 = list1;
        SinglyLinkedListNode l2 = list2;

        while (l1 != l2) {
            l1 = (l1 == null) ? list2 : l1.next;
            l2 = (l2 == null) ? list1 : l2.next;
        }

        return l1;
    }

    @Override
    public SinglyLinkedListNode deleteEntireList(SinglyLinkedListNode head) {
        SinglyLinkedListNode follow;

        while (head != null) {
            follow = head;
            head = head.next;
            follow.next = null;
        }

        return head;
    }
}
