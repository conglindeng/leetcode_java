package leetcode.easy;

public class NumPrimeArrangements_1175 {

    int base = (int) Math.pow(10, 9) + 7;

    int[] num = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
        97};

    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimeNum(i)) {
                count++;
            }
        }

        return (int) ((getFactorial(count) * getFactorial(n - count)) % base);
    }


    private long getFactorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % base;
        }
        return res;
    }

    private boolean isPrimeNum(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


}
