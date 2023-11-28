package leetcode.middle;

import java.util.ArrayList;

public class FrontMiddleBackQueue_1670_ArrayList {

    ArrayList<Integer> ints;

    public FrontMiddleBackQueue_1670_ArrayList() {
        ints = new ArrayList<>();
    }

    public void pushFront(int val) {
        ints.add(0, val);
    }

    public void pushMiddle(int val) {
        ints.add(ints.size() / 2, val);
    }

    public void pushBack(int val) {
        ints.add(val);
    }

    public int popFront() {
        if (ints.isEmpty()) {
            return -1;
        }
        return ints.remove(0);
    }

    public int popMiddle() {
        if (ints.isEmpty()) {
            return -1;
        }
        return ints.remove(getMiddleIdx());
    }

    public int popBack() {
        if (ints.isEmpty()) {
            return -1;
        }
        return ints.remove(ints.size() - 1);
    }

    private int getMiddleIdx() {
        int size = ints.size();
        if (size % 2 == 0) {
            return size / 2 - 1;
        }
        return size / 2;
    }

}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such: FrontMiddleBackQueue obj = new
 * FrontMiddleBackQueue(); obj.pushFront(val); obj.pushMiddle(val); obj.pushBack(val); int param_4 = obj.popFront(); int
 * param_5 = obj.popMiddle(); int param_6 = obj.popBack();
 */