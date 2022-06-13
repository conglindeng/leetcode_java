package leetcode.middle;

/**
 * @ClassName OneEditAway
 

 * @Version 1.0
 */
public class OneEditAway_01_05 {

    public boolean oneEditAway(String first, String second) {
        int l2 = second.length();
        int l1 = first.length();
        if (Math.abs(l1 - l2) > 1) {
            return false;
        }
        if (Math.max(l1, l2) < 2) {
            return true;
        }
        boolean flag = l1 == l2;
        int differCount = 0;
        int m = 0, n = 0;
        while (m < l1 && n < l2) {
            char c1 = first.charAt(m);
            char c2 = second.charAt(n);
            if (c1 != c2) {
                differCount++;
                if(!flag){
                    if (n + 1 < l2 && c1 == second.charAt(n + 1)) {
                        n++;
                        continue;
                    } else if (m + 1 < l1 && first.charAt(m + 1) == c2) {
                        m++;
                        continue;
                    } else if (m != l1 - 1 && n != l2 - 1) {
                        return false;
                    }
                }
            }
            m++;
            n++;
        }
        differCount += l1 - m;
        differCount += l2 - n;
        return differCount < 2;
    }

}
