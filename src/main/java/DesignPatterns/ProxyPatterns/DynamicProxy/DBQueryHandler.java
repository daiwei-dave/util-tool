package DesignPatterns.ProxyPatterns.DynamicProxy;

import DesignPatterns.ProxyPatterns.DBQuery;
import DesignPatterns.ProxyPatterns.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daiwei on 2017/3/31.
 */
public class DBQueryHandler implements InvocationHandler{
    IDBQuery realQuery = null;//定义主题接口

    /**
     *
     * @param proxy  在其上调用方法的代理实例
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果第一次调用，生成真实主题
        if(realQuery == null){
            realQuery = new DBQuery();
        }
        //返回真实主题完成实际的操作
        return realQuery.request();
    }

    public static IDBQuery createProxy(){
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new DBQueryHandler()
        );
        return proxy;
    }

    public static void main(String[] args) {
        System.out.println(createProxy().request());
    }
}
