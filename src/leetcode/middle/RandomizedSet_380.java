package leetcode.middle;

import java.util.*;

class RandomizedSet_380 {
    private List<Integer> nums;
    private Map<Integer, Integer> num2Index;
    int size;
    Random random;

    public RandomizedSet_380() {
        nums = new ArrayList<>();
        num2Index = new HashMap<>();
        size = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if (num2Index.containsKey(val)) {
            return false;
        }
        nums.add(val);
        num2Index.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!num2Index.containsKey(val)) {
            return false;
        }
        int temp = nums.get(size - 1);
        Integer idx = num2Index.get(val);
        if (temp != val) {
            nums.set(idx, temp);
            num2Index.put(temp, idx);
        }
        nums.remove(size - 1);
        num2Index.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(size));
    }
}