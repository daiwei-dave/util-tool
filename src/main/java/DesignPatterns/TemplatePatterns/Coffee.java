package DesignPatterns.TemplatePatterns;

/**
 * 制作咖啡
 * Created by daiwei on 2017/3/15.
 */
public class Coffee extends Beverage{

    @Override
    public void addCoundiments() {
        System.out.println("添加糖和牛奶");   }

    @Override
    public void brew() {
        System.out.println("用水冲咖啡");
    }

    /**
     * 挂钩
     */
    @Override
    public void hook() {
        System.out.println("再来一杯");
    }

}
