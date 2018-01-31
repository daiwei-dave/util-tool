jdk动态代理


public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException{}
    
    
InvocationHandler h：h表示实现了InvocationHandler接口的类




@see http://blog.csdn.net/tjgykhulj/article/details/53522450#t0
@see https://www.cnblogs.com/MOBIN/p/5597215.html