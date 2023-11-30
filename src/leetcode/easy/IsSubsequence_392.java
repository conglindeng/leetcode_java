package leetcode.easy;

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        int first = 0;
        int right = 0;
        while (first < s.length() && right < t.length()) {
            if (s.charAt(first) == t.charAt(right)) {
                first++;
            }
            right++;
        }
        return first == s.length();
    }
}
