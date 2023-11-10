package jvmtest;


import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class AllotOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
       byte[] test=new byte[64];
//        User user = new User();
//        user.setId(1);
//        user.setName("blueStarWei");
    }


    private void getClassLocation(){
        //        Class clz= StringUtils.class;
        Class clz= String.class;
        ProtectionDomain protectionDomain =clz.getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();
        if (codeSource== null) {
            System.out.println(clz.getSimpleName()+"是系统类，无法获取CodeSource对象");
            return;
        }
        URL location = codeSource.getLocation();
        System.out.println(location);
    }
}