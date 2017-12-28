package DesignPatterns.ObserverPatterns;

/**
 * 具体观察者(ConcreteObserver)角色
 * Created by daiwei on 2017/12/28.
 */
public class ConcreteObserver implements Observer{
    //观察者的状态
    private String observerState;
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为："+observerState);
    }

    public void update(Subject subject) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("观察者状态为："+observerState);
    }
}
