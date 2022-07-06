package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class Codec_535 {

    public static final String URL = "http://tinyurl.com/";
    int id = 0;
    private Map<Integer, String> map = new HashMap<>();

    //TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，
    // 它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!map.containsValue(longUrl)) {
            map.put(id, longUrl);
        }
        String res = URL + id;
        id++;
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer id = Integer.parseInt(shortUrl.substring(19));
        return map.get(id);
    }


}