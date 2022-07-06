package leetcode.middle;

public class NextGreaterElement_556 {

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = chars.length - 1;
        while (j >= 0 && chars[j] <= chars[i]) {
            j--;
        }
        swap(chars, i, j);
        reverse(chars, i + 1, chars.length - 1);
        long num = Long.parseLong(new String(chars));
        if (num == (int) num) {
            return (int) num;
        }
        return -1;
    }


    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
