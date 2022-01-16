package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSmallestPairs_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //双指针
        int cur1 = 0;
        int cur2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (cur1 < l1 || cur2 < l2) {
            List<Integer> item = new ArrayList<>();
            if (cur1 >= l1) {
                item.add(nums1[l1 - 1]);
            } else {
                item.add(cur1);
            }
            if (cur2 >= l2) {
                item.add(nums1[l2 - 1]);
            } else {
                item.add(cur2);
            }
            res.add(item);

            if (cur1 < l1 - 1 && cur2 < l2 - 1) {
                //此时应该判断下一个应该取哪个值
                if (nums1[cur1 + 1] < nums2[cur2 + 1]) {
                    cur1++;
                } else {
                    cur2++;
                }
            } else {
                cur1++;
                cur2++;
            }
        }
        return res;
    }
}
