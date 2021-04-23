package leetcode.middle;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 *    输入:
 *    big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 *    small = [1,5,9]
 *    输出: [7,10]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestSeq_17_18 {

    Map<Integer, Integer> countMap = new HashMap<>();

    public int[] shortestSeq(int[] big, int[] small) {
        int length = big.length;
        for (int value : small) {
            countMap.put(value, 0);
        }
        int left = 0, right = 0;
        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;
        boolean flag = false;
        while (right < length) {
            int r = big[right];
            Integer integer = countMap.get(r);
            if (integer != null) {
                countMap.put(r, integer + 1);
            }
            while (atleastMatchOne()) {
                flag = true;
                if ((result[1] - result[0]) > (right - left)) {
                    result[0] = left;
                    result[1] = right;
                }
                int l = big[left];
                Integer lbig = countMap.get(l);
                if (lbig != null) {
                    countMap.put(l, lbig - 1);
                }
                left++;
            }
            right++;
        }
        return flag ? (new int[0]) : result;
    }

    private boolean atleastMatchOne() {
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value == 0) {
                return false;
            }
        }
        return true;
    }



    // todo : not completed
    public int[] shortestSeq_new(int[] big, int[] small) {
        int diff = 0;
        int length = big.length;
        int length1 = small.length;
        if (length1 > length) {
            return new int[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : small) {
            countMap.put(i, 0);
            diff++;
        }
        int left = 0, right = 0;
        int[] result=new int[2];
        result[1]=Integer.MAX_VALUE;
        boolean flag=false;
        while(right<length){
            Integer integer = countMap.get(big[right]);
            if(integer!=null){
                diff--;
                countMap.put(big[right],integer+1);
            }
            while(diff==0 && left<right){
                flag=true;
                Integer count = countMap.get(big[left]);
                if(count!=null){
                    countMap.put(big[right],count-1);
                    if(count==1){
                        if((result[1]-result[0])>(right-left)){
                            result[1]=right;
                            result[0]=left;
                        }
                        diff++;
                    }
                }
                left++;
            }
            right++;
        }
        return flag? result : new int[0];
    }
}
