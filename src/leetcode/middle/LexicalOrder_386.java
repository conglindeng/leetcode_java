package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            res.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number == n) {
                    number /= 10;
                }
                number++;
            }
        }
        return res;
    }
}
