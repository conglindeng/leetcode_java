package leetcode.middle;

public class PushDominoes_838 {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            return dominoes;
        }
        while (true) {
            //每循环一次，则表示过了一秒。
            //最终状态如何量化？变换后和前一次的状态相等，说明达到的最终状态。
            //每次循环的时候，判断'.'符号的左右两边字符的值，如果为两点或者一个为l另一个为r，则不动
            //其他的组合，则左倒或者右倒。
            char[] chars = dominoes.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                if (chars[i] == '.') {
                    char leftC = i == 0 ? '.' : dominoes.charAt(i - 1);
                    char rightC = i == length - 1 ? '.' : chars[i + 1];
                    if (leftC == '.' && rightC == '.') {
                    } else if (leftC == 'L' && rightC == 'R') {
                    } else if (leftC == 'R' && rightC == 'L') {
                    } else if (leftC == 'R') {
                        chars[i] = leftC;
                    } else if (rightC == 'L') {
                        chars[i] = rightC;
                    }
                }
            }
            String next = String.valueOf(chars);
            if (next.equals(dominoes)) {
                return next;
            } else {
                dominoes = next;
            }
        }
    }

    public String pushDominoes_Optimize(String dominoes) {
        int n = dominoes.length();
        int i = 0;
        char left = 'L';
        char[] res = dominoes.toCharArray();
        while (i < n) {
            int j = i;
            while (j < n && dominoes.charAt(j) == '.') {
                j++;
            }
            char right = j < n ? dominoes.charAt(j) : 'R';
            if (left == right) {
                for (int k = i; k < j; k++) {
                    res[k] = left;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    res[k--] = 'L';
                    res[i++] = 'R';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(res);
    }

}
