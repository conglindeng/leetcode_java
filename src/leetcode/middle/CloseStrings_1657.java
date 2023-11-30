package leetcode.middle;

import java.util.Arrays;

public class CloseStrings_1657 {

    public boolean closeStrings(String word1, String word2) {
        if (word2.length() != word1.length()) {
            return false;
        }
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1Count[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            word2Count[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Count[i] == 0 && word2Count[i] > 0) || (word1Count[i] > 0 && word2Count[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(word2Count);
        Arrays.sort(word1Count);
        for (int i = 0; i < 26; i++) {
            if (word1Count[i] != word2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
