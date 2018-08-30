package DesignPatterns.BuilderPatterns.simpleDemo;

/**
 * @author daiwei
 * @date 2018/8/30 15:10
 */
public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");

    }
}
