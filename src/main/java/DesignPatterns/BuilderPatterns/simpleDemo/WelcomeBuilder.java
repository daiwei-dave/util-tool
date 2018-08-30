package DesignPatterns.BuilderPatterns.simpleDemo;

/**
 * @author daiwei
 * @date 2018/8/30 15:04
 */
public class WelcomeBuilder extends Builder {


    public WelcomeBuilder(){
        msg = new WelcomeMessage();
    }
    public void buildSubject() {
        msg.setSubject("欢迎标题");
    }

    public void buildBody() {
        msg.setBody("欢迎内容");
    }
}
