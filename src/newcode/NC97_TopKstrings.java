package newcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NC97_TopKstrings {
    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        Map<String, Integer> count = new HashMap<>();
        for (String s : strings) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        List<Pair<String, Integer>> collect = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            collect.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        collect.sort((a, b) -> {
            int countA = a.getValue();
            int countB = b.getValue();
            if (countA == countB) {
                String sA = a.getKey();
                String sB = b.getKey();
                return sA.compareTo(sB);
            }
            return countB - countA;
        });
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0]=collect.get(i).getKey();
            res[i][1]=collect.get(i).getValue().toString();
        }
        return res;
    }

    private static class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
