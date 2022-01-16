package leetcode.middle;

import java.util.LinkedList;

public class IsAdditiveNumber_306 {
    boolean res = false;

    public boolean isAdditiveNumber(String num) {
        LinkedList<String> work = new LinkedList<>();
        dfs(num, 0, num.length(), work);
        return res;
    }

    private void dfs(String num, int idx, int length, LinkedList<String> work) {
        if (res) {
            return;
        }
        if (work.size() >= 3) {
            int size = work.size();
            String first = work.get(size - 3);
            String second = work.get(size - 2);
            String third = work.get(size - 1);
            if (addAndequals(first, second, third)) {
                if (idx == length) {
                    res = true;
                }
            } else {
                return;
            }
        }
        for (int i = idx; i < length; i++) {
            if (res) {
                return;
            }
            if (i > idx && num.charAt(idx) == '0') {
                return;
            }
            work.add(num.substring(idx, i + 1));
            dfs(num, i + 1, length, work);
            if (work.size() > 0)
                work.remove(work.size() - 1);
        }
    }

    private boolean addAndequals(String first, String second, String third) {
        int idx1 = first.length() - 1, idx2 = second.length() - 1;
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int n1 = first.charAt(idx1--) - '0';
            int n2 = second.charAt(idx2--) - '0';
            int cur = n1 + n2 + p;
            p = cur / 10;
            sb.append(cur % 10);
        }
        while (idx1 >= 0) {
            int n1 = first.charAt(idx1--) - '0';
            int cur = n1 + p;
            p = cur / 10;
            sb.append(cur % 10);
        }
        while (idx2 >= 0) {
            int n2 = second.charAt(idx2--) - '0';
            int cur = n2 + p;
            p = cur / 10;
            sb.append(cur % 10);
        }
        if (p > 0) {
            sb.append(p);
        }
        return third.equals(sb.reverse().toString());
    }
}
