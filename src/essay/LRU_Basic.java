package essay;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 *  LRU 缓存实现
 */
public class LRU_Basic {

    private LinkedHashMap<Integer, Integer> cache;
    private Integer capacity;

    public LRU_Basic(Integer capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public void put(Integer key, Integer value) {
        cache.put(key, value);
    }

    public Integer get(Integer key) {
        return cache.getOrDefault(key, -1);
    }
}
