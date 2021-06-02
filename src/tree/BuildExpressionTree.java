package tree;

import struct.TreeNode_T;

import java.util.*;

public class BuildExpressionTree {
    private static List<Character> expressions=new ArrayList<>();
    static {
        expressions.add('-');
        expressions.add('+');
        expressions.add('/');
        expressions.add('*');
    }
    public static TreeNode_T<Character> buildExpressionTree(String expression){
        char[] chars = expression.toCharArray();
        Deque<TreeNode_T<Character>> treeNodeDeque=new LinkedList<>();
        for (char c : chars) {
            if(expressions.contains(c)){
                TreeNode_T<Character> second = treeNodeDeque.pop();
                TreeNode_T<Character> first = treeNodeDeque.pop();
                TreeNode_T<Character> newNode=new TreeNode_T(c,first,second);
                treeNodeDeque.push(newNode);
            }else{
                treeNodeDeque.push(new TreeNode_T<>(c));
            }
        }
        return treeNodeDeque.pop();
    }
}
