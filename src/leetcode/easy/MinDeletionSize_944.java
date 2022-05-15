package leetcode.easy;

import java.util.Arrays;

public class MinDeletionSize_944 {
    public int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        char[] pre = new char[length];
        Arrays.fill(pre, 'a');
        int res = 0;
        for (String str : strs) {
            for (int j = 0; j < length; j++) {
                if (pre[j] != '0') {
                    char c = str.charAt(j);
                    if (pre[j] - c > 0) {
                        res++;
                        pre[j] = '0';
                    }else{
                        pre[j]= c;
                    }
                }
            }
        }
        return res;
    }
}
