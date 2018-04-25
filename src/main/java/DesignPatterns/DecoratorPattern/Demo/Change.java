package DesignPatterns.DecoratorPattern.Demo;

/**
 * @author daiwei
 * @date 2018/4/25 11:23
 */
public class Change implements TheGreatestSage {
    private TheGreatestSage sage;

    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
    public void move() {
        // 代码
        sage.move();
    }
}
