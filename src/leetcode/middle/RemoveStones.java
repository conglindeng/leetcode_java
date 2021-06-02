package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class RemoveStones {

    public static int removeStones(int[][] stones){
        UnionFind unionFind=new UnionFind();
        for (int i = 0; i < stones.length; i++) {
            unionFind.union(stones[i][0]+10001,stones[i][1]);
        }
        return stones.length-unionFind.getCount();
    }


    public static void main(String[] args) {
        int[][] stones=new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(removeStones(stones));
    }

    static class UnionFind{
        private Map<Integer,Integer> parent;
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(Integer x,Integer y){
            int xt=find(x);
            int yt=find(y);
            if(xt==yt){
                return;
            }
            parent.put(xt,yt);
            count--;
        }
    }
}
