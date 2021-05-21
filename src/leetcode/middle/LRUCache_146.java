package leetcode.middle;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class  LRUCache_146 extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache_146(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity=initialCapacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }


    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }


    public void put(int key, int value) {
        super.put(key, value);
    }
}

/*
 此has-a(静态内部类)效率高于上一继承linkedHashMap的写法
class LRUCache {

    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        cache=new LinkedHashMap(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size()>capacity;
            }
        };
    }

    public int get(int key) {
        if(cache==null)
            return-1;
        return cache.get(key)==null?-1:cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}

 */
