package main.java.neelesh.service;

import java.util.Scanner;

public class ArrayHelper {

    public static class ArrayPrinter {
        public static <T> void displayArray(T[] arr) {
            for (T val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(int[] arr) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(double[] arr) {
            for (double val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(char[] arr) {
            for (char val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(byte[] arr) {
            for (byte val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(short[] arr) {
            for (short val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(long[] arr) {
            for (long val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        public static void displayArray(float[] arr) {
            for (float val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static class ArrayScanner {
        private static Scanner sc = new Scanner(System.in);

        public static int[] getIntArray(int ...varArgs) {
            return varArgs;
        }

        public static double[] getDoubleArray(double ...varArgs) {
            return varArgs;
        }

        public static char[] getCharArray(char ...varArgs) {
            return varArgs;
        }

        public static <T extends Number> T[] getArray(T ...varArgs) {
            return varArgs;
        }

        public static String[] getArray(String ...varArgs) {
            return varArgs;
        }
    }
}
