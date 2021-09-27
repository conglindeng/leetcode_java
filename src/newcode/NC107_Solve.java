package newcode;

public class NC107_Solve {
    public int gg(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i] >= a[i + 1])
                    max = Math.max(max, i);
                continue;
            }
            if (i == a.length - 1) {
                if (a[i] >= a[i - 1])
                    max = Math.max(max, i);
                continue;
            }
            if (a[i] >= a[i - 1] && a[i] >= a[i + 1]) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
