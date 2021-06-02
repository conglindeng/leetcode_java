package leetcode.easy;

public class Merge_846 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        for(int nums:nums2){
            doInsert(nums1,m++,nums);
        }
    }

    public void doInsert(int[] nums,int m,int num){
        int length=nums.length;
        int i=0;
        for(;i<m;i++){
            int cur=nums[i];
            if(cur>=num){
                break;
            }
        }
        if(i==m){
            nums[m]=num;
        }else{
            for(int j=m;j>i;j--){
                nums[j]=nums[j-1];
            }
            nums[i]=num;
        }
    }
}