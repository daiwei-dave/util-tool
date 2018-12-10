package DesignPatterns.DecoratorPattern.theory;

/**
 * @author daiwei
 * @date 2018/12/10 17:39
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 写相关的业务代码
        System.out.println("ConcreteDecoratorB do nothing");
    }
}
