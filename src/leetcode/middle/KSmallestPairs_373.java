package leetcode.middle;

import java.util.*;

public class KSmallestPairs_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 通过优先队列去保存所有的组合
        // 通过优先队列的弹出，取处需要的k个元素
        // 此方法会超过时间限制
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> work = new PriorityQueue<List<Integer>>((a, b) -> {
            int first = a.get(0) + a.get(1);
            int second = b.get(0) + b.get(1);
            return first - second;
        });
        for (int j : nums1) {
            for (int value : nums2) {
                List<Integer> item = new ArrayList<>();
                item.add(j);
                item.add(value);
                work.add(item);
            }
        }
        while (!work.isEmpty() && res.size() < k) {
            res.add(work.poll());
        }
        return res;
    }


    public List<List<Integer>> kSmallestPairs_Optimize(int[] nums1, int[] nums2, int k) {
        // 双指针
        // 假设i，j分别为nums1和nums2此刻的遍历指针
        // 对于下一个数，此时应该判定i和j下一个位置的数值的大小，取小的那个数
        // 假设此时i+1对应的数更小，对于的j的指向也需要修正，需找到i+1对应的数在nums2中小于该值的最后一个数
        // 还需要考虑边界情况，如果任意一边已经到了末尾，则不需要比较了，遍历另一个数组完毕即可。


        List<List<Integer>> res = new ArrayList<>();
        int cur1 = 0;
        int cur2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (cur1 < l1 || cur2 < l2) {
            if (res.size() == k) {
                break;
            }
            int n1;
            if (cur1 >= l1) {
                n1 = nums1[l1 - 1];
            } else {
                n1 = nums1[cur1];
            }
            int n2;
            if (cur2 >= l2) {
                n2 = nums2[l2 - 1];
            } else {
                n2 = nums2[cur2];
            }
            List<Integer> item = new ArrayList<>();
            item.add(n1);
            item.add(n2);
            res.add(item);
            if (cur1 < l1 - 1 && cur2 < l2 - 1) {
                if (nums1[cur1 + 1] < nums2[cur2 + 1]) {
                    cur1++;
                    cur2 = findIdx(nums2, cur2, nums1[cur1]);
                } else {
                    cur2++;
                    cur1 = findIdx(nums1, cur2, nums2[cur2]);
                }
            } else {
                cur1++;
                cur2++;
            }
        }
        return res;
    }


    private int findIdx(int[] nums, int end, int target) {
        int l = 0, r = end;
        int mid;
        while (l < r) {
            mid = l + (r - l + 1) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        while (l >= 1 && nums[l] == nums[l - 1]) {
            l--;
        }
        return l;
    }
}
