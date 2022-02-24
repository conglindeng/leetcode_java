package leetcode.easy;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < chars.length && (chars[left] < 'A' || chars[left] > 'z' || (chars[left] < 'a' && chars[left] > 'Z'))) {
                left++;
            }
            while (right >= 0 && (chars[right] < 'A' || chars[right] > 'z' || (chars[right] < 'a' && chars[right] > 'Z'))) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
