package leetcode.easy;

public class MaximumProduct {
    public static void main(String[] args) {

    }
    public static int maximumProduct(int[] nums){
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        for (int i :
                nums) {
            if (i<min1){
                min2=min1;
                min1=i;
            }else if(i<min2){
                min2=i;
            }


            if(i>max3){
                max1=max2;
                max2=max3;
                max3=i;
            }else if(i>max2){
                max1=max2;
                max2=i;
            }else if(i>max1){
                max1=i;
            }

        }

        return Math.max(max1*max2*max3,min1*min2*max3);
    }
}
