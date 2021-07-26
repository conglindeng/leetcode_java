package newcode;

public class NC17_GetLongestPalindrome {

    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (A == null || A == "") {
            return 0;
        }
        char[] chars = A.toCharArray();
        int res = 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j >= 0 && 2 * i - j + 1 < n; j--) {
                if (chars[j] != chars[2 * i - j + 1]) {
                    break;
                }
                count += 2;
                res = Math.max(res, count);
            }
            count = 1;
            for (int j = 1; i - j >= 0 && i + j < n; j++) {
                if (chars[i - j] != chars[i + j]) {
                    break;
                }
                count += 2;
                res = Math.max(res, count);
            }
        }
        return res;
    }

}
