package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 最不经常使用
 */
public class LFUCache {
    /**
     * 一个缓存结构需要实现如下功能。
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
     * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
     * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
     * [要求]
     * set和get方法的时间复杂度为O(1)
     */

    int capacity;
    Map<Integer, Entry> cache;
    Entry head;

    //要点
    // 1 当频率相同时，此时是lru的策略
    // 2 用什么数据结构存储频率的大小关系，且最好同一频率的数据可以快捷的拿到
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Entry entry = cache.get(key);
        if (entry != null) {
            updateState(entry);
            return entry.val;
        }
        return -1;
    }

    private void updateState(Entry entry) {

    }

    public void put(int key, int value) {
        Entry entry = cache.get(key);
        if (entry != null) {
            entry.val = value;
            updateState(entry);
            return;
        }
        if (cache.size() == capacity) {
            removeOneEntry();
        }
        entry = new Entry(key, value);
        cache.put(key, entry);
        insert2Head(entry);
    }

    private void removeOneEntry() {

    }

    private void insert2Head(Entry entry) {
        if (head == null) {
            head = entry;
            return;
        }
        Entry down = head.down;
        entry.next = head;
        head.pre = entry;
        head = entry;
        if (down != null) {
            head.next = down;
            down.up = head;
        }
    }


    static class Entry {
        int frequency;
        int key;
        int val;
        // 用于指向前后的频率大小
        Entry pre, next;
        // 用于指向使用时间的前后关系
        Entry up, down;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
            frequency = 1;
        }
    }

}
