package array;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoArray {

    /**
     * 合并两个有序数组
     *
     * @param first           第一个数组
     * @param second          第二个数组
     * @param deleteDuplicate 是否删除重复的元素
     * @return 合并后的新数组
     */
    public static int[] mergeTwoArray(int[] first, int[] second, boolean deleteDuplicate) {
        if (first == null && second == null)
            return null;
        if (first == null)
            return second;
        if (second == null)
            return first;


        int m = first.length;
        int n = second.length;

        int index_1 = 0;
        int index_2 = 0;
        List<Integer> temp = new ArrayList<>();
        while (index_1 < m && index_2 < n) {
            if(first[index_1]<=second[index_2]){
                addIfNotDuplicate(temp,first[index_1++]);
            }else{
                addIfNotDuplicate(temp,second[index_2++]);
            }
        }
        if(index_1<m){
            for (int i = index_1; i < m; i++) {
                temp.add(first[i]);
            }
        }
        if(index_2<n){
            for (int i = index_2; i < n; i++) {
                temp.add(second[i]);
            }
        }
        return null;
    }

    private static void addIfNotDuplicate(List<Integer> array,int value){
        if(array.size()==0){
            array.add(value);
            return;
        }
        Integer integer = array.get(array.size() - 1);
        if(value==integer) {
            return;
        }
        array.add(value);
    }
}
