package leetcode.middle;

import java.util.Arrays;

public class ShipWithinDays_1011 {
    public static int shipWithinDays(int[] weights,int D){
        int min = Arrays.stream(weights).min().getAsInt();
        int max = Arrays.stream(weights).sum();
        while(min<max){
            int mid=(min+max)/2;
            int cur=0,need=1;
            for (int weight : weights) {
                if(cur+weight>mid){
                    need++;
                    cur=0;
                }
                cur+=weight;
            }
            if(need<=D){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return min;


        //region Description
       /* // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-d-tian-nei-song-da-bao-guo-de-neng-l-ntml/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
        //endregion
    }
}
