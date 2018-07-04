package DesignPatterns.ObserverPatterns.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者：相当于消息消费者
 * Created by daiwei on 2017/12/28.
 */
public class Watcher implements Observer {

    public Watcher(Observable o){
        o.addObserver(this);
    }
    public void update(Observable o, Object arg) {
        System.out.println("状态发生改变：" + ((Watched)o).getData());
    }
}
