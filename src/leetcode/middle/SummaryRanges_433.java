package leetcode.middle;

import java.util.*;

public class SummaryRanges_433 {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        boolean exist = false;
        for (String s : bank) {
            if (end.equals(s)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return -1;
        }
        //从end出发，反向处理
        //每次查找和当前相差一个字母且没有遍历过的字符串
        Set<String> used = new HashSet<>();
        Queue<String> work = new LinkedList<>();
        work.offer(end);
        used.add(end);
        int level = 1;
        while (!work.isEmpty()) {
            List<String> next = new ArrayList<>();
            while(!work.isEmpty()){
                String poll = work.poll();
                if (nonOrOneDifference(poll, start)) {
                    return level;
                }
                for (String s : bank) {
                    if (!used.contains(s) && nonOrOneDifference(s, poll)) {
                        next.add(s);
                        used.add(s);
                    }
                }
            }
            level++;
            work.addAll(next);
        }
        return -1;
    }

    private boolean nonOrOneDifference(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count <= 1;
    }

}
