package proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    public Object getInstance(Class clazz){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\code");
        Enhancer enhancer=new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(clazz);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("切入前");
        methodProxy.invokeSuper(o,args);
        System.out.println("切入后");
        return null;
    }
}
