package leetcode.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import struct.Pair;

public class TimeMap_981 {
    /**
     * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
     *
     * 1. set(string key, string value, int timestamp)
     *
     * 存储键 key、值 value，以及给定的时间戳 timestamp。
     * 2. get(string key, int timestamp)
     *
     * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
     * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
     * 如果没有值，则返回空字符串（""）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

/*    private Map<String,TreeMap<Integer,String>> map;

     *//** Initialize your data structure here. *//*
    public TimeMap_981() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key,new TreeMap<Integer, String>());
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = map.get(key);
        if(timeMap==null)
            return null;
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        return entry==null?null:entry.getValue();
    }*/


    private Map<String,List<Pair<Integer,String>>> map;

    public TimeMap_981(){
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key,new ArrayList<>());
        List<Pair<Integer, String>> pairs = map.get(key);
        pairs.add(new Pair<>(timestamp,value));
        //pairs.sort((x,y)->{return x.getKey().compareTo(y.getKey());});
        pairs.sort((Comparator.comparing(Pair::getKey)));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairs = map.get(key);
        int left=-1;
        int right=pairs.size()-1;
        while(left<right){
            int mid=(left+right)/2;
            Pair<Integer, String> pair = pairs.get(mid);
            if(pair.getKey()>timestamp){
                right=mid;
            }else{
                left=mid;
            }
        }
        return left==-1?"":pairs.get(left).getValue();

    }

}
