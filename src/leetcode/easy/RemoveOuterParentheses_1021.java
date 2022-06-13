package leetcode.easy;

/**
 * @ClassName RemoveOuterParentheses_1021
 * @Author conglindeng
 * @Date 2022/5/28 15:52
 * @Version 1.0
 */
public class RemoveOuterParentheses_1021 {

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int curDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (curDepth != 0) {
                    sb.append(c);
                }
                curDepth++;
            } else {
                curDepth--;
                if (curDepth != 0) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
}
