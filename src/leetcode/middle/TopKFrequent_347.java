package leetcode.middle;

import java.util.*;

public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums ,int k){
        Map<Integer,Integer> frequentMap=new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num,frequentMap.getOrDefault(num,0)+1);
        }
        List<Integer>[] bukets=new List[nums.length+1];
        Iterator<Map.Entry<Integer, Integer>> iterator = frequentMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if(bukets[value]==null){
                bukets[value] = new ArrayList<>();
            }
            bukets[value].add(next.getKey());
        }
        List<Integer> result=new ArrayList<>();
        for (int i = nums.length; i >=0 && result.size()<k; i--) {
            result.addAll(bukets[i]);
        }
        return result.stream().mapToInt(x->x).toArray();
    }

    public static List<String> topKFrequent(String[]  words,int k) {
        Map<String,Integer> frequentMap=new HashMap<>();
        Arrays.stream(words).forEach(x->{
            frequentMap.put(x,frequentMap.getOrDefault(x,0)+1);
        });
        List<String> wordList=new ArrayList<>(frequentMap.keySet());
        Collections.sort(wordList, (a,b)->{
            int i = frequentMap.get(b).compareTo(frequentMap.get(a));
            if(i==0){
                return b.compareTo(a);
            }else{
                return i;
            }
        });
        return wordList.subList(0,k);
    }


    public static List<String> topKFrequent_new(String[]  words,int k) {
        Map<String,Integer> frequentMap=new HashMap<>();
        Arrays.stream(words).forEach(x->{
            frequentMap.put(x,frequentMap.getOrDefault(x,0)+1);
        });
        PriorityQueue<String> heap=new PriorityQueue<>(
/*                (w1, w2) -> frequentMap.get(w1).equals(frequentMap.get(w2)) ?
                w2.compareTo(w1) : frequentMap.get(w1) - frequentMap.get(w2)*/

                (a,b)->{
            int i = frequentMap.get(a).compareTo(frequentMap.get(b));
            if(i==0){
                return b.compareTo(a);
            }else{
                return i;
            }
        });
        Iterator<Map.Entry<String, Integer>> iterator = frequentMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            heap.offer(next.getKey());
            if(heap.size()>k){
                heap.poll();
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        while(!heap.isEmpty())
            strings.add(heap.poll());
        Collections.reverse(strings);
        return strings;
    }

}
