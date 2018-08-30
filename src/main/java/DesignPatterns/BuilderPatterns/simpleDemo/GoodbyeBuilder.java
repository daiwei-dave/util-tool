package DesignPatterns.BuilderPatterns.simpleDemo;

/**
 * @author daiwei
 * @date 2018/8/30 15:06
 */
public class GoodbyeBuilder extends Builder {
    public GoodbyeBuilder() {
        msg = new GoodbyeMessage();
    }

    @Override
    public void buildBody() {
        // TODO Auto-generated method stub
        msg.setBody("欢送内容");
    }

    @Override
    public void buildSubject() {
        // TODO Auto-generated method stub
        msg.setSubject("欢送标题");
    }
}
