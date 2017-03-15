package DesignPatterns.TemplatePatterns;

/**
 * 1>创建一个模板(抽象)类：Beverage(饮料)
 * Created by daiwei on 2017/3/15.
 */
public abstract class Beverage {
    /**
     * 冲泡咖啡或茶...流程
     * 存在一个空实现的方法，我们称这种方法为”hook”。子类可以视情况来决定是否要覆盖它。
     */
    public final void create() {
        boilWater();//把水煮沸
        brew();//用沸水冲泡...
        pourInCup();//把...倒进杯子
        addCoundiments(); //加...
        hook();//挂钩
    }
    //空实现方法
    public void hook(){}
    public abstract void addCoundiments();

    public abstract void brew();

    public void boilWater() {
        System.out.println("煮开水");
    }

    public void pourInCup() {
        System.out.println("倒进杯子");
    }
}

