package leetcode.middle;

public class MissingRolls_2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int target = (n + m) * mean;
        for (int roll : rolls) {
            target -= roll;
        }
        if (target < n || target > n * 6) {
            return new int[0];
        }
        int a = target / n, b = target % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a + (i < b ? 1 : 0);
        }
        return res;
    }


}
