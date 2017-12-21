package DesignPatterns.ProxyPatterns.theory;

/**
 * 代理对象角色
 * Created by daiwei on 2017/12/20.
 */
public class ProxyObject extends AbstractObject{
    RealObject realObject = new RealObject();
    public void operation() {
        //调用目标对象之前可以做相关操作
        System.out.println("before");
        realObject.operation();
        //调用目标对象之后可以做相关操作
        System.out.println("after");
    }
}
