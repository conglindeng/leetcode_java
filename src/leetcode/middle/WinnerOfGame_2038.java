package leetcode.middle;

public class WinnerOfGame_2038 {
    public boolean winnerOfGame(String colors) {
        int ACount = 0, BCount = 0;
        int n = colors.length();
        char curChar = 'M';
        int curCount = 0;
        for (int i = 0; i < n; i++) {
            char c = colors.charAt(i);
            if (c != curChar) {
                curChar = c;
                curCount = 1;
            } else {
                curCount++;
                if (curCount >= 3) {
                    if (curChar == 'A') {
                        ACount++;
                    } else {
                        BCount++;
                    }
                }
            }
        }
        return ACount > BCount;
    }
}
