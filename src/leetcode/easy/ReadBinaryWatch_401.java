package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch_401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 8) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int bitCount = Integer.bitCount(i);
            if (bitCount == turnedOn) {
                int hour=i>>>6;
                int minute=i&0x3f;
                if(hour<=12 && minute<=60)
                    res.add(hour+":"+ (minute<10?"0"+minute:minute));
            }
        }
        return res;
    }
}
