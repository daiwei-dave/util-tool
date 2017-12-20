package DesignPatterns.ProxyPatterns.LazyLoading.theory;

/**
 * Created by daiwei on 2017/12/20.
 */
public class Client {
    public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }

}
