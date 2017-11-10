package DesignPatterns.TemplatePatterns;

/**
 * Created by daiwei on 2017/3/15.
 */
public class Tea extends Beverage{

    @Override
    public void addCoundiments() {
        System.out.println("添加蜂蜜");
    }

    @Override
    public void brew() {
        System.out.println("用水冲茶");
    }
}
