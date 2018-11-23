package DesignPatterns.PrototypePatterns.theory;

/**
 * @author daiwei
 * @date 2018/11/16 15:54
 */
public class Client {
    /**
     * 持有需要使用的原型接口对象
     */
    private Prototype prototype;
    /**
     * 构造方法，传入需要使用的原型接口对象
     */
    public Client(Prototype prototype){
        this.prototype = prototype;
    }
    public void operation(Prototype example){
        //需要创建原型接口的对象
        Prototype copyPrototype = prototype.clone();

    }


}
