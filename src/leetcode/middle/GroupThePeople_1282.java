package leetcode.middle;

import java.util.*;

public class GroupThePeople_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes){
        Map<Integer,List<Integer>> pool=new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = pool.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            pool.put(groupSizes[i],orDefault);
        }
        List<List<Integer>> result=new ArrayList<>();
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = pool.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> next = iterator.next();

            List<Integer> value = next.getValue();
            Integer key = next.getKey();
            List<Integer> curList=new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                curList.add(value.get(i));
                if(curList.size()==key){
                    result.add(curList);
                    curList=new ArrayList<>();
                }
            }
        }
        return result;
    }



    public List<List<Integer>> groupThePeople_Optimize(int[] groupSizes){
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer,List<Integer>> pool=new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = pool.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            if(orDefault.size()==groupSizes[i]){
                result.add(orDefault);
                orDefault= new ArrayList<>();
            }
            pool.put(groupSizes[i],orDefault);
        }
        return result;
    }


}
