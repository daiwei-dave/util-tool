package DesignPatterns.ObserverPatterns.jdk;

import java.util.Observable;
import java.util.Observer;

/**
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
