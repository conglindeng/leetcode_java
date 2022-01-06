package leetcode.easy;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CheckPerfectNumber_507 {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i < num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
