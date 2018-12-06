package DesignPatterns.CommandPatterns.theory;

import DesignPatterns.CommandPatterns.theory.Command;

/**
 * @author daiwei
 * @date 2018/12/6 15:42
 */
public class Invoker {
    /**
     * 持有命令对象
     */
    private Command command = null;
    /**
     * 构造方法
     */
    public Invoker(Command command){
        this.command = command;
    }
    /**
     * 行动方法
     */
    public void action(){

        command.execute();
    }
}
