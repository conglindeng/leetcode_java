package leetcode.middle;

public class Divide_29 {
    public int divide(int dividend, int divisor) {
        //找到a和b，使得除数在a*被除数和b*被除数之间，根据符号取最小的小的那个
        //先让除数和被除数 符号都为正，找到a和b后，再根据除数和被除数符号的异同，取值
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        if (divisorAbs == 1) {
            if (divisor==-1) {
                if(dividend==Integer.MIN_VALUE){
                    return Integer.MAX_VALUE;
                }
                return -dividend;
            } else {
                return dividend;
            }
        }
        int count = 0;
        int i = 0;
        for (; i <= dividendAbs; i++) {
            if (count == dividendAbs) {
                if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
                    return -i;
                } else {
                    return i;
                }
            }
            if (count > dividendAbs) {
                break;
            }
            count += divisorAbs;
        }
        //找到上界
        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            return 1 - i;
        }
        return i - 1;
    }
}
