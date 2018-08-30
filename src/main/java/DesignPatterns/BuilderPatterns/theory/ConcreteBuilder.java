package DesignPatterns.BuilderPatterns.theory;

/**
 * @author daiwei
 * @date 2018/8/30 14:39
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();
    public void buildPart1() {
        //构建产品的第一个零件
       product.setPart1("编号：9527");
    }

    public void buildPart2() {
        //构建产品的第二个零件
        product.setPart2("名称：XXX");
    }

    public Product retrieveResult() {
        return product;
    }
}
