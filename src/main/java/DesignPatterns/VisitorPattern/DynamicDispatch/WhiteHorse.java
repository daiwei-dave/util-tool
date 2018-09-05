package DesignPatterns.VisitorPattern.DynamicDispatch;

/**
 * @author daiwei
 * @date 2018/9/5 16:35
 */
public class WhiteHorse extends Horse{
    @Override
    public void eat() {
        System.out.println("黑马吃草");
    }
}
