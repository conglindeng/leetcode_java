package competition.day23_12_31;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class maximumLength_100185 {

    public int maximumLength(String s) {
        Map<String, Integer> count = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                String substring = s.substring(i, j + 1);
                count.put(substring, count.getOrDefault(substring, 0) + 1);
                j++;
            }
            int l = j - i;

            if (l > 2) {
                res = Math.max(res, l - 2);
            }
        }
        for (Entry<String, Integer> stringIntegerEntry : count.entrySet()) {
            Integer c = stringIntegerEntry.getValue();
            String s_ = stringIntegerEntry.getKey();
            if (c >= 3) {
                res = Math.max(res, s_.length());
            }
        }
        return res;
    }
}
