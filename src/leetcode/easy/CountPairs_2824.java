package leetcode.easy;

import java.util.Collections;
import java.util.List;

public class CountPairs_2824 {

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int i = 0;
        int j = nums.size() - 1;
        int res = 0;
        while (i < j) {
            while (i < j && nums.get(i) + nums.get(j) >= target) {
                j--;
            }
            res += j - i;
            i++;
        }
        return res;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
