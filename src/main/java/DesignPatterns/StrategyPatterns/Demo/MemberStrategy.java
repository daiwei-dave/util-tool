package DesignPatterns.StrategyPatterns.Demo;

/**
 * 抽象折扣类
 * Created by daiwei on 2017/3/15.
 */
public interface MemberStrategy {
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);

}
