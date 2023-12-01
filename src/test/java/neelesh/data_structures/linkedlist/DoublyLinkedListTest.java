package test.java.neelesh.data_structures.linkedlist;

import main.java.neelesh.data_structures.linkedlist.DoublyLinkedList;
import main.java.neelesh.data_structures.linkedlist.nodes.DoublyLinkedListNode;

public class DoublyLinkedListTest {

    public static void main(String[] args) {
        testCreate();
        testDisplay();
        testInsert();
        testFind();
        testFindLength();
        testConcat();
        testDelete();
        testIsPalindrome();
        testCopy();
        testDeleteEntireList();
        testReverse();
        testReverseUsingRecursion();
        testFindUnion();
        testMergeSortedLinkedLists();
    }

    private static void testCreate() {
        DoublyLinkedList operations = new DoublyLinkedList();
        System.out.println("*** Creating Doubly LinkedList ***");

        // Test Case 1: Create an empty list
        DoublyLinkedListNode list1 = operations.create();
        operations.display(list1); // Expected: (empty list)

        // Test Case 2: Create a list with elements
        DoublyLinkedListNode list2 = operations.create(1, 2, 3, 4, 5);
        operations.display(list2); // Expected: (FW) 1 - 2 - 3 - 4 - 5 ::: (BW) 5 - 4 - 3 - 2 - 1
    }

    private static void testDisplay() {
        DoublyLinkedList operations = new DoublyLinkedList();
        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Display a non-empty list
        System.out.println("*** Forward & Backward Traversals of Doubly LinkedList ***");
        operations.display(list); // Expected: (FW) 1 - 2 - 3 - 4 - 5 ::: (BW) 5 - 4 - 3 - 2 - 1

        // Test Case 2: Display an empty list
        DoublyLinkedListNode emptyList = null;
        operations.display(emptyList); // Expected: (empty list)
    }

    private static void testInsert() {
        DoublyLinkedList operations = new DoublyLinkedList();
        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        System.out.println("*** Inserting Elements in a Doubly LinkedList ***");

        // Test Case 1: Insert at the beginning
        list = operations.insert(list, 10, 0);
        operations.forwardTraversal(list);  // Expected: 10 - 1 - 2 - 3 - 4 - 5
        operations.backwardTraversal(list); // Expected: 5 - 4 - 3 - 2 - 1 - 10

        // Test Case 2: Insert in the middle
        list = operations.insert(list, 20, 3);
        operations.forwardTraversal(list);  // Expected: 10 - 1 - 2 - 20 - 3 - 4 - 5
        operations.backwardTraversal(list); // Expected: 5 - 4 - 3 - 20 - 2 - 1 - 10

        // Test Case 3: Insert at the end
        list = operations.insert(list, 30, 7);
        operations.forwardTraversal(list);  // Expected: 10 - 1 - 2 - 20 - 3 - 4 - 5 - 30
        operations.backwardTraversal(list); // Expected: 30 - 5 - 4 - 3 - 20 - 2 - 1 - 10
    }

    private static void testFind() {
        DoublyLinkedList operations = new DoublyLinkedList();
        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        System.out.println("*** Finding Element in a Doubly LinkedList ***");

        // Test Case 1: Find an existing element
        int index1 = operations.find(list, 3);
        System.out.println("Index of 3: " + index1); // Expected: 2

        // Test Case 2: Find a non-existing element
        int index2 = operations.find(list, 10);
        System.out.println("Index of 10: " + index2); // Expected: -1
    }

    private static void testFindLength() {
        DoublyLinkedList operations = new DoublyLinkedList();
        System.out.println("*** Finding Length of a Doubly LinkedList ***");

        // Test Case 1: Find length of an empty list
        DoublyLinkedListNode emptyList = null;
        int length1 = operations.findLength(emptyList);
        System.out.println("Length of empty list: " + length1); // Expected: 0

        // Test Case 2: Find length of a non-empty list
        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);
        int length2 = operations.findLength(list);
        System.out.println("Length of the list: " + length2); // Expected: 5
    }

    private static void testConcat() {
        DoublyLinkedList operations = new DoublyLinkedList();
        System.out.println("*** Concatenating Two LinkedLists ***");

        DoublyLinkedListNode list1 = operations.create(1, 2, 3);
        DoublyLinkedListNode list2 = operations.create(4, 5, 6);

        // Test Case 1: Concatenate two non-empty lists
        list1 = operations.concat(list1, list2);
        operations.display(list1); // Expected: (FW) 1 - 2 - 3 - 4 - 5 - 6 ::: (BW) 6 - 5 - 4 - 3 - 2 - 1

        // Test Case 2: Concatenate with an empty list
        DoublyLinkedListNode emptyList = null;
        list1 = operations.concat(list1, emptyList);
        operations.display(list1); // Expected: (FW) 1 - 2 - 3 - 4 - 5 - 6 ::: (BW) 6 - 5 - 4 - 3 - 2 - 1
    }

    private static void testDelete() {
        DoublyLinkedList operations = new DoublyLinkedList();

        System.out.println("*** Deleting an Element from a Doubly LinkedList ***");

        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5, 2, 6, 7, 2, 8, 9);

        // Test Case 1: Delete an element that occurs multiple times
        list = operations.delete(list, 2);
        operations.display(list); // Expected: (FW) 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 ::: (BW) 9 - 8 - 7 - 6 - 5 - 4 - 3 - 1

        // Test Case 2: Delete the first element
        list = operations.delete(list, 1);
        operations.display(list); // Expected: (FW) 3 - 4 - 5 - 6 - 7 - 8 - 9 ::: (BW) 9 - 8 - 7 - 6 - 5 - 4 - 3

        // Test Case 3: Delete the last element
        list = operations.delete(list, 9);
        operations.display(list); // Expected: (FW) 3 - 4 - 5 - 6 - 7 - 8 ::: (BW) 8 - 7 - 6 - 5 - 4 - 3

        // Test Case 4
        list = operations.create(1, 1, 1, 1, 2);
        list = operations.delete(list, 1);
        operations.display(list); // Expected: (FW) 2 ::: (BW) 2

        // Test Case 4
        list = operations.create(1, 2, 2, 2, 2);
        list = operations.delete(list, 2);
        operations.display(list); // Expected: (FW) 1 ::: (BW) 1
    }

    private static void testIsPalindrome() {
        DoublyLinkedList operations = new DoublyLinkedList();

        System.out.println("*** Checking if a Doubly LinkedList is Palindrome or Not ***");

        // Test Case 1: Check if a palindrome list is detected
        DoublyLinkedListNode palindromeList = operations.create(1, 2, 3, 2, 1);
        System.out.println("Is palindromeList a palindrome? " + operations.isPalindrome(palindromeList)); // Expected: true

        // Test Case 2: Check if a palindrome list is detected
        palindromeList = operations.create(1, 2, 3, 3, 2, 1);
        System.out.println("Is palindromeList a palindrome? " + operations.isPalindrome(palindromeList)); // Expected: true

        // Test Case 3: Check if a non-palindrome list is detected
        DoublyLinkedListNode nonPalindromeList = operations.create(1, 2, 3, 4, 5);
        System.out.println("Is nonPalindromeList a palindrome? " + operations.isPalindrome(nonPalindromeList)); // Expected: false
    }

    private static void testCopy() {
        DoublyLinkedList operations = new DoublyLinkedList();

        System.out.println("*** Copying Elements from a Doubly LinkedList ***");

        DoublyLinkedListNode originalList = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Copy a non-empty list
        DoublyLinkedListNode copiedList = operations.copy(originalList);
        operations.display(copiedList); // Expected: (FW) 1 - 2 - 3 - 4 - 5 ::: (BW) 5 - 4 - 3 - 2 - 1

        // Test Case 2: Copy an empty list
        DoublyLinkedListNode emptyList = null;
        DoublyLinkedListNode copiedEmptyList = operations.copy(emptyList);
        operations.display(copiedEmptyList); // Expected: (empty list)
    }

    private static void testDeleteEntireList() {
        DoublyLinkedList operations = new DoublyLinkedList();

        System.out.println("*** Deleting Entire Doubly LinkedList ***");

        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Delete entire non-empty list
        list = operations.deleteEntireList(list);
        operations.display(list); // Expected: (empty list)

        // Test Case 2: Delete entire empty list
        DoublyLinkedListNode emptyList = null;
        operations.deleteEntireList(emptyList);
        operations.display(emptyList); // Expected: (empty list)
    }

    private static void testReverse() {
        DoublyLinkedList operations = new DoublyLinkedList();
        System.out.println("*** Reversing a Doubly LinkedList ***");

        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Reverse a non-empty list
        DoublyLinkedListNode reversedList1 = operations.reverse(list);
        operations.display(reversedList1); // Expected: (FW) 5 - 4 - 3 - 2 - 1 ::: (BW) 1 - 2 - 3 - 4 - 5

        // Test Case 2: Reverse an empty list
        DoublyLinkedListNode emptyList = null;
        DoublyLinkedListNode reversedList2 = operations.reverse(emptyList);
        operations.display(reversedList2); // Expected: (empty list)
    }

    private static void testReverseUsingRecursion() {
        DoublyLinkedList operations = new DoublyLinkedList();
        System.out.println("*** Reversing a Doubly LinkedList using Recursion ***");

        DoublyLinkedListNode list = operations.create(1, 2, 3, 4, 5);

        // Test Case 1: Reverse using recursion for a non-empty list
        DoublyLinkedListNode reversedList1 = operations.reverseUsingRecursion(list);
        operations.display(reversedList1); // Expected: (FW) 5 - 4 - 3 - 2 - 1 ::: (BW) 1 - 2 - 3 - 4 - 5

        // Test Case 2: Reverse using recursion for an empty list
        DoublyLinkedListNode emptyList = null;
        DoublyLinkedListNode reversedList2 = operations.reverseUsingRecursion(emptyList);
        operations.display(reversedList2); // Expected: (empty list)
    }

    private static void testFindUnion() {
        DoublyLinkedList operations = new DoublyLinkedList();

        // Test Case 1: Find union of two non-empty lists
        DoublyLinkedListNode list1 = operations.create(1, 2, 3, 4, 5);
        DoublyLinkedListNode list2 = operations.create(3, 4, 5, 6, 7);
        DoublyLinkedListNode unionList1 = operations.findUnion(list1, list2);
        System.out.println("Union of list1 and list2:");
        operations.display(unionList1); // Expected: (FW) 1 - 2 - 3 - 4 - 5 - 6 - 7 ::: (BW) 7 - 6 - 5 - 4 - 3 - 2 - 1

        // Test Case 2: Find union of an empty list with a non-empty list
        DoublyLinkedListNode emptyList = null;
        DoublyLinkedListNode unionList2 = operations.findUnion(emptyList, list1);
        System.out.println("Union of an empty list and list1:");
        operations.display(unionList2); // Expected: (FW) 1 - 2 - 3 - 4 - 5 ::: (BW) 5 - 4 - 3 - 2 - 1

        // Test Case 3: Find union of two empty lists
        DoublyLinkedListNode unionList3 = operations.findUnion(emptyList, emptyList);
        System.out.println("Union of empty lists:");
        operations.display(unionList3); // Expected: (empty list)
    }

    private static void testMergeSortedLinkedLists() {
        DoublyLinkedList operations = new DoublyLinkedList();

        // Test Case 1: Merge two non-empty sorted lists in ascending order
        DoublyLinkedListNode list1 = operations.create(1, 3, 5, 7);
        DoublyLinkedListNode list2 = operations.create(2, 4, 6, 8);
        DoublyLinkedListNode mergedList1 = operations.mergerSortedLinkedLists(list1, list2, true);
        System.out.println("Merged list in ascending order:");
        operations.display(mergedList1); // Expected: (FW) 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 ::: (BW) 8 - 7 - 6 - 5 - 4 - 3 - 2 - 1

        // Test Case 2: Merge two non-empty sorted lists in descending order
        DoublyLinkedListNode list3 = operations.create(9, 7, 5, 3);
        DoublyLinkedListNode list4 = operations.create(8, 6, 4, 2);
        DoublyLinkedListNode mergedList2 = operations.mergerSortedLinkedLists(list3, list4, false);
        System.out.println("Merged list in descending order:");
        operations.display(mergedList2); // Expected: (FW) 9 - 8 - 7 - 6 - 5 - 4 - 3 - 2 ::: (BW) 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9

        // Test Case 3: Merge an empty list with a non-empty list
        DoublyLinkedListNode emptyList = null;
        DoublyLinkedListNode mergedList3 = operations.mergerSortedLinkedLists(emptyList, list1, true);
        System.out.println("Merged list with an empty list:");
        operations.display(mergedList3); // Expected: (FW) 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 ::: (BW) 8 - 7 - 6 - 5 - 4 - 3 - 2 - 1

        // Test Case 4: Merge two empty lists
        DoublyLinkedListNode mergedList4 = operations.mergerSortedLinkedLists(emptyList, emptyList, true);
        System.out.println("Merged empty list:");
        operations.display(mergedList4); // Expected: (empty list)

        // Test Case 5: Merge two lists with some common elements
        DoublyLinkedListNode list5 = operations.create(1, 2, 3);
        DoublyLinkedListNode list6 = operations.create(2, 3, 4);
        DoublyLinkedListNode mergedList5 = operations.mergerSortedLinkedLists(list5, list6, true);
        System.out.println("Merged list with common elements:");
        operations.display(mergedList5); // Expected: (FW) 1 - 2 - 2 - 3 - 3 - 4 ::: (BW) 4 - 3 - 3 - 2 - 2 - 1

        // Test Case 6: Merge two lists with some common elements
        DoublyLinkedListNode list7 = operations.create(1, 2, 3, 3);
        DoublyLinkedListNode list8 = operations.create(2, 3, 4, 5, 6, 6, 6, 7);
        DoublyLinkedListNode mergedList6 = operations.mergerSortedLinkedLists(list7, list8, true);
        System.out.println("Merged list with common elements:");
        operations.display(mergedList6); // Expected: (FW) 1 - 2 - 2 - 3 - 3 - 3 - 4 - 5 - 6 - 6 - 6 - 7 ::: (BW) 7 - 6 - 6 - 6 - 5 - 4 - 3 - 3 - 3 - 2 - 2 - 1
    }
}
