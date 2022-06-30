package leetcode.middle;

public class FindLUSlength_522 {

    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubSeq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }


    private boolean isSubSeq(String one, String second) {
        int pt1 = 0, pt2 = 0;
        while (pt1 < one.length() && pt2 < second.length()) {
            if (one.charAt(pt1) == second.charAt(pt2)) {
                pt1++;
            }
            pt2++;
        }
        return pt1 == one.length();
    }
}
