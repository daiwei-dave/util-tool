package DesignPatterns.ProxyPatterns.cglib;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by daiwei on 2017/12/21.
 */
public class BookProxyLib implements MethodInterceptor {

    //要代理的原始对象
    private Object target;


    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置代理目标
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    // 回调方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始");
        //执行代理的方法
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return result;
    }
}
