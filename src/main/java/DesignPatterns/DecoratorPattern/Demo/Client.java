package DesignPatterns.DecoratorPattern.Demo;

/**
 * @author daiwei
 * @date 2018/4/25 11:28
 */
public class Client {
    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
        //没有包装
        sage.move();
//        // 第一种写法
//        TheGreatestSage bird = new Bird(sage);
//        //包装成鸟
//        bird.move();
//        TheGreatestSage fish = new Fish(bird);
//        //包装成鱼
//        fish.move();
        // 第二种写法

        TheGreatestSage fish = new Fish(new Bird(sage));
        fish.move();

    }
}
