package DesignPatterns.TemplatePatterns.theory.demo;

/**
 * @author daiwei
 * @date 2018/8/21 15:13
 */
public class Client {
    public static void main(String[] args) {
        Account account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());
    }
}
