package leetcode.easy;

public class ShortestToChar_821 {
/*    给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。

    返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

    两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

             

    示例 1：

    输入：s = "loveleetcode", c = "e"
    输出：[3,2,1,0,1,0,0,1,2,2,1,0]
    解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
    距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
    距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
    对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
    距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。*/


    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] left = new int[length];
        int[] right = new int[length];
        int l = -1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) {
                left[i] = 0;
                l = i;
            } else {
                left[i] = l;
            }
        }
        int r = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right[i] = 0;
                r = i;
            } else {
                right[i] = r;
            }
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
            } else if (left[i] == -1) {
                res[i] = right[i] - i;
            } else if (right[i] == -1) {
                res[i] = i - left[i];
            } else {
                res[i] = Math.min(i - left[i], right[i] - i);
            }

        }
        return res;
    }


    public int[] shortestToChar_Optimize(String s, char c) {
        int length = s.length();
        int[] res = new int[length];
        int left = -length;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) {
                left = i;
                res[i] = 0;
            } else {
                res[i] = i - left;
            }
        }
        int right = 2 * length;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
                res[i] = 0;
            } else {
                res[i] = Math.min(right - i, res[i]);
            }
        }
        return res;
    }


}
