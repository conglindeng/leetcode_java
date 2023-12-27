package leetcode.easy;

public class IsWinner_2660 {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = calculateTheScore(player1);
        int score2 = calculateTheScore(player2);
        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        }
        return 0;
    }

    private int calculateTheScore(int[] player) {
        int res = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] == 10)) {
                res += player[i] * 2;
            } else {
                res += player[i];
            }
        }

        return res;
    }
}
