package DesignPatterns.VisitorPattern.DynamicDispatch;

/**
 * @author daiwei
 * @date 2018/9/5 16:33
 */
public class BlackHorse extends Horse{
    @Override
    public void eat() {
        System.out.println("黑马吃草");
    }
}
