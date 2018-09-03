package DesignPatterns.BridgePatterns.theory;

/**
 * @author daiwei
 * @date 2018/9/3 11:15
 */
public class ConcreteImplementorB extends Implementor{
    public void operationImpl() {
        //具体操作
        System.out.println("ConcreteImplementorB.operationImpl");
    }
}
