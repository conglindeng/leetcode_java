package leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseParentheses_1190 {
    /**
     * 给出一个字符串 s（仅含有小写英文字母和括号）。
     *
     * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     *
     * 注意，您的结果中 不应 包含任何括号。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "(abcd)"
     * 输出："dcba"
     *
     * @param s
     * @return
     */
    public String reverseParentheses(String s){
        Deque<Character> work=new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c==')'){
                List<Character> temp=new ArrayList<>();
                while(!work.isEmpty()){
                    Character pop = work.pop();
                    if(pop=='(')
                        break;
                    temp.add(pop);
                }
                temp.forEach(x->{work.push(x);});
            }else{
                work.push(c);
            }
        }
        StringBuilder result=new StringBuilder();
        while(!work.isEmpty()){
            result.append(work.pop());
        }
        return result.reverse().toString();
    }
}
