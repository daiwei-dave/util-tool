package DesignPatterns.TemplatePatterns;

/**
 * Created by daiwei on 2017/3/15.
 */
public class Coffee extends Beverage{

    public void addCoundiments() {
        System.out.println("添加糖和牛奶");   }

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
