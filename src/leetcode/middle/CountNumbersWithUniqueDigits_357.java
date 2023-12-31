package leetcode.middle;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNumbersWithUniqueDigits_357 {
    public  int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int result=0;
        for(int i=n;i>1;i--){
            int curRes=1;
            for(int m=1;m<=i-1;m++){
                curRes*=(10-m);
            }
            curRes*=9;
            result+=curRes;
        }
        result+=10;
        return result;
    }
}
