package leetcode.middle;

import java.util.Arrays;

public class FractionAddition_592 {

    private static final int ADD = 0;
    private static final int SUB = 1;

    public String fractionAddition(String expression) {
        //不停的往后遍历，遇到"\',"-","+"时，拆分出一个数字，额外的如果是"-"，"+"时，进行计算
        int[] first = new int[]{0, 1, ADD};
        int[] second = new int[3];
        int count = 0;
        int j = 0;
        while (j < expression.length()) {
            char c = expression.charAt(j);
            if (c == '-' || c == '+') {
                second[2] = c == '-' ? SUB : ADD;
            } else if (c >= '0' && c <= '9') {
                if (j + 1 < expression.length() && expression.charAt(j + 1) == '0') {
                    second[count] = 10;
                    j++;
                } else {
                    second[count] = c - '0';
                }
                count++;
                if (count == 2) {
                    count = 0;
                    first = calculate(first, second);
                }
            }
            j++;
        }
        if (first[2] == SUB) {
            return "-" + first[0] + "/" + first[1];
        }
        return first[0] + "/" + first[1];
    }

    private int[] calculate(int[] first, int[] second) {
        if (first[0] == 0) {
            return Arrays.copyOf(second, 3);
        }
        if (second[0] == 0) {
            return first;
        }
        //1.找到两个分母的最小公倍数
        int denominator = first[1] * second[1] / findCommonDivisor(first[1], second[1]);
        handle(first, denominator);
        handle(second, denominator);
        int numerator = getOpNum(first[0], first[2]) + getOpNum(second[0], second[2]);
        if (numerator < 0) {
            first[2] = SUB;
            numerator = -numerator;
        } else {
            first[2] = ADD;
        }
        int commonDivisor = findCommonDivisor(denominator, numerator);
        first[0] = numerator / commonDivisor;
        first[1] = denominator / commonDivisor;
        if (first[0] == 0) {
            return new int[]{0, 1, ADD};
        }
        return first;
    }

    private int findCommonDivisor(int first, int second) {
        if (second > first) {
            int temp = first;
            first = second;
            second = temp;
        }
        if (second == 0) {
            return 1;
        }
        while (first % second != 0) {
            int temp = first % second;
            first = second;
            second = temp;
        }
        return second;
    }

    private void handle(int[] nums, int commonMulti) {
        nums[0] = nums[0] * (commonMulti / nums[1]);
        nums[1] = commonMulti;
    }

    private int getOpNum(int num, int flag) {
        return flag == ADD ? num : -num;
    }

}
