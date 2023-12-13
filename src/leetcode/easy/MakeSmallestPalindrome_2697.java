package leetcode.easy;

public class MakeSmallestPalindrome_2697 {

    public String makeSmallestPalindrome(String s) {
        char[] res = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(left) < s.charAt(right)) {
                    res[left] = s.charAt(left);
                    res[right] = s.charAt(left);
                } else {
                    res[left] = s.charAt(right);
                    res[right] = s.charAt(right);
                }
            } else {
                res[left] = s.charAt(left);
                res[right] = s.charAt(right);
            }
            left++;
            right--;
        }
        return new String(res);
    }
}
