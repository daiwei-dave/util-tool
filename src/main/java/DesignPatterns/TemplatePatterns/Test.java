package DesignPatterns.TemplatePatterns;

/**
 * Created by daiwei on 2017/3/15.
 */
public class Test {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.create();//冲泡咖啡
        System.out.println("-----------------------");
        Tea tea = new Tea();//冲泡茶
        tea.create();
    }
}
