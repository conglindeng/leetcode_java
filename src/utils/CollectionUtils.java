package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName CollectionUtils
 * @Author conglindeng
 * @Version 1.0
 */
public class CollectionUtils {

    public static <T> List<T> convertString2List(String data, Function<String, T> function) {
        if (data == null || data.length() == 0 || function == null) {
            return new ArrayList<>();
        }
        List<T> res = new ArrayList<>();
        if (data.startsWith("[")) {
            data = data.substring(1, data.length() - 2);
        }
        String[] split = data.split(",");
        for (String s : split) {
            res.add(function.apply(s.trim()));
        }
        return res;
    }
}
