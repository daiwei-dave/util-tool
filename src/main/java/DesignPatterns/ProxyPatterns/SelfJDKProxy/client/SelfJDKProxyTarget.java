package DesignPatterns.ProxyPatterns.SelfJDKProxy.client;

import DesignPatterns.ProxyPatterns.SelfJDKProxy.client.SelfProxyInterface;

/**
 * @author daiwei
 * @date 2018/12/4 10:07
 */
public class SelfJDKProxyTarget implements SelfProxyInterface {
    @Override
    public void targetMethod() {
        System.out.println("代理方法...");
    }
}
