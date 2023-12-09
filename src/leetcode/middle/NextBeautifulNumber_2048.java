package leetcode.middle;

public class NextBeautifulNumber_2048 {

    public int nextBeautifulNumber(int n) {
        for (int i = 1; i <= 1224444; i++) {
            if (i > n && balance(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean balance(int n) {
        int[] count = new int[10];
        while (n != 0) {
            count[n % 10]++;
            n = n / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }

    private int getLength(int n) {
        return String.valueOf(n).length();
    }
}
