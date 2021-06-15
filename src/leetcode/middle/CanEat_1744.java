package leetcode.middle;

public class CanEat_1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int candiesLength = candiesCount.length;
        int[] prefix=new int[candiesLength+1];
        for (int i = 0; i < candiesCount.length; i++) {
            prefix[i+1]=prefix[i]+candiesCount[i];
        }
        int length = queries.length;
        boolean[] result=new boolean[length];


        return result;
    }
}
