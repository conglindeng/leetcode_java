package leetcode.middle;

/**
 * @ClassName ValidIPAddress_468
 * @Author conglindeng
 * @Date 2022/5/29 18:52
 * @Version 1.0
 */
public class ValidIPAddress_468 {

    public static final String NEITHER = "Neither";

    public String
    validIPAddress(String queryIP) {
        String s = validateIPV4(queryIP);
        if (NEITHER.equals(s)) {
            return validateIPV6(queryIP);
        }
        return s;
    }

    private String validateIPV4(String IP) {
        IP += '.';
        int count = 0;
        int start = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                count++;
                String s = IP.substring(start, i);
                if ((s.length() > 1 && s.charAt(0) == '0') || s.length() == 0 || s.length() > 3) {
                    return NEITHER;
                }
                int num = 0;
                for (int m = 0; m < s.length(); m++) {
                    char c = s.charAt(m);
                    if (!Character.isDigit(c)) {
                        return NEITHER;
                    }
                    num = num * 10 + (c - '0');
                }
                if (num > 255) {
                    return NEITHER;
                }
                start = i + 1;
            }
        }
        if (count != 4) {
            return NEITHER;
        }
        return "IPv4";
    }

    private String validateIPV6(String IP) {
        IP += ':';
        int count = 0;
        int start = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == ':') {
                count++;
                String s = IP.substring(start, i);
                if (s.length() > 4 || s.length() == 0) {
                    return NEITHER;
                }
                for (int m = 0; m < s.length(); m++) {
                    char c = s.charAt(m);
                    boolean flag = (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
                    if (!Character.isDigit(c) && !flag) {
                        return NEITHER;
                    }
                }
                start = i + 1;
            }
        }
        if (count != 8) {
            return NEITHER;
        }
        return "IPv6";
    }

}
