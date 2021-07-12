package util;

import java.util.Map;

public class StringUtils {
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder res=new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }


    public static String replace(String s, Map<String,String> param){
        char[] chars = s.toCharArray();
        StringBuilder res=new StringBuilder();
        res.append(chars[0]);
        int length = chars.length;
        for(int i = 1; i< length; i++){

            // todo:可用堆栈，若为空格则不压入
            if(chars[i]=='{'&&chars[i-1]=='{'){
                //说明找到了一个待替换的起点
                //先删除掉前一个'{'
                res.deleteCharAt(res.length()-1);
                StringBuilder key=new StringBuilder();
                while(i< length){
                    i++;
                    //中间有个空格的话，这种做法不正确
                    if(chars[i]==' '){
                        continue;
                    }
                    if(chars[i]=='}'&&chars[i-1]=='}'){
                        key.deleteCharAt(key.length()-1);
                        break;
                    }
                    key.append(chars[i]);
                }
                res.append(param.get(key.toString()));
            }else{
                res.append(chars[i]);
            }
        }
        return res.toString();
    }

}
