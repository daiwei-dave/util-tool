package DesignPatterns.CommandPatterns.theory;

/**
 * @author daiwei
 * @date 2018/12/6 15:40
 */
public class Receiver {
    /**
     * 真正执行命令相应的操作
     */
    public void action(){
        System.out.println("执行操作");
    }
}
