package DesignPatterns.StrategyPatterns.Demo;

/**
 * 中级会员折扣类
 * Created by daiwei on 2017/3/15.
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
