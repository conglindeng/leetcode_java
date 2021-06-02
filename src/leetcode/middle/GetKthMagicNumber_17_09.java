package leetcode.middle;

public class GetKthMagicNumber_17_09 {
    /**
     * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k){
        int[] nums=new int[k+1];
        nums[0]=1;
        int p3=0;
        int p5=0;
        int p7=0;
        for (int i = 0; i < k; i++) {
            nums[i+1]=Math.min(Math.min(nums[p3]*3,nums[p5]*5),nums[p7]*7);
            if(nums[p3]*3==nums[i+1])
                p3++;
            if(nums[p5]*5==nums[i+1])
                p5++;
            if(nums[p7]*7==nums[i+1])
                p7++;
        }
        return nums[k+1];
    }
}
