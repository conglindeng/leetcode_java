package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146_Optimize {
    static class MyEntry {
        int key;
        int value;
        MyEntry pre;
        MyEntry next;

        public MyEntry(int key, int value) {
            this.value = value;
            this.key = key;
        }

        public MyEntry() {

        }
    }

    private int capcity;
    private Map<Integer, MyEntry> cache;
    MyEntry tail;
    MyEntry head;

    public LRUCache_146_Optimize(int capcity) {
        if (capcity <= 0) {
            capcity = 16;
        }
        cache = new HashMap<>(capcity);
        this.capcity = capcity;
        tail = null;
        head = null;
/*        tail = new MyEntry();
        head = new MyEntry();
        tail.pre=head;
        head.next=tail;*/
    }

    public int get(int key) {
        MyEntry entry = cache.get(key);
        if (entry == null) {
            return -1;
        }
        moveToHead(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        MyEntry myEntry = cache.get(key);
        if (myEntry != null) {
            myEntry.value = value;
            moveToHead(myEntry);
        } else {
            if (cache.size() +1 > capcity) {
                //移除最近最少使用的元素
                removeOldestEntry();
            }
            myEntry = new MyEntry(key, value);
            changePositionAftreInsert(myEntry);
            cache.put(key, myEntry);
        }
    }

    private void removeOldestEntry() {
        if (tail == null)
            return;
        if(tail==head){
            tail=null;
            head=null;
            return;
        }
        cache.remove(tail.key);
        MyEntry pre = tail.pre;
        tail.pre = null;
        tail = pre;
        pre.next = null;
    }

    private void moveToHead(MyEntry entry) {
        MyEntry next = entry.next;
        MyEntry pre = entry.pre;
        if (pre == null) {
            return;
        }
        if (next == null) {
            pre.next = null;
            tail = pre;

            entry.next = head;
            head.pre = entry;
            entry.pre = null;
            head = entry;
            return;
        }
        pre.next = next;
        next.pre = pre;

        entry.next = head;
        head.pre = entry;
        entry.pre = null;
        head = entry;
    }


    private void changePositionAftreInsert(MyEntry entry) {
        if (head == null && tail == null) {
            head = entry;
            tail = entry;
            return;
        }
        entry.next = head;
        head.pre = entry;
        head = entry;
    }
}
