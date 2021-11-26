package proxy.cglib;

import jdk.nashorn.internal.ir.CallNode;
import proxy.cglib.CglibTest;

public class CglibMain {

    public static void main(String[] args) {
        CglibTest cglibTest =(CglibTest) new CglibInterceptor().getInstance(CglibTest.class);
        cglibTest.doSomething();
    }
}
