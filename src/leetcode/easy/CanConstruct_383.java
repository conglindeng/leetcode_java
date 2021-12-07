package leetcode.easy;

public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return false;
        }
        if (magazine == null || magazine.length() == 0) {
            return true;
        }
        int[] big = new int[26];
        int[] small = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            big[c - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            small[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (big[i] > small[i]) {
                return false;
            }
        }
        return true;
    }
}
