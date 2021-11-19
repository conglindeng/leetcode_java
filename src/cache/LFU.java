package cache;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LFU {
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
    Map<Integer, Node> entrys;
    Map<Date, Node> dateMap;
    Map<Integer, Node> countMap;

    int capcity;
    int count;
    int minCount;
    Date maxDate;

    public LFU(int capcity) {
        entrys = new HashMap<>(capcity);
        this.capcity = capcity;
        this.count = 0;
    }

    public int get(int key) {
        Node node = entrys.get(key);
        if (node == null) {
            return -1;
        }
        node.count++;
        node.lastUpdate = new Date();
        minCount = Math.min(minCount, node.count);
        updateMaxDate(node.lastUpdate);
        return node.value;
    }


    public void set(int key, int value) {
        Node node = null;
        if (!entrys.containsKey(key)) {
            if (count == capcity) {
                //remove使用频率最小的
                removeOldOne();
            }
            node = new Node(key, value);
            entrys.put(key, node);
        } else {
            node = entrys.get(key);
            node.count++;
            node.lastUpdate = new Date();
        }
        minCount = Math.min(minCount, node.count);
        updateMaxDate(node.lastUpdate);
    }

    private void removeOldOne() {

    }


    private void updateMaxDate(Date curOpDate) {
        if (curOpDate == null) {
            //throw new NullPointerException();
            return;
        }
        if (maxDate == null) {
            maxDate = curOpDate;
        } else {
            maxDate = curOpDate.after(maxDate) ? maxDate : curOpDate;
        }
    }

    class Node {
        int key;
        int value;
        int count;
        Date lastUpdate;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            count = 1;
            lastUpdate = new Date();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (key != node.key) return false;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}
