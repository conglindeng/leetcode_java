package newcode;

import java.util.*;


public class NC93_LRU {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    
    private LinkedHashMap<Integer,Integer> cache;
    private int size;
    public int[] LRU (int[][] operators, int k) {
        // write code here
        List<Integer> result=new ArrayList();
        size=k;
        cache=new LinkedHashMap(k,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size()>size;
            }
        };
        int height = operators.length;
        for(int i=0;i<height;i++){
            int[] cur=operators[i];
            if(cur[0]==1){
                cache.put(cur[1],cur[2]);
            }else{
                result.add(cache.getOrDefault(cur[1], -1));
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }
}