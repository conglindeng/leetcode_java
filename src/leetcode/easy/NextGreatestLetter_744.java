package leetcode.easy;

public class NextGreatestLetter_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target < letters[0] || target >= letters[length - 1]) {
            return letters[0];
        }

        //二分查找 找
        int left = 0, right = length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left - 1) / 2;
            //mid = left + (right - left ) / 2; equals to prev statement
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }
}
