package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution_384 {

    private int[] data;

    public Solution_384(int[] nums) {
        data = nums;
    }

    public int[] reset() {
        return data;
    }

    public int[] shuffle() {
        int length = data.length;
        int[] res=new int[length];
        List<Integer> ints=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ints.add(data[i]);
        }
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            int cur= random.nextInt(length-i);
            res[i]=ints.remove(cur);
        }
        return res;
    }
}
