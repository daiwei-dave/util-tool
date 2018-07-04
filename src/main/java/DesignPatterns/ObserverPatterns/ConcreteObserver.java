package DesignPatterns.ObserverPatterns;

/**
 * 具体观察者(ConcreteObserver)角色
 * Created by daiwei on 2017/12/28.
 */
public class ConcreteObserver implements Observer{
    //观察者的状态
    private String observerState;

    /**
     * 推模型:主题对象向观察者推送主题的详细信息，不管观察者是否需要
     * @param state    更新的状态
     */
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("观察者接受的状态为："+observerState);
    }


    /**
     * 拉模型
     * <P>
     *     主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，
     *     由观察者主动到主题对象中获取，相当于是观察者从主题对象中拉数据
     * </P>
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    public void update(Subject subject) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("收到发送者的状态为"+observerState);
        System.out.println("更新观察者状态为："+observerState);
    }
}
