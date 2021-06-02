package leetcode.middle;

import java.util.*;

public class NumRabbits_781 {
    public static int numRabbits(int[] answers){
        int result=0;
        Deque<Integer> stack=new LinkedList<>();
        Arrays.sort(answers);
        for (int answer : answers) {
            if(answer==0){
                result+=1;
                continue;
            }
            if(stack.isEmpty()){
                result+=(answer+1);
                stack.push(answer);
            }else if(stack.peek()==answer){
                stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        numRabbits(new int[]{0,0,0,1,1,1});
    }

}
