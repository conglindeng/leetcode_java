package algorithm;

public class BinarySearch {

    private BinarySearch() {
    }

    public static int binarySearch(int[] array, int target) {
        int result = -1;
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == target) {
                result = middle;
                break;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return result;
    }

    public static int findFirstEqual(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                int i = mid;
                for (; i > 0; i--) {
                    if (array[i - 1] != array[i]) {
                        return i;
                    }
                }
                return i;
            } else if (array[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int finFirstMoreThanOrEqual(int[] array, int target) {
        if (array == null || array.length == 0 || array[array.length - 1] < target) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static int findLastLessThanOrEqual(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (array[left] > target) {
            return -1;
        }
        return left;
    }


    /**
     * 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
     * nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，让数组变为[nums[t], nums[t+1], ...,
     * nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
     * 比如，数组[0,2,4,6,8,10]在下标3处旋转之后变为[6,8,10,0,2,4]
     * 现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，如果存在，那么返回它的下标，如果不存在，返回-1
     *
     * @param array
     * @param target
     * @return
     */
    public static int findElementInRotatedMatrix(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            int i = array[mid];
            if (i == target) {
                return mid;
            }
            if (array[left] <= i) {
                if (target >= array[left] && array[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (i <= target && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}