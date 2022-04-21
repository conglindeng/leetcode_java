package leetcode.easy;

public class ToGoatLatin_824 {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            char c = str.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(str);
            } else {
                sb.append(str.substring(1));
                sb.append(c);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            if (i != s.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
