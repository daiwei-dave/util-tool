package DesignPatterns.BridgePatterns.demo;

/**
 * @author daiwei
 * @date 2018/9/3 11:34
 */
public class MessageEmail implements MessageImplementor{
    public void send(String message, String toUser) {
        System.out.println("使用邮件短消息的方法，发送消息'"+message+"'给"+toUser);
    }
}
