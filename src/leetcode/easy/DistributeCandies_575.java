package leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

public class DistributeCandies_575 {
    /**
     * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
     * <p>
     * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
     * <p>
     * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：candyType = [1,1,2,2,3,3]
     * 输出：3
     * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distribute-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        int length = candyType.length;
        int maxCanEate = length / 2;
        Set<Integer> typeSet = new TreeSet<>();
        int typeSize = 0;
        for (int i = 0; i < length; i++) {
            if (maxCanEate > 0 && !typeSet.contains(candyType[i])) {
                typeSize++;
                typeSet.add(candyType[i]);
                maxCanEate--;
            }
        }
        return typeSize;
    }
}
