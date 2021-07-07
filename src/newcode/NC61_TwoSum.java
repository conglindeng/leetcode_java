package newcode;

import java.util.HashMap;
import java.util.Map;

public class NC61_TwoSum {
    /**
     * 给出的数组为 {20, 70, 110, 150},目标值为90
     * 输出 index1=1, index2=2
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> work=new HashMap();
        for(int i=0;i<numbers.length;i++){
            if(work.containsKey(target-numbers[i])){
                int[] res=new int[2];
                res[0] = work.get(target-numbers[i])+1;
                res[1] = i+1;
                return res;
            }
            work.put(numbers[i],i);
        }
        return new int[0];
    }
}
