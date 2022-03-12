package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用的缓存
 */
public class LRUCache {

    Map<Integer, Entry> cache;
    Entry head, tail;
    int capacity;

    public LRUCache(int capcity) {
        this.capacity = capcity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Entry entry = cache.get(key);
        if (entry == null) {
            return -1;
        }
        //调整位置，移动到头部
        move2Head(entry);
        return entry.val;
    }

    public void put(int key, int value) {
        Entry entry = cache.get(key);
        if (entry != null) {
            //修改val并调整位置到头部
            entry.val = value;
            move2Head(entry);
        } else {
            //超过容量，移除一个最近最久未使用的元素
            if (cache.size() == capacity) {
                removeLastestUsed();
            }
            entry = new Entry(key, value);
            cache.put(key, entry);
            insert2Head(entry);
        }
    }

    /**
     * 移除最近最久未使用的元素
     */
    private void removeLastestUsed() {
        if (tail == null) {
            return;
        }
        cache.remove(tail.key);
        if (tail == head) {
            tail = null;
            head = null;
            return;
        }
        Entry pre = tail.pre;
        pre.next = null;
        tail.pre = null;
        tail = pre;
    }

    /**
     * 将元素移动到头部，只对已存在的entry操作
     *
     * @param entry
     */
    private void move2Head(Entry entry) {
        Entry pre = entry.pre;
        Entry next = entry.next;
        if (pre == null) {
            //说明是head节点，不用继续操作
            return;
        }
        if (next == null) {
            //说明是尾节点，需要更改tail的指向
            pre.next = null;
            entry.pre = null;
            tail = pre;
            insert2Head(entry);
            return;
        }
        pre.next = next;
        next.pre = pre;
        insert2Head(entry);
    }

    private void insert2Head(Entry entry) {
        if (tail == null && head == null) {
            head = entry;
            tail = entry;
            return;
        }
        Entry head = this.head;
        entry.next = head;
        entry.pre = null;
        head.pre = entry;
        this.head = entry;
    }


    private static class Entry {
        int key;
        int val;
        Entry pre;
        Entry next;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
