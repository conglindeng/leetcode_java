package leetcode.middle;

public class NumDecodings_91 {
    public static int size=0;

    public static int numDecodings(String s) {
        if (s == null || "".equals(s) || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1 && inRange(s)) {
            size++;
        }else{
            dfs(s);
        }
        return size;
    }

    public static void dfs(String c){
        if(c.length()==1){
            if(inRange(c))
                size++;
        }
        else if(c.length()==2){
            if(c.charAt(0)=='0'){
            }else{
                if(inRange(c)){
                    size++;
                }
                if(inRange(c.substring(0,1)) && inRange(c.substring(1,2))){
                    size++;
                }
            }
        }else{
            if("0".equals(c.substring(0,1))){
            }else{
                if(inRange(c.substring(0,2))){
                    dfs(c.substring(2));
                }
                if(inRange(c.substring(0,1))){
                    dfs(c.substring(1));
                }
            }
        }
    }

    public static boolean inRange(String s){
        Integer integer = Integer.valueOf(s);
        return integer<=26 && integer>=1;
    }
}
