package DesignPatterns.BuilderPatterns.theory;

/**
 * @author daiwei
 * @date 2018/8/30 14:38
 */
public interface Builder {
    public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}
