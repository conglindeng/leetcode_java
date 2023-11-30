package leetcode.easy;

public class IsPalindrome_125 {

    public boolean isPalindrome(String s) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 'Z' && ch >= 'A') {
                tmp.append((char) (ch + 32));
            } else if (ch <= 'z' && ch >= 'a') {
                tmp.append(ch);
            } else if (ch <= '9' && ch >= '0') {
                tmp.append(ch);
            }
        }
        String str = tmp.toString();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public boolean isPalindrome_TwoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isLetterOrNumber(s.charAt(left))) {
                left++;
            }
            while (left < right && !isLetterOrNumber(s.charAt(right))) {
                right--;
            }
            char c = s.charAt(left);
            char c1 = s.charAt(right);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            if (c1 >= 'A' && c1 <= 'Z') {
                c1 = (char) (c1 + 32);
            }
            if (c != c1) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isLetterOrNumber(char ch) {
        return (ch <= 'Z' && ch >= 'A') || (ch <= 'z' && ch >= 'a') || (ch <= '9' && ch >= '0');
    }
}
