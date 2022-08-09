package leetcode.easy;

public class GenerateTheString_1374 {

    public String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                res.append('a');
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                res.append('a');
            }
            res.append('b');
        }
        return res.toString();
    }
}
