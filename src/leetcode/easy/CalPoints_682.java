package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class CalPoints_682 {
    public int calPoints(String[] ops) {
        int res = 0;
        Deque<Integer> points = new LinkedList<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                Integer second = points.pop();
                Integer first = points.peek();
                points.push(second);
                points.push(first + second);
            } else if ("D".equals(op)) {
                points.push(points.peek() * 2);
            } else if ("C".equals(op)) {
                points.pop();
            } else {
                points.push(Integer.parseInt(op));
            }
        }
        for (Integer point : points) {
            res += point;
        }
        return res;
    }
}
