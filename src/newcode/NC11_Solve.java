package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NC11_Solve {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve(int[] nums) {
        // write code here
        List<String> strs = new ArrayList<>();
        for (int item : nums) {
            strs.add(String.valueOf(item));
        }
       /* Collections.sort(strs,(a,b)->{
            if(a.length()>b.length()){
                String substring = a.substring(0, b.length());
                if(substring.equals(b)){
                    return 1;
                }
                return a.compareTo(substring);
            }
            if(a.length()<b.length()){
                String substring = b.substring(0, a.length());
                if(substring.equals(a)){
                    return -1;
                }
                return substring.compareTo(a);
            }
            return b.compareTo(a);
        });*/
        Collections.sort(strs, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        if (Double.valueOf(sb.toString()) == 0) {
            return "0";
        }
        return sb.toString();
    }
}
