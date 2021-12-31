package leetcode.easy;

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        //时间复杂度：O(N)
        //dp[i]=Math.max(dp[i],dp[i-1]+nums[i])
        //边界：dp[0]=0;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            res = Math.max(dp[i + 1], res);
        }
        return res;
    }

    //--------------------- split line  --------------------

    private static class Info {
        private int lSum, rSum, mSum, aSum;

        public Info(int lSum, int rSum, int mSum, int aSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.aSum = aSum;
        }
    }

    public int maxSubArray_Optimize(int[] nums) {
        return doCalculate(nums, 0, nums.length - 1).mSum;
    }

    private Info doCalculate(int[] nums, int left, int right) {
        if (left == right) {
            return new Info(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = left + (right - left) / 2;
        Info lInfo = doCalculate(nums, left, mid);
        Info rInfo = doCalculate(nums, mid + 1, right);
        return pushUp(lInfo, rInfo);
    }

    private Info pushUp(Info lInfo, Info rInfo) {
        int lSum = Math.max(lInfo.lSum, lInfo.aSum + rInfo.lSum);
        int rSum = Math.max(rInfo.rSum, rInfo.aSum + lInfo.rSum);
        int aSum = lInfo.aSum + rInfo.aSum;
        int mSum = Math.max(Math.max(lInfo.mSum, rInfo.mSum), lInfo.rSum + rInfo.lSum);
        return new Info(lSum, rSum, mSum, aSum);
    }
}
