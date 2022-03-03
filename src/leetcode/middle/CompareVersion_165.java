package leetcode.middle;

public class CompareVersion_165 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int idx1 = 0, idx2 = 0;
        int l2 = split2.length;
        int l1 = split1.length;
        while (idx1 < l1 || idx2 < l2) {
            int v1 = idx1 < l1 ? Integer.parseInt(split1[idx1]) : 0;
            int v2 = idx2 < l2 ? Integer.parseInt(split2[idx2]) : 0;
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
            idx1++;
            idx2++;
        }
        return 0;
    }

    public int compareVersion_Optimize(String version1, String version2) {
        int l1 = version1.length();
        int l2 = version2.length();
        int idx1 = 0, idx2 = 0;
        while (idx1 < l1 || idx2 < l2) {
            int x = 0;
            for (; idx1 < l1 && version1.charAt(idx1) != '.'; idx1++) {
                x = x * 10 + version1.charAt(idx1) - '0';
            }
            idx1++;
            int y = 0;
            for (; idx2 < l2 && version2.charAt(idx2) != '.'; idx2++) {
                y = y * 10 + version2.charAt(idx2) - '0';
            }
            idx2++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
