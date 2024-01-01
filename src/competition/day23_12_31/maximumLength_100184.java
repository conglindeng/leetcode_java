package competition.day23_12_31;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class maximumLength_100184 {

    public int maximumLength(String s) {
        Map<Character, Map<Integer, Long>> count = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); ) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            checkAllSubStr(j - i, s.charAt(i), count);
            i = j;
        }
        for (Entry<Character, Map<Integer, Long>> stringIntegerEntry : count.entrySet()) {
            Map<Integer, Long> c = stringIntegerEntry.getValue();
            for (Entry<Integer, Long> integerLongEntry : c.entrySet()) {
                Integer k = integerLongEntry.getKey();
                Long v = integerLongEntry.getValue();
                if (v > 2) {
                    res = Math.max(k, res);
                }
            }
        }
        return res;
    }

    private void checkAllSubStr(int l, char c, Map<Character, Map<Integer, Long>> count) {
        count.putIfAbsent(c, new HashMap<>());
        Map<Integer, Long> map = count.get(c);
        for (int i = 1; i <= l; i++) {
            map.put(i, map.getOrDefault(i, 0L) + l - i + 1);
        }
    }

}
