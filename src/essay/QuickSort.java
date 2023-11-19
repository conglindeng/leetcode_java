package essay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 优化： 1、三数取中法 上面的代码思想都是直接拿序列的最后一个值作为枢轴，如果最后这个值刚好是整段序列最大或者最小的值，那么这次划分就是没意义的。
 * 所以当序列是正序或者逆序时，每次选到的枢轴都是没有起到划分的作用。快排的效率会极速退化。 所以可以每次在选枢轴时，在序列的第一，中间，最后三个值里面选一个中间值出来作为枢轴，保证每次划分接近均等。 2、直接插入
 * 由于是递归程序，每一次递归都要开辟栈帧，当递归到序列里的值不是很多时，我们可以采用直接插入排序来完成，从而避免这些栈帧的消耗。
 */

public class QuickSort {

    /*
     *  1.choose a basic number
     *  2.group by basic number, put on the left when num less than basic number, otherwise put on the right
     *  3.left range and right range do 1,2 steps again
     */
    public void quickSort(int[] nums) {
        doQuickSort_(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = nums[right];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            swap(nums, l, r);
        }
        swap(nums, l, right);
        doQuickSort(nums, left, l - 1);
        doQuickSort(nums, l + 1, right);
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }


    private void doQuickSort_(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = nums[right];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[l] <= key) {
                l++;
            }
            nums[r] = nums[l];
            while (l < r && nums[r] >= key) {
                r--;
            }
            nums[l] = nums[r];
        }
        nums[r] = key;
        doQuickSort_(nums, left, r - 1);
        doQuickSort_(nums, r + 1, right);

    }


    public static void main(String[] args) {
        Random random = new Random();
        QuickSort quickSort = new QuickSort();
        InsertionSort insertionSort = new InsertionSort();
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
            insertionSort.insertionSort(numArray);
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
