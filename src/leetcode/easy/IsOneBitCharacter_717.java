package leetcode.easy;

public class IsOneBitCharacter_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int n = 0;
        while (n < length - 1) {
            n += bits[n] + 1;
        }
        return n == length - 1;
    }


    public boolean isOneBitCharacter_another(int[] bits) {
        int n = bits.length - 2;
        int idx = -1;
        while (n >= 0) {
            if (bits[n] == 0) {
                idx = n;
                break;
            }
            n--;
        }
        return (bits.length - idx - 2) % 2 == 0;
    }
}
