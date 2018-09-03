package DesignPatterns.BridgePatterns.theory;

/**
 * @author daiwei
 * @date 2018/9/3 10:25
 */
public abstract class Abstraction {
    protected Implementor impl;

    public Abstraction(Implementor impl){
        this.impl = impl;
    }
    //示例方法
    public void operation(){

        impl.operationImpl();
    }
}
