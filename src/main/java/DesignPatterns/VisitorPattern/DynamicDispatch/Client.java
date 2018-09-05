package DesignPatterns.VisitorPattern.DynamicDispatch;

/**
 * 动态分派(Dynamic Dispatch)发生在运行时期，动态分派动态地置换掉某个方法。
 * @author daiwei
 * @date 2018/9/5 16:34
 */
public class Client {
    public static void main(String[] args) {
        Horse h = new BlackHorse();
        h.eat();
    }
}
