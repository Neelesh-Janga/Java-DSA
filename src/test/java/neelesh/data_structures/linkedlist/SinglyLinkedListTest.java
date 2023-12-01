package test.java.neelesh.data_structures.linkedlist;

import main.java.neelesh.data_structures.linkedlist.SinglyLinkedList;
import main.java.neelesh.data_structures.linkedlist.nodes.SinglyLinkedListNode;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        testCreate();
        testDisplay();
        testInsert();
        testFind();
        testFindLength();
        testConcat();
        testReverse();
        testReverseUsingRecursion();
        testIsLooped();
        testDelete();
        testFindMiddleNumber();
        testIsPalindrome();
        testCopy();
        testGetIntersectionNode();
        testDeleteEntireList();
        testRemoveLoop();
        testMergeSortedLinkedLists();
        testFindUnion();
    }

    private static void testCreate() {
        SinglyLinkedList operations = new SinglyLinkedList();
        System.out.println("*** Creating LinkedList ***");
        // Test Case 1: Create an empty list
        SinglyLinkedListNode list1 = operations.create();
        operations.display(list1); // Expected: (empty list)

        // Test Case 2: Create a list with elements
        SinglyLinkedListNode list2 = operations.create(1, 2, 3, 4, 5);
        operations.display(list2); // Expected: 1 --> 2 --> 3 --> 4 --> 5
    }

    private static void testDisplay() {
        SinglyLinkedList operations = new SinglyLinkedList();
        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Display a non-empty list
        System.out.println("*** Displaying LinkedList ***");
        operations.display(list); // Expected: 1 --> 2 --> 3 --> 4 --> 5

        // Test Case 2: Display an empty list
        SinglyLinkedListNode emptyList = null;
        operations.display(emptyList); // Expected: (empty list)
    }

    private static void testInsert() {
        SinglyLinkedList operations = new SinglyLinkedList();
        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        System.out.println("*** Inserting Elements in a LinkedList ***");

        // Test Case 1: Insert at the beginning
        list = operations.insert(list, 10, 0);
        operations.display(list); // Expected: 10 --> 1 --> 2 --> 3 --> 4 --> 5

        // Test Case 2: Insert in the middle
        list = operations.insert(list, 20, 3);
        operations.display(list); // Expected: 10 --> 1 --> 2 --> 20 --> 3 --> 4 --> 5

        // Test Case 3: Insert at the end
        list = operations.insert(list, 30, 7);
        operations.display(list); // Expected: 10 --> 1 --> 2 --> 20 --> 3 --> 4 --> 5 --> 30
    }

    private static void testFind() {
        SinglyLinkedList operations = new SinglyLinkedList();
        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        System.out.println("*** Finding Element in a LinkedList ***");

        // Test Case 1: Find an existing element
        int index1 = operations.find(list, 3);
        System.out.println("Index of 3: " + index1); // Expected: 2

        // Test Case 2: Find a non-existing element
        int index2 = operations.find(list, 10);
        System.out.println("Index of 10: " + index2); // Expected: -1
    }

    private static void testFindLength() {
        SinglyLinkedList operations = new SinglyLinkedList();
        System.out.println("*** Finding Length of a LinkedList ***");

        // Test Case 1: Find length of an empty list
        SinglyLinkedListNode emptyList = null;
        int length1 = operations.findLength(emptyList);
        System.out.println("Length of empty list: " + length1); // Expected: 0

        // Test Case 2: Find length of a non-empty list
        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        int length2 = operations.findLength(list);
        System.out.println("Length of the list: " + length2); // Expected: 5
    }

    private static void testConcat() {
        SinglyLinkedList operations = new SinglyLinkedList();
        System.out.println("*** Concatenating Two LinkedLists ***");

        SinglyLinkedListNode list1 = operations.create(1, 2, 3);
        SinglyLinkedListNode list2 = operations.create(4, 5, 6);

        // Test Case 1: Concatenate two non-empty lists
        list1 = operations.concat(list1, list2);
        operations.display(list1); // Expected: 1 --> 2 --> 3 --> 4 --> 5 --> 6

        // Test Case 2: Concatenate with an empty list
        SinglyLinkedListNode emptyList = null;
        list1 = operations.concat(list1, emptyList);
        operations.display(list1); // Expected: 1 --> 2 --> 3 --> 4 --> 5 --> 6
    }

    private static void testReverse() {
        SinglyLinkedList operations = new SinglyLinkedList();
        System.out.println("*** Reversing a LinkedList ***");

        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Reverse a non-empty list
        SinglyLinkedListNode reversedList1 = operations.reverse(list);
        operations.display(reversedList1); // Expected: 5 --> 4 --> 3 --> 2 --> 1

        // Test Case 2: Reverse an empty list
        SinglyLinkedListNode emptyList = null;
        SinglyLinkedListNode reversedList2 = operations.reverse(emptyList);
        operations.display(reversedList2); // Expected: (empty list)
    }

    private static void testReverseUsingRecursion() {
        SinglyLinkedList operations = new SinglyLinkedList();
        System.out.println("*** Reversing a LinkedList using Recursion ***");

        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Reverse using recursion for a non-empty list
        SinglyLinkedListNode reversedList1 = operations.reverseUsingRecursion(list);
        operations.display(reversedList1); // Expected: 5 --> 4 --> 3 --> 2 --> 1

        // Test Case 2: Reverse using recursion for an empty list
        SinglyLinkedListNode emptyList = null;
        SinglyLinkedListNode reversedList2 = operations.reverseUsingRecursion(emptyList);
        operations.display(reversedList2); // Expected: (empty list)
    }

    private static void testIsLooped() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Checking for a Loop in a LinkedList ***");

        // Test Case 1: Check if a non-empty list has a loop
        SinglyLinkedListNode list1 = operations.create(1, 2, 3, 4, 5);
        System.out.println("Is list1 looped? " + operations.isLooped(list1)); // Expected: false

        // Test Case 2: Check if an empty list has a loop
        SinglyLinkedListNode emptyList = null;
        System.out.println("Is emptyList looped? " + operations.isLooped(emptyList)); // Expected: false

        // Test Case 3: Check if a list with a loop is detected
        SinglyLinkedListNode listWithLoop = operations.create(1, 2, 3, 4, 5);
        SinglyLinkedListNode lastNode = listWithLoop;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = listWithLoop.next; // Creating a loop
        System.out.println("Is listWithLoop looped? " + operations.isLooped(listWithLoop)); // Expected: true
    }

    private static void testDelete() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Deleting an Element from a LinkedList ***");

        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5, 2, 6, 7, 2, 8, 9);

        // Test Case 1: Delete an element that occurs multiple times
        list = operations.delete(list, 2);
        operations.display(list); // Expected: 1 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9

        // Test Case 2: Delete the first element
        list = operations.delete(list, 1);
        operations.display(list); // Expected: 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9

        // Test Case 3: Delete the last element
        list = operations.delete(list, 9);
        operations.display(list); // Expected: 3 --> 4 --> 5 --> 6 --> 7 --> 8

        list = operations.delete(operations.create(1,1,1,1,1,2), 1);
        operations.display(list); // Expected: 2
    }

    private static void testFindMiddleNumber() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Finding Middle Node in a LinkedList ***");

        // Test Case 1: Find middle number in an odd-length list
        SinglyLinkedListNode oddList = operations.create(1, 2, 3, 4, 5);
        int middle1 = operations.findMiddleNumber(oddList);
        System.out.println("Middle number in oddList: " + middle1); // Expected: 3

        // Test Case 2: Find middle number in an even-length list
        SinglyLinkedListNode evenList = operations.create(1, 2, 3, 4, 5, 6);
        int middle2 = operations.findMiddleNumber(evenList);
        System.out.println("Middle number in evenList: " + middle2); // Expected: 3
    }

    private static void testIsPalindrome() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Checking if a LinkedList is Palindrome or Not ***");

        // Test Case 1: Check if a palindrome list is detected
        SinglyLinkedListNode palindromeList = operations.create(1, 2, 3, 2, 1);
        System.out.println("Is palindromeList a palindrome? " + operations.isPalindrome(palindromeList)); // Expected: true

        // Test Case 2: Check if a non-palindrome list is detected
        SinglyLinkedListNode nonPalindromeList = operations.create(1, 2, 3, 4, 5);
        System.out.println("Is nonPalindromeList a palindrome? " + operations.isPalindrome(nonPalindromeList)); // Expected: false
    }

    private static void testCopy() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Copying Elements in a LinkedList ***");

        SinglyLinkedListNode originalList = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Copy a non-empty list
        SinglyLinkedListNode copiedList = operations.copy(originalList);
        operations.display(copiedList); // Expected: 1 --> 2 --> 3 --> 4 --> 5

        // Test Case 2: Copy an empty list
        SinglyLinkedListNode emptyList = null;
        SinglyLinkedListNode copiedEmptyList = operations.copy(emptyList);
        operations.display(copiedEmptyList); // Expected: (empty list)
    }

    private static void testGetIntersectionNode() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Checking if any Common Node is present in given LinkedLists ***");

        // Test Case 1: Get intersection node with non-empty lists
        SinglyLinkedListNode list1 = operations.create(1, 2, 3, 4, 5);
        SinglyLinkedListNode list2 = operations.create(6, 7);

        SinglyLinkedListNode ptr = list2;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = list1.next.next.next;

        SinglyLinkedListNode intersectionNode1 = operations.getIntersectionNode(list1, list2);

        System.out.println("Intersection node value: " + (intersectionNode1 != null ? intersectionNode1.val : null)); // Expected: 4

        // Test Case 2: Get intersection node with empty lists
        SinglyLinkedListNode emptyList1 = null;
        SinglyLinkedListNode emptyList2 = null;

        SinglyLinkedListNode intersectionNode2 = operations.getIntersectionNode(emptyList1, emptyList2);

        System.out.println("Intersection node value: " + (intersectionNode2 != null ? intersectionNode2.val : null)); // Expected: null
    }

    private static void testDeleteEntireList() {
        SinglyLinkedList operations = new SinglyLinkedList();

        System.out.println("*** Deleing Entire LinkedList ***");

        SinglyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Delete entire non-empty list
        list = operations.deleteEntireList(list);
        operations.display(list); // Expected: (empty list)

        // Test Case 2: Delete entire empty list
        SinglyLinkedListNode emptyList = null;
        operations.deleteEntireList(emptyList);
        operations.display(emptyList); // Expected: (empty list)
    }

    private static void testRemoveLoop() {
        SinglyLinkedList operations = new SinglyLinkedList();

        // Test Case 1: Removing a loop
        SinglyLinkedListNode list1 = createLinkedListWithLoop();
        operations.removeLoop(list1);
        System.out.print("List1 after removing loop: ");
        operations.display(list1); // Expected: No loop detected

        // Test Case 2: Remove loop in a non-empty list without a loop
        SinglyLinkedListNode list2 = operations.create(1, 2, 3, 4, 5);
        System.out.print("List2 before removing loop: ");
        operations.removeLoop(list2);

        // Test Case 3: Remove loop in an empty list
        SinglyLinkedListNode emptyList = null;
        operations.removeLoop(emptyList); // Expected: No loop detected
    }

    private static SinglyLinkedListNode createLinkedListWithLoop() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = new SinglyLinkedListNode(4);
        head.next.next.next.next = new SinglyLinkedListNode(5);

        // Creating a loop
        head.next.next.next.next.next = head.next.next;

        return head;
    }

    private static void testMergeSortedLinkedLists() {
        SinglyLinkedList operations = new SinglyLinkedList();

        // Test Case 1: Merge two non-empty sorted lists in ascending order
        SinglyLinkedListNode list1 = operations.create(1, 3, 5, 7);
        SinglyLinkedListNode list2 = operations.create(2, 4, 6, 8);
        SinglyLinkedListNode mergedList1 = operations.mergerSortedLinkedLists(list1, list2, true);
        System.out.print("Merged list in ascending order: ");
        operations.display(mergedList1); // Expected: 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8

        // Test Case 2: Merge two non-empty sorted lists in descending order
        SinglyLinkedListNode list3 = operations.create(9, 7, 5, 3);
        SinglyLinkedListNode list4 = operations.create(8, 6, 4, 2);
        SinglyLinkedListNode mergedList2 = operations.mergerSortedLinkedLists(list3, list4, false);
        System.out.print("Merged list in descending order: ");
        operations.display(mergedList2); // Expected: 9 --> 8 --> 7 --> 6 --> 5 --> 4 --> 3 --> 2

        // Test Case 3: Merge an empty list with a non-empty list
        SinglyLinkedListNode emptyList = null;
        SinglyLinkedListNode mergedList3 = operations.mergerSortedLinkedLists(emptyList, list1, true);
        System.out.print("Merged list with an empty list: ");
        operations.display(mergedList3); // Expected: 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8

        // Test Case 4: Merge two empty lists
        SinglyLinkedListNode mergedList4 = operations.mergerSortedLinkedLists(emptyList, emptyList, true);
        System.out.print("Merged empty list: ");
        operations.display(mergedList4); // Expected: (empty list)

        // Test Case 5: Merge two lists with some common elements
        SinglyLinkedListNode list5 = operations.create(1, 2, 3);
        SinglyLinkedListNode list6 = operations.create(2, 3, 4);
        SinglyLinkedListNode mergedList5 = operations.mergerSortedLinkedLists(list5, list6, true);
        System.out.print("\nMerged list with common elements: ");
        operations.display(mergedList5); // Expected: 1 --> 2 --> 2 --> 3 --> 3 --> 4

        // Test Case 6: Merge two lists with some common elements
        SinglyLinkedListNode list7 = operations.create(1, 2, 3, 3);
        SinglyLinkedListNode list8 = operations.create(2, 3, 4, 5, 6, 6, 6, 7);
        SinglyLinkedListNode mergedList6 = operations.mergerSortedLinkedLists(list7, list8, true);
        System.out.print("Merged list with common elements: ");
        operations.display(mergedList6); // Expected: 1 --> 2 --> 2 --> 3 --> 3 --> 3 --> 4 --> 5 --> 6 --> 6 --> 6 --> 7
    }

    private static void testFindUnion() {
        SinglyLinkedList operations = new SinglyLinkedList();

        // Test Case 1: Find union of two non-empty lists
        SinglyLinkedListNode list1 = operations.create(1, 2, 3, 4, 5);
        SinglyLinkedListNode list2 = operations.create(3, 4, 5, 6, 7);
        SinglyLinkedListNode unionList1 = operations.findUnion(list1, list2);
        System.out.print("Union of list1 and list2: ");
        operations.display(unionList1); // Expected: 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7

        // Test Case 2: Find union of an empty list with a non-empty list
        SinglyLinkedListNode emptyList = null;
        SinglyLinkedListNode unionList2 = operations.findUnion(emptyList, list1);
        System.out.print("Union of an empty list and list1: ");
        operations.display(unionList2); // Expected: 1 --> 2 --> 3 --> 4 --> 5

        // Test Case 3: Find union of two empty lists
        SinglyLinkedListNode unionList3 = operations.findUnion(emptyList, emptyList);
        System.out.print("Union of empty lists: ");
        operations.display(unionList3); // Expected: (empty list)
    }
}
