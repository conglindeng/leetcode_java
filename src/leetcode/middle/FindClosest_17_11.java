package leetcode.middle;

/**
 * @ClassName FindClosest_17_11
 * @Author conglindeng
 * @Date 2022/5/27 09:31
 * @Version 1.0
 */
public class FindClosest_17_11 {

    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;

    }
}
