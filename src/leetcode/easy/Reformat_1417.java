package leetcode.easy;

/**
 * @ClassName: Reformat_1417
 * @author: conglindeng
 * @Date 2022/8/11
 * @Description
 */
public class Reformat_1417 {

    public String reformat(String s) {
        int l = s.length();
        int sumDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                ++sumDigit;
            }
        }
        if (Math.abs(l - sumDigit - sumDigit) > 1) {
            return "";
        }

        boolean flag = (l - sumDigit) > sumDigit;
        char[] chars = s.toCharArray();
        for (int i = 0, j = 1; i < l; i += 2) {
            if (Character.isDigit(chars[i]) != flag) {
                while (Character.isDigit(chars[j]) != flag) {
                    j += 2;
                }
                swap(chars, i, j);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    class Solution {

        public String reformat(String s) {
            int sumDigit = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    sumDigit++;
                }
            }
            int sumAlpha = s.length() - sumDigit;
            if (Math.abs(sumDigit - sumAlpha) > 1) {
                return "";
            }
            boolean flag = sumDigit > sumAlpha;
            char[] arr = s.toCharArray();
            for (int i = 0, j = 1; i < s.length(); i += 2) {
                if (Character.isDigit(arr[i]) != flag) {
                    while (Character.isDigit(arr[j]) != flag) {
                        j += 2;
                    }
                    swap(arr, i, j);
                }
            }
            return new String(arr);
        }

        public void swap(char[] arr, int i, int j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }


}
