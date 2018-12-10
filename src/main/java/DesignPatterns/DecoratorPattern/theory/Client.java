package DesignPatterns.DecoratorPattern.theory;

/**
 * @author daiwei
 * @date 2018/12/10 17:40
 */
public class Client {
    public static void main(String[] args) {
        Component component=new ConcreteComponent();
        component.sampleOperation();

        System.out.println("-----------------");
        component=new ConcreteDecoratorA(component);
        component.sampleOperation();

        System.out.println("-----------------");
        component=new ConcreteDecoratorB(component);
        component.sampleOperation();
    }
}
