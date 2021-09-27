package newcode;

public class NC118_InverseParis {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        int res = 0;
        if (array[0] > array[1]) {
            int temp = array[0];
            array[0] = array[1];
            array[1] = temp;
            res++;
        }
        for (int i = 2; i < array.length; i++) {
            int target = array[i];
            int position = findPosition(array, target, i);
            res += (i - position) % 1000000007;
            res = res % 1000000007;
            for (int j = i; j > position; j--) {
                array[j] = array[j - 1];
            }
            array[position] = target;
        }
        return res;
    }

    private int findPosition(int[] array, int target, int index) {
        int left = 0, right = index - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (array[left] < target) {
            return left + 1;
        }
        return left;
    }
}
