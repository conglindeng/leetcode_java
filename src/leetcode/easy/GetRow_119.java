package leetcode.easy;

import struct.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetRow_119 {
    public static List<Integer> getRow(int rowIndex){
        rowIndex++;
        List<Integer> result=new ArrayList<>();
        int[] nums=new int[rowIndex];
        nums[0]=1;
        for(int i=0;i<rowIndex;i++){
            int previous=1;
            for(int j=1;j<i+1;j++){
                int temp=nums[j];
                nums[j]=previous+nums[j];
                previous=temp;
            }
        }
        for (int i = 0; i < rowIndex; i++) {
            result.add(nums[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

}
