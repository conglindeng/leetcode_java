package leetcode.middle;

import java.util.TreeSet;

public class SmallestInfiniteSet_2336_WithSet {

    private int range;
    private TreeSet<Integer> nums;

    public SmallestInfiniteSet_2336_WithSet() {
        range = 1;
        nums = new TreeSet<>();
    }

    public int popSmallest() {
        if (nums.isEmpty()) {
            return range++;
        }
        return nums.pollFirst();

    }

    public void addBack(int num) {
        if (num < range) {
            nums.add(num);
        }
    }


}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such: SmallestInfiniteSet obj = new
 * SmallestInfiniteSet(); int param_1 = obj.popSmallest(); obj.addBack(num);
 */