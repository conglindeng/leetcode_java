package leetcode.middle;

import java.util.HashMap;

public class Trie_208 {
    Trie_208[] childrens;
    boolean isEnd;
    /** Initialize your data structure here. */
    public Trie_208() {
        childrens=new Trie_208[26];
        isEnd=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie_208 trie=this;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';
            Trie_208 children = trie.childrens[index];
            if (children == null) {
                children = new Trie_208();
                trie.childrens[index]=children;
            }
            trie = children;
        }
        trie.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie_208 trie=this;
        for (char aChar : chars) {
            Trie_208 children = trie.childrens[aChar - 'a'];
            if(children==null){
                return false;
            }
            trie=children;
        }
        return trie.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie_208 trie=this;
        for (char aChar : chars) {
            Trie_208 children = trie.childrens[aChar - 'a'];
            if(children==null){
                return false;
            }
            trie=children;
        }
        return true;
    }

}