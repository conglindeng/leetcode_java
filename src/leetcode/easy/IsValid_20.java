package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid_20 {
    public static boolean isValid(String s){
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar == '(') {
                stack.push(aChar);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(aChar==')' && pop !='('){
                    return false;
                }
                if(aChar==']' && pop !='['){
                    return false;
                }
                if(aChar=='}' && pop !='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
