package leetcode.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber_260 {

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     *
     *  
     *
     * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,1,3,2,5]
     * 输出：[3,5]
     * 解释：[5, 3] 也是有效的答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums){
        Map<Integer,Integer> count=new HashMap();
        for(int num : nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        int[] result=new int[2];
        int index=0;

        Iterator<Map.Entry<Integer, Integer>> iterator = count.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue()==1){
                result[index++]=next.getKey();
            }

        }

        return result;
    }

    public int[] singleNumber_Optimize(int[] nums){
        int a=0;
        for(int num : nums){
            a^=num;
        }
        int mask=a&(-a);
        int[] result=new int[2];
        for(int num:nums){
            if((num&mask)==0){
                result[0]^=num;
            }else{
                result[1]^=num;
            }
        }
        return result;
    }

}
