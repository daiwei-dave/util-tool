package DesignPatterns.ProxyPatterns.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daiwei on 2017/12/27.
 */
public class MyProxy implements InvocationHandler{

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        try {
            return method.invoke(target, args);
        } finally {
            System.out.println("end");
        }
    }
    public static void main(String[] args) {
        MyProxy proxy = new MyProxy();
        Base targetObject = (Base) proxy.bind(new TargetObject());
        targetObject.print();
    }

}
