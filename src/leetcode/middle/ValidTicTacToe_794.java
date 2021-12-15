package leetcode.middle;

public class ValidTicTacToe_794 {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        boolean xWin = false;
        boolean oWin = false;
        for (int i = 0; i < 3; i++) {
            boolean isAllXOrO = true;
            char c = board[0].charAt(i);
            for (int j = 0; j < 3; j++) {
                String s = board[j];
                char at = s.charAt(i);
                if (at == 'X') {
                    xCount++;
                    if (c != at) {
                        isAllXOrO = false;
                    }
                } else if (at == 'O') {
                    oCount++;
                    if (c != at) {
                        isAllXOrO = false;
                    }
                } else {
                    isAllXOrO = false;
                }
            }
            if (isAllXOrO) {
                if (c == 'O') {
                    oWin = true;
                } else {
                    xWin = true;
                }
            }
        }
        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }
        int count = xCount + oCount;
        for (int i = 0; i < 3; i++) {
            String s = board[i];
            if (s.equals("OOO")) {
                oWin = true;
            }
            if (s.equals("XXX")) {
                xWin = true;
            }
        }
        //判断对角线是否一致
        boolean isAllXOrO = false;
        boolean isAllXOrO2 = false;

        char s = board[1].charAt(1);
        if (s == board[0].charAt(0) && s == board[2].charAt(2)) {
            isAllXOrO = true;
        }
        if (s == board[2].charAt(0) && s == board[0].charAt(2)) {
            isAllXOrO2 = true;
        }
        if (isAllXOrO || isAllXOrO2) {
            if (s == 'X') {
                xWin = true;
            }
            if (s == 'O') {
                oWin = true;
            }
        }
        if (count == 5 && oWin) {
            return false;
        }
        //总数量大于5，则要么都不胜，要么之只能 x 胜利且 xCount=oCount+1 ，要么o胜利且xCount = oCount
        if (count > 5) {
            return (!xWin && !oWin) || (xWin && !oWin && xCount == oCount + 1) || (!xWin && oWin && xCount == oCount);
        }
        return true;
    }
}


