package leetcode.middle;

import struct.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxDepth_559 {
    public int maxDepth(Node root) {
        //深度优先
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        AtomicInteger max = new AtomicInteger();
        root.children.forEach(item -> {
            max.set(Math.max(max.get(), maxDepth(item)));
        });
        return max.get() + 1;
    }

    public int maxDepth_other(Node root) {
        //广度优先
        if (root == null) {
            return 0;
        }
        Queue<Node> next=new LinkedList<>();
        next.add(root);
        int res=0;
        while(next.size()>0){
            List<Node> temp=new ArrayList<>();
            while(!next.isEmpty()){
                Node poll = next.poll();
                if(poll.children!=null && !poll.children.isEmpty())
                    temp.addAll(poll.children);
            }
            next.addAll(temp);
            res++;
        }
        return res;
    }
}
