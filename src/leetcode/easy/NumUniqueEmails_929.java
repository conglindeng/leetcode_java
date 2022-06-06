package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails_929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> nums = new HashSet<>();
        for (String email : emails) {
            nums.add(getRelEmail(email));
        }
        return nums.size();
    }

    private String getRelEmail(String email) {
        StringBuilder sb = new StringBuilder();
        boolean jump = false;
        boolean zone = false;
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '+') {
                jump = true;
            } else if (c == '.') {
                if (zone) {
                    sb.append('.');
                }
            } else if (c == '@') {
                zone = true;
                jump = false;
                sb.append('@');
            } else if (!jump) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
