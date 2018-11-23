package DesignPatterns.PrototypePatterns.register;

import DesignPatterns.PrototypePatterns.register.*;

/**
 * @author daiwei
 * @date 2018/11/16 14:24
 */
public class ConcretePrototype1 implements Prototype {
    private String name;
    @Override
    public Prototype  clone(){
        ConcretePrototype1 prototype = new ConcretePrototype1();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
