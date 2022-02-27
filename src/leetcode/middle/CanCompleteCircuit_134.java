package leetcode.middle;

public class CanCompleteCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int length = cost.length;
        for (int i = 0; i < length; ) {
            int j = 0;
            int costSum = 0, gasSum = 0;
            for (; j < length; j++) {
                int idx = (i + j) % length;
                costSum += cost[idx];
                gasSum += gas[idx];
                if (costSum > gasSum) {
                    break;
                }
            }
            if (j == length) {
                return i;
            } else {
                i = i + j + 1;
            }
        }
        return -1;
    }
}
