package DesignPatterns.DecoratorPattern.Demo;

/**
 * @author daiwei
 * @date 2018/4/25 11:25
 */
public class Fish extends Change {
    public Fish(TheGreatestSage sage) {
        super(sage);
    }

//    @Override
//    public void move() {
//        // 代码
//        System.out.println("Fish Move");
//    }
}
