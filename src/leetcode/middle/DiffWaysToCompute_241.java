package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute_241 {

    public List<Integer> diffWaysToCompute(String expression) {
        int i = 0;
        int l = expression.length();
        for (; i < l; i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (i == l) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        for (int j = 0; j < l; j++) {
            char c = expression.charAt(j);
            if (Character.isDigit(c)) {
                continue;
            } else {
                List<Integer> left = diffWaysToCompute(expression.substring(0, j));
                List<Integer> right = diffWaysToCompute(expression.substring(j + 1, l));

                for (Integer integer : left) {
                    for (Integer integer1 : right) {
                        if (c == '+') {
                            res.add(integer + integer1);
                        } else if (c == '-') {
                            res.add(integer - integer1);
                        } else {
                            res.add(integer * integer1);
                        }
                    }
                }

            }
        }
        return res;
    }


    private final int ADD = -1;
    private final int SUB = -2;
    private final int MULTI = -3;


    public List<Integer> diffWaysToCompute_WithBackTrack(String expression) {
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADD);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUB);
                } else {
                    ops.add(MULTI);
                }
                i++;
            } else {
                int n = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    n = 10 * n + (expression.charAt(i) - '0');
                    i++;
                }
                ops.add(n);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
                if (i == j) {
                    dp[i][j].add(ops.get(i));
                }
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    private List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            for (int i = l; i <= r; i++) {
                Integer integer = ops.get(i);
                if (integer < 0) {
                    List<Integer> left = dfs(dp, l, i - 1, ops);
                    List<Integer> right = dfs(dp, i + 1, r, ops);
                    for (Integer n1 : left) {
                        for (Integer n2 : right) {
                            if (integer == -1) {
                                dp[l][r].add(n1 + n2);
                            } else if (integer == -2) {
                                dp[l][r].add(n1 - n2);
                            } else {
                                dp[l][r].add(n1 * n2);
                            }
                        }
                    }
                }
            }

        }
        return dp[l][r];

    }

}
