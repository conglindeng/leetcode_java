package leetcode.middle;

public class CountCompleteSubstrings_100145 {

    public int countCompleteSubstrings(String word, int k) {
        int res = 0;
        int i = 0;
        while (i < word.length()) {
            int start = i + 1;
            while (start < word.length() && Math.abs(word.charAt(start) - word.charAt(start - 1)) <= 2) {
                start++;
            }
            res += calculateSubstring(word, i, start - 1, k);
            i = start;
        }
        return res;
    }

    private int calculateSubstring(String word, int left, int right, int k) {
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            int size = i * k;
            if (size > right - left + 1) {
                break;
            }
            int[] cnt = new int[26];
            for (int j = 0; j < size; j++) {
                cnt[word.charAt(left + j) - 'a']++;
            }
            if (check(cnt, k)) {
                res++;
            }
            for (int j = left + size; j <= right; j++) {
                cnt[word.charAt(j - size) - 'a']--;
                cnt[word.charAt(j) - 'a']++;
                if (check(cnt, k)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[] cnt, int k) {
        for (int j : cnt) {
            if (j == 0) {
                continue;
            }
            if (j != k) {
                return false;
            }
        }
        return true;
    }
}
