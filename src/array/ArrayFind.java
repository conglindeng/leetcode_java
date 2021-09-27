package array;

public class ArrayFind {
    
    public boolean Find(int target, int[][] array) {
        int lastLessThanOrEquals = findLastLessThanOrEquals(target, array);
        if (lastLessThanOrEquals == -1) {
            return false;
        }
        return findTargetInArray(array[lastLessThanOrEquals], target) == -1;
    }

    private int findLastLessThanOrEquals(int target, int[][] array) {
        int left = 0, right = array.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (array[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (array[left][0] > target) {
            return -1;
        }
        return left;
    }

    private int findTargetInArray(int[] array, int target) {
        int left = 0, right = array.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
