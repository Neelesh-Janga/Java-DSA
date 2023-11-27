package main.java.neelesh.algorithms.array;

import static main.java.neelesh.service.ArrayHelper.ArrayScanner.getCharArray;

/*
 *  Linear Search Algorithm:
 *  Time Complexity - [Best, Average, Worst] = [O(1), O(N), O(N)]
 *  Space Complexity - [Best, Average, Worst] = [O(1), O(1), O(1)]
 *
 *  Applicable Data Structures: Arrays, Lists (ArrayList & LinkedList), String, Stack & Queue
 */
public class LinearSearch {
//    private static final int[] arr = getIntArray(10,99,8,1,3,2,4,6,11,12);
//    private static final Integer[] arr = getArray(10,9,8,1,3,2,4,6,11,12);
//    private static final int target = 9;
    private static final char[] arr = getCharArray('a', 'b', 'c', 'd');
    private static final char target = 'v';

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                System.out.println("Target element found at index: " + i);
                return;
            }
        }

        System.out.println("Target element not found!");
    }
}
