package DesignPatterns.ObserverPatterns;

/**
 * 具体主题角色
 * Created by daiwei on 2017/12/28.
 */
public class ConcreteSubject extends Subject{
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}