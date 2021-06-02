package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindShortestSubArray_697 {
    public static int findShortestSubArray(int[] nums){
        HashMap<Integer,int[]> infos=new HashMap<>();

        for (int i=0;i<nums.length ; i++) {
            if(infos.containsKey(nums[i])){
                int[] info = infos.get(nums[i]);
                info[0]++;
                info[2]=i;
            }else{
                infos.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxFre=0;
        int result=0;
        for (int[] info : infos.values()) {
            if(maxFre<info[0]){
                maxFre=info[0];
                result=info[2]-info[1]+1;
            }else{
                if(maxFre==info[0]){
                    result=Math.min(result,info[2]-info[1]+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
    }
}
