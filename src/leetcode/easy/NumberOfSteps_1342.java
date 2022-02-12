package leetcode.easy;

public class NumberOfSteps_1342 {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0 || num == 1) {
                res++;
            } else {
                res += 2;
            }
            num = num / 2;
        }
        return res;
    }
}
