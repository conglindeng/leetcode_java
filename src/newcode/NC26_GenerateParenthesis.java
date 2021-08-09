package newcode;

import java.util.ArrayList;

public class NC26_GenerateParenthesis {


    ArrayList<String> res = new ArrayList<>();

    /**
     * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
     * 例如，给出n=3，解集为：
     * "((()))", "(()())", "(())()", "()()()", "()(())",
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        if (n < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        backTracking(n, sb, n, n);
        return res;
    }


    private void backTracking(int n, StringBuilder sb, int left, int right) {
        if (right == 0 && left > 0) {
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
        }
        if (left > 0) {
            backTracking(n, sb.append("("), left - 1, right);
        }
        if (right > 0 && left != right) {
            backTracking(n, sb.append(")"), left, right - 1);

        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
    }
}
