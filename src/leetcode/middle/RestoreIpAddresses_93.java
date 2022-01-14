package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> work = new ArrayList<>();
        solve(work, s, 0);
        return res;
    }

    private void solve(List<String> work, String s, int idx) {
        if (work.size() > 4) {
            return;
        }
        if (idx == s.length()) {
            if (work.size() == 4)
                res.add(joinList(work, "."));
            return;
        }
        if (s.charAt(idx) == '0') {
            work.add("0");
            solve(work, s, idx + 1);
            work.remove(work.size() - 1);
        } else {
            for (int i = idx; i < s.length() && i < idx + 3; i++) {
                String substring = s.substring(idx, i + 1);
                if (Integer.parseInt(substring) > 255) {
                    return;
                }
                work.add(substring);
                solve(work, s, i + 1);
                work.remove(work.size() - 1);
            }
        }
    }

    private String joinList(List<String> work, String joinStr) {
        int size = work.size();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < size - 1; i++) {
            sb.append(work.get(i));
            sb.append(joinStr);
        }
        sb.append(work.get(i));
        return sb.toString();
    }
}
