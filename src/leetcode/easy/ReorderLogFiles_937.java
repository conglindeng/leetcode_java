package leetcode.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class ReorderLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String[]> work = new PriorityQueue<String[]>((b, a) -> {
            if (a[1].equals(b[1])) {
                return a[0].compareTo(b[0]);
            } else {
                return a[1].compareTo(b[1]);
            }
        });
        LinkedList<String> temp = new LinkedList<>();
        for (String log : logs) {
            String[] prefixAndLog = getPrefixAndLog(log);
            char c = prefixAndLog[1].charAt(0);
            if (Character.isDigit(c)) {
                temp.addLast(log);
            } else {
                work.add(prefixAndLog);
            }
        }
        while (!work.isEmpty()) {
            String[] poll = work.poll();
            temp.addFirst(poll[0] + " " + poll[1]);
        }
        String[] res = new String[logs.length];
        for (int i = 0; i < logs.length; i++) {
            res[i] = temp.pollFirst();
        }
        return res;
    }

    private String[] getPrefixAndLog(String str) {
        int i = 0;
        for (; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                break;
            }
        }
        return new String[]{str.substring(0, i), str.substring(i + 1)};
    }
}
