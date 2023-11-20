package essay.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        Random random = new Random();
        QuickSort quickSort = new QuickSort();
        InsertionSort insertionSort = new InsertionSort();
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();
        int size = 4 + random.nextInt(5);
        for (int i = 0; i < 1000; i++) {
            List<Integer> nums = new ArrayList<>();
            int[] numArray = new int[size];
            for (int j = 0; j < size; j++) {
                int e = random.nextInt(20);
                nums.add(e);
                numArray[j] = e;
            }
            ArrayList<Integer> copy = new ArrayList<>(nums);
            System.out.println(copy);
            Collections.sort(nums);
//            quickSort.quickSort(numArray);
//            insertionSort.insertionSort(numArray);
//            bubbleSort.bubbleSort(numArray);
//            selectionSort.selectionSort(numArray);
            numArray = mergeSort.mergeSort(numArray);
            for (int j = 0; j < size; j++) {
                if (nums.get(j) != numArray[j]) {
                    System.out.println("source: " + copy);
                    System.out.println(nums);
                    System.out.println(Arrays.toString(numArray));
                    throw new RuntimeException();
                }
            }
        }
        System.out.println(" Perfect sort ");
    }
}
