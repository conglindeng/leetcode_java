package leetcode.easy;

public class ArrayStringsAreEqual_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int i = 0, j = 0;
        int m = 0, n = 0;
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(m++) != word2[j].charAt(n++)) {
                return false;
            }
            if (word1[i].length() == m) {
                i++;
                m = 0;
            }
            if (word2[j].length() == n) {
                j++;
                n = 0;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
