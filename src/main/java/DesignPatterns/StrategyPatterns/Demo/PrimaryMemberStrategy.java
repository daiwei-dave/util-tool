package DesignPatterns.StrategyPatterns.Demo;

/**
 * 初级会员折扣类
 * Created by daiwei on 2017/3/15.
 */
public class PrimaryMemberStrategy implements MemberStrategy{

    public double calcPrice(double booksPrice) {
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }
}
