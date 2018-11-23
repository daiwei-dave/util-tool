package DesignPatterns.PrototypePatterns.register;



/**
 * @author daiwei
 * @date 2018/11/16 14:26
 */
public class ConcretePrototype2 implements Prototype{
    private String name;
    @Override
    public Prototype  clone() {
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }


    @Override
    public String toString() {
        return "ConcretePrototype2{" +
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
