package leetcode.easy;

public class AddDigits_258 {
    public int addDigits(int num) {
        if (num < 10 && num >= 0) {
            return num;
        }
        int next = 0;
        while (num != 0) {
            next += num % 10;
            num = num / 10;
        }
        return addDigits(next);
    }
}
