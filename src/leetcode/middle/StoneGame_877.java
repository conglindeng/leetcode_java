package leetcode.middle;

import java.util.PriorityQueue;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGame_877 {
    /**
     * 此解法不正确，未理解题意，只能在头或者尾取石头
     * @param piles
     * @return
     */
    public static boolean stoneGame(int[] piles){
        int firstSum=0;
        int secondSum=0;
        PriorityQueue<Integer> work=new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < piles.length; i++) {
            work.offer(piles[i]);
        }
        int index=0;
        while(!work.isEmpty()){
            if((index++)%2==0){
                firstSum+=work.poll();
            }else{
                secondSum+=work.poll();
            }
        }
        return firstSum>secondSum;
    }

    public static boolean stoneGame_(int[] piles){
            return true;
    }
}
