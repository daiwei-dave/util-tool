package DesignPatterns.DecoratorPattern.theory;

import DesignPatterns.DecoratorPattern.theory.Component;

/**
 * 装饰角色
 * @author daiwei
 * @date 2018/4/24 15:52
 */
public class Decorator implements Component {
    private Component component;



    public Decorator(Component component){
        this.component = component;
    }


    public void sampleOperation() {
        // 委派给构件
        component.sampleOperation();
    }
}
