package leetcode.easy;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        int p = 0;
        int first, second;
        StringBuilder res = new StringBuilder();
        while (length1 != 0 && length2 != 0) {
            first = a.charAt(length1 - 1) - '0';
            second = b.charAt(length2 - 1) - '0';
            int cur = first + second + p;
            res.append(cur % 2);
            p = cur / 2;
            length1--;
            length2--;
        }
        while (length1 != 0) {
            first = a.charAt(length1 - 1) - '0';
            int cur = first + p;
            res.append(cur % 2);
            p = cur / 2;
            length1--;
        }
        while (length2 != 0) {
            second = b.charAt(length2 - 1) - '0';
            int cur = second + p;
            res.append(cur % 2);
            p = cur / 2;
            length2--;
        }
        if (p != 0) {
            res.append(p);
        }
        return res.reverse().toString();
    }
}
