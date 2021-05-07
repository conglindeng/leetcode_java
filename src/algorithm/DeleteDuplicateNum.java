package algorithm;

public class DeleteDuplicateNum {

    /**
     * 有一个整数型数组，存在先正序后逆序两部分数据，去除数组中存在重复的数字并输出新的数组。如：
     * {1,3,5,6,8,8,15,10,9,7,6,5,3},则输出：{1,3,5,6,8,15,10,9
     * @param nums
     * @return
     */
    public int[] deleteDuplicateNum(int[] nums){
        int length = deleteContinuousElement(nums);
        int left=0,right=length-1;
        while(left<right){
            if(nums[left]<nums[right]){
                left++;
            }else if(nums[left]>nums[right]){
                right--;
            }else{
                //move the elements after the right position forward
                moveElments(right,nums,length);
                length--;
                right--;
            }
        }
        int[] result=new int[length];
        System.arraycopy(nums,0,result,0,length);
        return result;
    }
    private void moveElments(int position ,int[] nums,int length){
        if(position<0 || position>=length){
            return;
        }
//        for (int i = position; i < length-1; i++) {
//            nums[i]=nums[i+1];
//        }
        if (length - 1 - position >= 0) System.arraycopy(nums, position + 1, nums, position, length - 1 - position);
    }

    private int deleteContinuousElement(int[] nums){
        int length = nums.length;
        int left=0,right=0;
        while(right<length){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
            right++;
        }
        return left+1;
    }
}

