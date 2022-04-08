package leetcode.easy;

public class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        int l = s.length();
        if (l != goal.length()) {
            return false;
        }
        for (int i = 1; i < l; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s, i, l);
            sb.append(s, 0, i);
            if (goal.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString_Optimize(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
