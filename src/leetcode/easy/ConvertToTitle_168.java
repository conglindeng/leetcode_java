package leetcode.easy;

public class ConvertToTitle_168 {
    //10 进制转化为 26进制
    // 701=26*26+25
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }
}
