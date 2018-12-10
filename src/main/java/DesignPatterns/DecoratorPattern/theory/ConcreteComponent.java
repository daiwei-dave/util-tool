package DesignPatterns.DecoratorPattern.theory;

import DesignPatterns.DecoratorPattern.theory.Component;

/**
 * 具体构件角色
 * @author daiwei
 * @date 2018/4/24 15:47
 */
public class ConcreteComponent implements Component {

    public void sampleOperation() {
        // 写相关的业务代码
        System.out.println("ConcreteComponent.sampleOperation method");
    }
}
