package DesignPatterns.ListenPatterns;

import java.util.EventObject;

/**
 * 事件
 * @author daiwei
 * @date 2018/8/20 14:10
 */
public class ChangeEvent extends EventObject{


    private String status;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ChangeEvent(Object source) {
        super(source);
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
