package newcode;

public class NC1_BigIntegerAdd {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * <p>
     * 输入：
     * "1","99"
     * 返回值：
     * "100"
     * 说明：
     * 1+99=100
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        if (s == null)
            return t;
        if (t == null)
            return s;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int index1 = chars1.length - 1;
        int index2 = chars2.length - 1;
        int cur = 0;
        int sum;
        int first;
        int second;
        StringBuilder res = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            first = index1 >= 0 ? (chars1[index1--]-'0') : 0;
            second = index2 >= 0 ? (chars2[index2--]-'0') : 0;
            sum = first + second + cur;
            res.append(sum % 10);
            cur = sum / 10;
        }
        if(cur>0){
            res.append(cur);
        }
        return res.reverse().toString();
    }
}
