package DesignPatterns.ProxyPatterns.SelfJDKProxy;

import java.lang.reflect.Method;

/**
 * @author daiwei
 * @date 2018/12/4 10:14
 */
public interface SelfInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args);
}
