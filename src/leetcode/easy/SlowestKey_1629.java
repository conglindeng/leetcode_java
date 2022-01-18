package leetcode.easy;

public class SlowestKey_1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxCount = -1;
        char ans = '-';
        for (int i = 0; i < releaseTimes.length; i++) {
            int curCount = i > 0 ? releaseTimes[i] - releaseTimes[i - 1] : releaseTimes[i];
            char c = keysPressed.charAt(i);
            //  如果maxCount<curCount，则直接更新ans和maxCount
            //  如果maxCount==curCount且当前char的字典顺序大于ans，则进行更新
            if (curCount > maxCount || (curCount == maxCount && c > ans)) {
                maxCount = curCount;
                ans = c;
            }
        }
        return ans;
    }
}
