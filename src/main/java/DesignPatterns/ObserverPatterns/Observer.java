package DesignPatterns.ObserverPatterns;

import java.util.Observable;

/**
 * 抽象观察者(Observer)角色
 * <P>
 *     为所有的具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫做更新接口。
 * </P>
 * Created by daiwei on 2017/12/28.
 */
public interface Observer {

    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);


    /**
     * 更新接口
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    public void update(Subject subject);

}
