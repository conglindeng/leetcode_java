package competition.day23_12_17;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]-1]++;
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < n * n; i++) {
            if (count[i] == 2) {
                res[1] = i + 1;
            }
            if (count[i] == 0) {
                res[0] = i + 1;
            }
        }
        return res;
    }
}
