package DesignPatterns.ProxyPatterns.theory;

/**
 * 目标对象角色
 * Created by daiwei on 2017/12/20.
 */
public class RealObject extends AbstractObject{
    public void operation() {
        //一些操作
        System.out.println("一些操作");
    }
}
