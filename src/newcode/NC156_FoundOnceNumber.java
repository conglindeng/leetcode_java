package newcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NC156_FoundOnceNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入：
     * [5,4,1,1,5,1,5],3
     * 返回值：
     * 4
     *
     * @param arr int一维数组
     * @param k int
     * @return int
     */
    public int foundOnceNumber_HashMap (int[] arr, int k) {
        // write code here
        Map<Integer,Boolean> exist=new HashMap<>();
        for(int i:arr){
            if(exist.containsKey(i)){
                exist.put(i,true);
            }else{
                exist.put(i,false);
            }
        }
        for (Map.Entry<Integer, Boolean> en : exist.entrySet()) {
            if(en.getValue().booleanValue()==false){
                return en.getKey();
            }
        }
        return -1;
    }

    public int foundOnceNumber_BySort (int[] arr, int k) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i+1]){
                i=i+k-1;
            }else{
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }
    public int foundOnceNumber_ByBit (int[] arr, int k) {
        // todo:try to understanding
        return -1;
    }
}
