package DesignPatterns.TemplatePatterns.theory.demo;

/**
 * @author daiwei
 * @date 2018/8/21 15:12
 */
public class MoneyMarketAccount extends Account{
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}
