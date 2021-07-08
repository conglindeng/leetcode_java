package newcode;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class NC55_LongestCommonPrefix {
    MultinomialTreeNode root=new MultinomialTreeNode('0');
    /**
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        // write code here
        buildMultinomialTree(strs);
        return bfs();
    }

    private String bfs() {
        StringBuilder res=new StringBuilder();
        MultinomialTreeNode cur=root;
        while(cur.childrens.size()==1){
            MultinomialTreeNode multinomialTreeNode = cur.childrens.get(0);
            res.append(multinomialTreeNode.val);
            cur=multinomialTreeNode;
        }
        return res.toString();
    }

    private void buildMultinomialTree(String[] strs) {
        for (String str : strs) {
            MultinomialTreeNode cur=root;
            if(cur.childrens.size()>1){
                return;
            }
            if(str==""){
                cur.childrens.add(new MultinomialTreeNode('0'));
                continue;
            }
            for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                MultinomialTreeNode newT=new MultinomialTreeNode(c);
                int index = cur.childrens.indexOf(newT);
                if(index!=-1){
                    cur=cur.childrens.get(index);
                }else{
                    cur.childrens.add(newT);
                    cur=newT;
                }
            }
        }
    }

    private static class MultinomialTreeNode{
        char val;
        List<MultinomialTreeNode> childrens;

        public MultinomialTreeNode(char val) {
            this.val = val;
            this.childrens = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            MultinomialTreeNode that = (MultinomialTreeNode) o;

            return this.val==that.val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }
}
