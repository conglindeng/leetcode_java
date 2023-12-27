package interview;

public class IMain {

    public static void main(String[] args) {
    }








    /**
     * 在广场上有一排方砖是有颜色的，被涂上红色或者绿色，从左到右排列。现在校方要求重新喷涂颜色，
     * 但不一定要每一块方砖都重新喷涂，因为校方的目的是：每一块红色的方砖都在绿色方砖的左边（也就是每一个红的左边不能有绿的），并且尽量喷涂最少的次数。
     * <p>
     * 输入 输入只有一行，包含一个字符串S，且只包含'R'(代表红色)或者'G'(代表绿色)。
     * <p>
     * 输出 输出需要重新喷涂的方砖的最少数量。
     * <p>
     * 样例
     * <p>
     * 输入样例 1 RGRGR 输出样例 1 2
     * <p>
     * <p>
     * 提示 样例中字符串S为RGRGR，则我们可以这么喷涂，即RGRGR喷成RRRGG（即将第二个字符喷成R，最后一个字符喷成G） 或者RRRRR（即将两个G都喷成R），都是只需喷涂两个方砖，所以答案为2。
     * <p>
     * 我们再举个例子:若S为RRRGGGGG，则我们不需要在重新喷涂就已经满足“每一块红色的方砖都在绿色方砖的左边”的要求，所以答案将是0。
     * <p>
     * public int leastPaintBricks(String s) {
     * <p>
     * }
     */
    public static int leastPaintBricks(String s) {
        //optimize: 计算R出现次数的后缀和，
        // 再从前遍历到后面，并统计G出现次数的前缀和，
        // 相加比较得到最小替换次数

        //遍历每一个点，统计左边的G，和右边的R
        int res = s.length();
        int GCnt = 0;
        int i = 0;
        while (i < s.length()) {
            //统计右边的RCnt
            int RCnt = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    RCnt++;
                }
            }
            res = Math.min(GCnt + RCnt, res);
            if (s.charAt(i) == 'G') {
                GCnt++;
            }
            i++;
        }
        if (res == s.length()) {
            return 0;
        }
        return res;
    }

}
