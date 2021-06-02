package leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveDuplicates_1047 {
    public static String removeDuplicates(String S) {
        LinkedList<Character> stack=new LinkedList<>();
        char[] chars = S.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if(!stack.isEmpty() && stack.getLast()==chars[i]){
                stack.removeLast();
                continue;
            }
            stack.addLast(chars[i]);
        }
        StringBuilder result=new  StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.removeFirst());
        }
        return result.toString();
    }


    public static String removeDuplicates_1(String S) {
        StringBuilder result=new StringBuilder();
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(result.length()==0){
                result.append(chars[i]);
            }else if(result.charAt(result.length()-1)==chars[i]){
                result.deleteCharAt(result.length()-1);
            }else{
                result.append(chars[i]);
            }
        }


        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates_1("abbaca"));
    }
}
