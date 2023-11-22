package essay.sort;

public class ShellSort {

    public void shellSort(int[] nums) {
        int n = nums.length;
        int step = n / 2;
        for (; step > 0; step = step / 2) {
            for (int i = step; i < n; i++) {
                int temp = nums[i];
                int position = i;
                while (position >= step && nums[position - step] > temp) {
                    nums[position] = nums[position - step];
                    position -= step;
                }
                nums[position] = temp;
            }
        }
    }
}
