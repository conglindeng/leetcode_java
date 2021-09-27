package newcode;

import java.util.Deque;
import java.util.LinkedList;

public class NC89_Trans {
    public String trans(String s, int n) {
        // write code here
        Deque<String> work=new LinkedList<>();
        char[] chars = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[i];
            if(aChar ==' '){
                if(i==n-1){
                    work.push(sb.toString());
                    sb=new StringBuilder();
                    sb.append(" ");
                }else{
                    work.push(sb.toString());
                    sb=new StringBuilder();
                }
            }else{
                if(aChar>='A'&&aChar<='Z'){
                    sb.append((char)(aChar+32));
                }else{
                    sb.append((char)(aChar-32));
                }
            }
        }
        if(!" ".equals(sb.toString())&&sb.length()>0){
            sb.append(" ");
        }
        while(!work.isEmpty()){
            sb.append(work.poll());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
