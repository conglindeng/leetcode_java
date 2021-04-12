package middle;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int length=nums.length;

        for (int i = 0; i <(1<<length); i++) {
            List<Integer> item=new ArrayList<>();
            for(int j=0;j<length;j++){
                int index = 1 << j;
                if((index &i)==1){
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
        return result;
    }
}
