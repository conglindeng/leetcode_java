package leetcode.middle;

public class XorQueries_1310 {
    public static int[] xorQueries(int[] arr,int[][] queries){
        int[] result=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int begin = query[0];
            int end = query[1];
            int item=0;
            for (int j = begin; j <= end && j<arr.length; j++) {
                item^=arr[j];
            }
            result[i]=item;
        }
        return result;
    }

    public static int[] xorQueries_optimize(int[] arr,int[][] queries){
        int[] result=new int[queries.length];
        int[] prefixXOR=new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            prefixXOR[i+1]=prefixXOR[i]^arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int begin = query[0];
            int end = query[1];
            int item=prefixXOR[end+1];
            for (int j = 0; j <begin; j++) {
                item^=arr[j];
            }
            result[i]=item;
        }
        return result;
    }

}
