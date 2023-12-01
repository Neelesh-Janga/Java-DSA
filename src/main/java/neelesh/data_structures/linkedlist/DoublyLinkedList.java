package main.java.neelesh.data_structures.linkedlist;

import main.java.neelesh.data_structures.linkedlist.interfaces.IDoublyLinkedListOperations;
import main.java.neelesh.data_structures.linkedlist.nodes.DoublyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class DoublyLinkedList implements IDoublyLinkedListOperations {

    @Override
    public DoublyLinkedListNode create(int... varArgs) {
        DoublyLinkedListNode head = null, ptr = null;
        for (int num : varArgs) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(num);
            if (head == null) {
                head = newNode;
                ptr = head;
            } else {
                ptr.next = newNode;
                newNode.prev = ptr;
                ptr = newNode;
            }
        }

        return head;
    }

    @Override
    public void forwardTraversal(DoublyLinkedListNode head) {
        DoublyLinkedListNode ptr = head;

        while (ptr != null) {
            if (ptr.next != null) {
                System.out.print(ptr.val + " - ");
            } else {
                System.out.println(ptr.val);
            }
            ptr = ptr.next;
        }
    }

    @Override
    public void backwardTraversal(DoublyLinkedListNode head) {
        DoublyLinkedListNode ptr = head;

        while (ptr != null && ptr.next != null) {
            ptr = ptr.next;
        }

        while (ptr != null) {
            if (ptr.prev != null) {
                System.out.print(ptr.val + " - ");
            } else {
                System.out.println(ptr.val);
            }
            ptr = ptr.prev;
        }
    }

    public void display(DoublyLinkedListNode head) {
        forwardTraversal(head);
        backwardTraversal(head);
    }

    @Override
    public DoublyLinkedListNode insert(DoublyLinkedListNode head, int number, int index) {
        if (head == null) return head;

        int length = findLength(head);
        if (index > length) {
            System.out.println("Invalid Index for a Doubly Linked List of length : " + length);
            return head;
        }

        DoublyLinkedListNode ptr = head, newNode = new DoublyLinkedListNode(number);

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            while (index > 1) {
                index--;
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            newNode.prev = ptr;
            ptr.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }

        return head;
    }

    @Override
    public int find(DoublyLinkedListNode head, int number) {
        DoublyLinkedListNode ptr = head;
        int index = 0;

        while (ptr != null) {
            if (ptr.val == number) return index;
            index++;
            ptr = ptr.next;
        }

        return -1;
    }

    @Override
    public int findLength(DoublyLinkedListNode head) {
        int length = 0;
        DoublyLinkedListNode ptr = head;

        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        return length;
    }

    @Override
    public DoublyLinkedListNode concat(DoublyLinkedListNode list1, DoublyLinkedListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        DoublyLinkedListNode ptr = list1;

        while (ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = list2;
        list2.prev = ptr;

        return list1;
    }

    @Override
    public DoublyLinkedListNode delete(DoublyLinkedListNode head, int number) {
        DoublyLinkedListNode ptr = head;

        while (head != null && head.val == number) {
            head = head.next;
            if (head == null) return null;
            head.prev = null;
            ptr.next = null;
            ptr = head;
        }

        while (ptr != null) {
            DoublyLinkedListNode temp = null;
            if (ptr.val == number) {
                if (ptr.next == null) {
                    ptr.prev.next = null;
                    ptr.prev = null;
                } else {
                    temp = ptr.next;
                    ptr.next.prev = ptr.prev;
                    ptr.prev.next = ptr.next;
                    ptr.next = null;
                    ptr.prev = null;
                }
            }
            if (temp != null)
                ptr = temp;
            else
                ptr = ptr.next;
        }

        return head;
    }

    @Override
    public int findMiddleNumber(DoublyLinkedListNode head) {
        if (head == null) return -1;

        DoublyLinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

    @Override
    public boolean isPalindrome(DoublyLinkedListNode head) {
        if (head == null) return false;

        DoublyLinkedListNode front = head, rear = head;

        while (rear.next != null) {
            rear = rear.next;
        }

        while (front != rear) {
            if (front.val != rear.val) {
                return false;
            }
            front = front.next;
            rear = rear.prev;
        }

        return true;
    }

    @Override
    public DoublyLinkedListNode copy(DoublyLinkedListNode head) {
        DoublyLinkedListNode list = null, tail = null, ptr = head;

        while (ptr != null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(ptr.val);
            if (list == null) {
                list = newNode;
                tail = list;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            ptr = ptr.next;
        }

        return list;
    }

    @Override
    public DoublyLinkedListNode deleteEntireList(DoublyLinkedListNode head) {
        DoublyLinkedListNode ptr = head;

        while (head != null) {
            head = head.next;
            ptr.next = null;
            ptr.prev = null;
            if (head != null)
                head.prev = null;
            ptr = head;
        }

        return head;
    }

    @Override
    public DoublyLinkedListNode mergeSortedLinkedLists(DoublyLinkedListNode list1, DoublyLinkedListNode list2, boolean ascending) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) return mergeSortedLinkedLists(list2, list1, ascending);

        DoublyLinkedListNode head1 = list1, tail1, head2 = list2, tail2;

        while (head1 != null && head2 != null) {
            if ((ascending && head1.val < head2.val) || (!ascending && head1.val >= head2.val)) {
                tail1 = head1;
                head1 = head1.next;
                if (head1 == null || (ascending && head2.val <= head1.val) || (!ascending && head2.val >= head1.val)) {
                    tail1.next = head2;
                    head2.prev = tail1;
                }
            } else {
                tail2 = head2;
                head2 = head2.next;
                if (head2 == null || (ascending && head1.val <= head2.val) || (!ascending && head1.val >= head2.val)) {
                    tail2.next = head1;
                    head1.prev = tail2;
                }
            }
        }

        return ascending ? list1 : list2;
    }

    @Override
    public DoublyLinkedListNode findUnion(DoublyLinkedListNode list1, DoublyLinkedListNode list2) {
        Set<Integer> set = new HashSet<Integer>();
        DoublyLinkedListNode ptr = list1, head = null, tail = null;

        while (ptr != null) {
            set.add(ptr.val);
            ptr = ptr.next;
        }

        ptr = list2;

        while (ptr != null) {
            set.add(ptr.val);
            ptr = ptr.next;
        }

        for (Integer num : set) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(num);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        return head;
    }

    @Override
    public DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode ptr = head;

        while (ptr != null) {
            DoublyLinkedListNode temp = ptr.next;
            if (temp == null) head = ptr;

            ptr.next = ptr.prev;
            ptr.prev = temp;

            ptr = temp;
        }

        return head;
    }

    @Override
    public DoublyLinkedListNode reverseUsingRecursion(DoublyLinkedListNode head) {
        if (head == null) return head;

        head.prev = head.next;

        if (head.next == null) return head;

        DoublyLinkedListNode newHead = reverseUsingRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
