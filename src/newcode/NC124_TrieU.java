package newcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NC124_TrieU {

    Node root = new Node(false, '-', 0);

    /**
     * 字典树又称为前缀树或者Trie树，是处理字符串常用的数据结构。
     * <p>
     * 假设组成所有单词的字符仅是‘a’～‘z’，请实现字典树的结构，并包含以下四个主要的功能。
     * <p>
     * 1. void insert(String word)：添加word，可重复添加；
     * 2. void delete(String word)：删除word，如果word添加过多次，仅删除一次；
     * 3. boolean search(String word)：查询word是否在字典树中出现过(完整的出现过，前缀式不算)；
     * 4. int prefixNumber(String pre)：返回以字符串pre作为前缀的单词数量。
     * <p>
     * 现在给定一个m，表示有m次操作，每次操作都为以上四种操作之一。每次操作会给定一个整数op和一个字符串word，op代表一个操作码，如果op为1，则代表添加word，op为2则代表删除word，op为3则代表查询word是否在字典树中，op为4代表返回以word为前缀的单词数量（数据保证不会删除不存在的word）。
     * <p>
     * 对于每次操作，如果op为3时，如果word在字典树中，请输出“YES”，否则输出“NO”；如果op为4时，请输出返回以word为前缀的单词数量，其它情况不输出。
     * 示例1
     * 输入：
     * [["1","qwer"],["1","qwe"],["3","qwer"],["4","q"],["2","qwer"],["3","qwer"],["4","q"]]
     * 返回值：
     * ["YES","2","NO","1"]
     *
     * @param operators string字符串二维数组 the ops
     * @return string字符串一维数组
     */
    public String[] trieU(String[][] operators) {
        // write code here
/*        insert("abc");
        insert("a");
        insert("abn");
        insert("abnh");
        insert("nh");
        boolean abn = search("abn");
        delete("abn");
        delete("abnh");
        boolean abn2 = search("abn");
        boolean ab = search("ab");
        int count = prefixNumber("a");*/
        if (operators == null || operators.length == 0) {
            return null;
        }
        List<String> temp = new ArrayList<>();
        for (String[] operator : operators) {
            if (operator[0] == "1") {
                insert(operator[1]);
            }
            if (operator[0] == "2") {
                delete(operator[1]);
            }
            if (operator[0] == "3") {
                if (search(operator[1])) {
                    temp.add("YES");
                } else {
                    temp.add("NO");
                }
            }
            if (operator[0] == "4") {
                temp.add(String.valueOf(prefixNumber(operator[1])));
            }
        }
        String[] res = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node cur = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            Node next = cur.next.get(aChar);
            if (next == null) {
                next = new Node(false, aChar, 1);
                cur.next.put(aChar, next);
            } else {
                next.count++;
            }
            cur = next;
        }
        cur.isLast = true;
    }

    private void delete(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node cur = root;
        //pre用于回溯删除
        Node pre = root;
        char[] chars = word.toCharArray();
        Deque<Node> work = new LinkedList<>();
        for (char aChar : chars) {
            Node node = cur.next.get(aChar);
            //如果取出来为空，说明当前字典树中无该word
            if (node == null) {
                return;
            }
            work.push(node);
            pre = cur;
            cur = node;
        }
        if (cur.next == null || cur.next.size() == 0) {
            //需要回溯删除节点
            while (!work.isEmpty()) {
                Node node = work.poll();
                node.count--;
                if (node.count == 0) {
                    pre.next.remove(node);
                }
                pre = node;
            }
        } else {
            //修改是否是最后一个节点的标志位
            cur.isLast = false;
        }
    }

    private boolean search(String word) {
        Node last = findLast(word);
        return last != null && last.isLast;
    }

    private int prefixNumber(String pre) {
        Node last = findLast(pre);
        return getPrefixNumber(last, 0);
    }

    private int getPrefixNumber(Node root, int count) {
        int res = count;
        Map<Character, Node> next = root.next;
        for (Map.Entry<Character, Node> nodeEntry : next.entrySet()) {
            Node node = nodeEntry.getValue();
            if (node.isLast) {
                res++;
            }
            res = getPrefixNumber(node, res);
        }
        return res;
    }

    private Node findLast(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        Node cur = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            Node node = cur.next.get(aChar);
            if (node == null) {
                return null;
            }
            cur = node;
        }
        return cur;
    }


    private static class Node {
        int count;
        boolean isLast;
        char val;
        Map<Character, Node> next;

        public Node(boolean isLast, char val, int count) {
            this.count = count;
            this.isLast = isLast;
            this.val = val;
            next = new HashMap<>();
        }
    }
}
