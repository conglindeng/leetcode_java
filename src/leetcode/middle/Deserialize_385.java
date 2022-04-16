package leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Deserialize_385 {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        int num = 0;
        boolean isNegative = false;
        Deque<NestedInteger> work = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                work.push(new NestedInteger());
            } else if (c == '-') {
                isNegative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == ']' || c == ',') {
                if(Character.isDigit(s.charAt(i-1))){
                    if (isNegative) {
                        num *= -1;
                    }
                    work.peek().add(new NestedInteger(num));
                }
                num = 0;
                isNegative = false;
                if (c == ']' && work.size() > 1) {
                    NestedInteger pop = work.pop();
                    work.peek().add(pop);
                }

            }
        }
        return work.pop();
    }


    //状态机？


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public static class NestedInteger {
        // Constructor initializes an empty nested list.
        int value;
        List<NestedInteger> list;

        public NestedInteger() {
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return list == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
