package DesignPatterns.DecoratorPattern.Demo;

/**
 * @author daiwei
 * @date 2018/4/25 11:26
 */
public class Bird extends Change{
    public Bird(TheGreatestSage sage) {
        super(sage);
    }


    @Override
    public void move() {
        // 代码
        System.out.println("Bird Move");
    }



}
