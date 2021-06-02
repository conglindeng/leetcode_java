package leetcode.easy;

import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap_706 {

    public static void main(String[] args) {

    }

    private static int BASE=769;
    private LinkedList[] arrays;
    /** Initialize your data structure here. */
    public MyHashMap_706() {
        arrays=new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            arrays[i]=new LinkedList<Node>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkedList<Node> nodes= arrays[hash(key)];
        Iterator<Node> iterator= nodes.iterator();
        boolean isNew=true;
        while(iterator.hasNext()){
            Node node= iterator.next();
            if(node.getKey()==key){
                node.setValue(value);
                isNew=false;
                break;
            }
        }
        if(isNew){
            nodes.addFirst(new Node(key,value));
        }
        return;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Node> nodes=arrays[hash(key)];
        Iterator<Node> iterator= nodes.iterator();
        while(iterator.hasNext()){
            Node node= iterator.next();
            if(node.getKey()==key){
                return node.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Node> nodes=arrays[hash(key)];
        Iterator<Node> iterator= nodes.iterator();
        while(iterator.hasNext()){
            Node node= iterator.next();
            if(node.getKey()==key){
                iterator.remove();
            }
        }
        return;
    }

    private int hash(int key){
        return key % BASE;
    }


    class Node{
        int key;
        int value;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }
        public void setValue(int value){
            this.value=value;
        }

    }
}
