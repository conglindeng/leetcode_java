package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146_Optimize {
    static class MyEntry {
        int value;
        MyEntry pre;
        MyEntry next;

        public MyEntry(int value, MyEntry pre, MyEntry next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public MyEntry(int value) {
            this(value,null,null);
        }
    }
    private int capcity;
    private Map<Integer,MyEntry> cache;
    MyEntry tail;
    MyEntry head;

    public LRUCache_146_Optimize(int capcity) {
        cache=new HashMap<>(capcity);
        this.capcity = capcity;
        tail=null;
        head=new MyEntry(-1);
    }

    public int get(int key){
        MyEntry entry = cache.get(key);
        if(entry==null){
            return -1;
        }
        changePosition(entry);
        return entry.value;
    }

    private void changePosition(MyEntry entry) {
        //先切断当前位置的前后关系
        entry.pre.next=entry.next;
        entry.next.pre=entry.pre;
        //将当前节点插入到head之后
        head.pre=entry;
        entry.next=head;
        entry.pre=null;
    }

    public void put(int key,int value){
        if(cache.get(key)!=null){

        }
        MyEntry myEntry;
        if(tail==null){
            myEntry = new MyEntry(value, head, null);
            tail=myEntry;
            head.next=tail;
        }else{
            myEntry = new MyEntry(value, tail, null);
            tail.next=myEntry;
            tail=myEntry;
        }
        cache.put(key,myEntry);
        if(cache.size()>capcity){
            //移除最近最少使用的元素

        }
    }
}
