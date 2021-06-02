package leetcode.easy;

public class NumEquivDominoPairs_1128 {


    public static int numEquivDominoPairs(int[][] dominoes){
        int[] keys=new int[100];
        int count=0;
        for (int[] i : dominoes) {
             int num=i[0]<i[1]?(i[1]*10+i[0]):(i[0]*10+i[1]);
             count+=keys[num];
             keys[num]++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{2,1}}));
    }
}
