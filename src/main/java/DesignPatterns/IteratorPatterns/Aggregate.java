package DesignPatterns.IteratorPatterns;

/**
 * @author daiwei
 * @date 2018/12/5 14:26
 */
public abstract class Aggregate {
    /**
     * 工厂方法，创建相应迭代子对象的接口
     */
    public abstract Iterator createIterator();
}
