package leetcode.easy;

public class ConvertToBase7_504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        while (num != 0) {
            res.append(num % 7);
            num = num / 7;
        }
        if (flag) {
            res.append('-');
        }
        return res.reverse().toString();
    }


}
