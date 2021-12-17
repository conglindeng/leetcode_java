package leetcode.middle;

public class Multiply_43 {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars1.length - 1; i >= 0; i--) {
            int c1 = chars1[i] - '0';
            int length = chars2.length;
            for (int j = length - 1; j >= 0; j--) {
                int c2 = chars2[j] - '0';
                addNum2Str(sb, length - 1 - j, c1 * c2);
            }
        }
        return sb.toString();
    }

    private void addNum2Str(StringBuilder sb, int index, int num) {
        if (num == 0) {
            if (sb.length() <= index) {
                sb.append(num);
            }
            return;
        }
        int progressions = 0;
        while (num != 0) {
            int addNum = num % 10;
            if (sb.length() <= index) {
                sb.append(addNum);
            }else{
                int i = sb.charAt(index) - '0';
                int cur = addNum + i + progressions;
                sb.setCharAt(index, (char) (cur % 10));
                progressions = cur / 10;
            }
            index++;
            num = num / 10;
        }
    }
}
