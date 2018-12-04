package DesignPatterns.ProxyPatterns.SelfJDKProxy.client;

import DesignPatterns.ProxyPatterns.SelfJDKProxy.SelfClassLoader;
import DesignPatterns.ProxyPatterns.SelfJDKProxy.SelfInvocationHandler;
import DesignPatterns.ProxyPatterns.SelfJDKProxy.SelfProxy;


import java.lang.reflect.Method;

/**
 * @author daiwei
 * @date 2018/12/4 10:16
 */
public class SelfJDKProxy implements SelfInvocationHandler {

    private SelfProxyInterface proxyInterface;

    public SelfJDKProxy(SelfProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public Object instanceProxy() {
        System.out.println("代理方法开始...");
        SelfProxyInterface instance = (SelfProxyInterface) SelfProxy.newInstance(
                new SelfClassLoader(),
                proxyInterface.getClass().getInterfaces(), this);
        return instance;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            method.invoke(proxyInterface, args);
            System.out.println("代理方法结束...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
