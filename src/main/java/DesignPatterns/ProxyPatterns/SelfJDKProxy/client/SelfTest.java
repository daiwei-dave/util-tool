package DesignPatterns.ProxyPatterns.SelfJDKProxy.client;

/**
 * @author daiwei
 * @date 2018/12/4 10:19
 */
public class SelfTest {
    public static void main(String[] args) {
        SelfJDKProxy proxy = new SelfJDKProxy(new SelfJDKProxyTarget());
        SelfProxyInterface proxyInterface = (SelfProxyInterface) proxy.instanceProxy();
        System.out.println(proxyInterface);
        proxyInterface.targetMethod();
    }

}
