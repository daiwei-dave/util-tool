package DesignPatterns.BridgePatterns.theory;



/**
 * @author daiwei
 * @date 2018/9/3 11:35
 */
public class Client {
    public static void main(String[] args) {
        //创建具体的实现对象
        Implementor impl = new ConcreteImplementorA();

        Abstraction message = new RefinedAbstraction(impl);
        message.operation();

        //将实现方式切换
        impl = new ConcreteImplementorB();
        message = new RefinedAbstraction(impl);
        message.operation();

    }
}
