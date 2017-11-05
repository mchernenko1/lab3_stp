package lab3;

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[150];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        int[] clonedArray;
        Sorting sorting = new Sorting();

        System.out.println("Bubble sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.bubbleSort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }
        System.out.println("Quick sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.quickSort(clonedArray, 0, array.length - 1);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        System.out.println("Shell sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.shellSort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        System.out.println("Cycle sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.cycleSort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        System.out.println("Insertion sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.insertionSort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        System.out.println("Arrays.sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            Arrays.sort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        System.out.println("Heap sort");
        for(int i=0; i<3; i++) {
            clonedArray = array.clone();
            long startTime = System.nanoTime();
            sorting.heapSort(clonedArray);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
