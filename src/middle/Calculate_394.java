package middle;

import java.util.Stack;

public class Calculate_394 {
    public static int calculate(String s){
        char[] chars = s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar =='-'){
                int first=stack.pop();
                int second=chars[++i];
                stack.push(first-second);
                continue;
            }
            if(aChar =='+'){


                continue;
            }
            if(aChar == ')'){

            }
            //stack.push(chars[i]);
        }
        return stack.peek();
    }
}
