package leetcode.middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LongestOnes_1004 {
    public static int longestOnes(int[] A,int K){
        int result=0;
        int count=0;
        int curFlag=A[0];
        List<info> infos=new ArrayList<>();
        for (int i : A) {
            if(i!=curFlag){
                if(i==0){
                    infos.add(new info(curFlag,count));
                    curFlag=0;
                    count=0;
                }
                if(i==1){
                    infos.add(new info(curFlag,count));
                    curFlag=1;
                    count=0;
                }
            }
            count++;
        }
        infos.add(new info(curFlag,count));
        int length=infos.size();

        for (int i = 0; i < length ;i++) {
            info info = infos.get(i);
            if(info.flag==0){
                int curLength=0;
                int preCount=(i-1)<0?0:infos.get(i-1).count;
                int nextCount=(i+1)>length?0:infos.get(i+1).count;
                if(info.count>K){
                    curLength=Math.max(preCount+K,nextCount+K);
                }else{
                    curLength=preCount+info.count+nextCount;
                }
                result=Math.max(result,curLength);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(longestOnesReal(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }


    public static int longestOnesReal(int[] A,int K){
        int[] P=new int[A.length+1];
        for (int i = 1; i <= A.length; i++) {
            P[i]=P[i-1]+(1-A[i-1]);
        }
        int result=0;
        for (int i = 0; i < A.length; i++) {
            int left=binarySearch(P,P[i+1]-K);
            result=Math.max(result,i-left+1);
        }
        return result;
    }


    private static int binarySearch(int[] P,int target){
        int left=0;
        int right=P.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(P[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    
    static class info{
        private int flag;
        private int count;

        public info(int flag, int count) {
            this.flag = flag;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
