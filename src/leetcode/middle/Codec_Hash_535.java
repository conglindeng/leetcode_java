package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class Codec_Hash_535 {


    private Map<Integer, String> map = new HashMap<>();
    //为什么要mod两次
    //建立单射

    //TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，
    // 它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        return null;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer id = Integer.parseInt(shortUrl.substring(19));
        return map.get(id);
    }


}