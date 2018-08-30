package DesignPatterns.BuilderPatterns.theory;

/**
 * @author daiwei
 * @date 2018/8/30 14:42
 */
public class Client {
    public static void main(String[]args){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
