package DesignPatterns.DecoratorPattern.theory;

/**
 * @author daiwei
 * @date 2018/12/10 17:38
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 写相关的业务代码
        System.out.println("ConcreteDecoratorA.sampleOperation");
    }
}
