package leetcode.easy;

import java.util.LinkedList;

public class MovingAverage_offer_041 {

    int capacity;

    int size;

    LinkedList<Integer> nums;

    double curSum;

    /** Initialize your data structure here. */
    public MovingAverage_offer_041(int size) {
        this.size = 0;
        this.capacity = size;
        this.nums = new LinkedList<>();
        this.curSum = 0;
    }

    public double next(int val) {
        if (size < capacity) {
            size++;
        } else {
            Integer integer = nums.pollFirst();
            curSum -= integer;
        }
        curSum += val;
        nums.addLast(val);
        return curSum / size;
    }


}