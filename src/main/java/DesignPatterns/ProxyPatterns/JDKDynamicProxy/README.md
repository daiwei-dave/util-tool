jdk动态代理


public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException{}
    
    
InvocationHandler h：h表示实现了InvocationHandler接口的类




@see http://blog.csdn.net/tjgykhulj/article/details/53522450#t0
@see 深度剖析JDK动态代理机制https://www.cnblogs.com/MOBIN/p/5597215.html（含源码分析）