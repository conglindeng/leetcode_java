package middle;

public class RemoveDuplicates_80 {
    public static int removeDuplicats(int[] nums){
        if(nums.length<3){
            return nums.length;
        }
        int length=nums.length;
        int cur=nums[0];
        int count=1;
        int i=1;
        while(i<length) {
            if(cur==nums[i]){
                count++;
                if(count>2){
                    //往前移动
                    for(int j=i;j<length-1;j++){
                        nums[j]=nums[j+1];
                    }
                    //count--;
                    length--;
                    continue;
                }
            }else{
                cur=nums[i];
                count=1;
            }
            i++;
        }
        return length;
    }


    public static int removeDuplicats_2(int[] nums){
        if(nums.length<3){
            return nums.length;
        }
        int length = nums.length;
        int low=2;
        int fast=2;
        int cur=nums[low];
        int count=1;
        while(fast<length){


        }
        return -1;
    }

}
