package leetcode.middle;

import java.util.Stack;

public class EvalRPN_150 {
    public  int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String v = tokens[i];
            boolean isNum = v.matches("^-?[0-9]+");
            if(isNum){
                stack.push(Integer.valueOf(v));
            }else{
                int second=stack.pop();
                int first=stack.pop();
                int result=execute(v,first,second);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    private  int execute(String type,int first,int second){
        int result=0;
        switch (type){
            case "-":
                result= first-second;
                break;
            case "+":
                result= first+second;
                break;
            case "/":
                result= first/second;
                break;
            case "*":
                result= first*second;
                break;
        }
        return result;
    }

}
