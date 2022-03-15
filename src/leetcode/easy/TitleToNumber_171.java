package leetcode.easy;

public class TitleToNumber_171 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int n = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + n;
        }
        return res;
    }
}
