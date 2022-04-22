package leetcode.middle;

public class CountVowels_2063 {
    public long countVowels(String word) {
        long res = 0;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                if (i == 0 || i == l - 1) {
//                    res += l;
//                } else {
                res += (long) (i + 1) * (l - i);
//                }
            }
        }
        return res;
    }

    public long countVowels_Optimize(String word) {
        return 0L;
    }
}
