package leetcode.easy;

public class TotalMoney_1716 {
    public int totalMoney(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                ans += (i - 7) / 7;
                ans += 7;
            } else {
                ans += i / 7;
                ans += i % 7;
            }
        }
        return ans;
    }

    public int totalMoney_Optimize(int n) {
        //一周是28 下一周是28+7 对于7能整除的部分，可以直接使用这部分数据
        int m = n / 7;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans += 28;
            ans += i * 7;
        }
        for (int i = m * 7 + 1; i <= n; i++) {
            ans += i / 7;
            ans += i % 7;
        }
        return ans;
    }
}
