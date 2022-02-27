package leetcode.middle;

public class ComplexNumberMultiply_537 {
    public String complexNumberMultiply(String num1, String num2) {
        int a, b, c, d;
        String[] split1 = num1.split("\\+");
        a = Integer.parseInt(split1[0]);
        b = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        String[] split2 = num2.split("\\+");
        c = Integer.parseInt(split2[0]);
        d = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));
        int m = a * c - b * d;
        int n = a * d + b * c;
        return m + "+" + n + "i";
    }
}
