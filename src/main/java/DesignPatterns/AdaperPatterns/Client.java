package DesignPatterns.AdaperPatterns;

/**
 * @author daiwei
 * @date 2018/8/21 16:56
 */
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee=new Adaptee();
        Adapter adapter=new Adapter((adaptee));
        adapter.sampleOperation1();
    }
}
