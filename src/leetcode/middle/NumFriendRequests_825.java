package leetcode.middle;

import java.util.Arrays;

public class NumFriendRequests_825 {
    /**
     * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
     * <p>
     * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
     * <p>
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     * 否则，x 将会向 y 发送一条好友请求。
     * <p>
     * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
     * <p>
     * 返回在该社交媒体网站上产生的好友请求总数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 同时满足以下条件才发短信
     * age[y] > 0.5 * age[x] + 7
     * age[y] <= age[x]
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {

        //双指针
        Arrays.sort(ages);
        int res = 0;
        int left , right ;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 15) {
                continue;
            }
            left=i;
            right=i;
            while (ages[left] <= 0.5 * ages[i] + 7) {
                left--;
            }
            while (right + 1 < ages.length && ages[right + 1] <= ages[i]) {
                right++;
            }
            res += right - left;
        }
        return res;
    }


}
