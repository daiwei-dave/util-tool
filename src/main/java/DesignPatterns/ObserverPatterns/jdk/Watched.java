package DesignPatterns.ObserverPatterns.jdk;

import java.util.Observable;

/**
 * 被观察者:相当于消息生产者
 * Created by daiwei on 2017/12/28.
 */
public class Watched extends Observable{
    private String data = "";
    public String getData() {
        return data;
    }

    public void setData(String data) {

        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

}
