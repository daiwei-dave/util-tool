package DesignPatterns.BridgePatterns.demo;

/**
 * @author daiwei
 * @date 2018/9/3 11:33
 */
public class MessageSMS implements MessageImplementor {

    public void send(String message, String toUser) {

        System.out.println("使用系统内短消息的方法，发送消息'"+message+"'给"+toUser);
    }
}
