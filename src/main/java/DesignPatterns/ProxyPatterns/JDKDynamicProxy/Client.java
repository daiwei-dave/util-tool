package DesignPatterns.ProxyPatterns.JDKDynamicProxy;

/**
 * Created by daiwei on 2018/1/31.
 */
public class Client {
    public static void main(String[] args) {
        MyProxy proxy = new MyProxy();
        Base targetObject = (Base) proxy.bind(new TargetObject());
        targetObject.print();
        targetObject.sing();
    }
}
