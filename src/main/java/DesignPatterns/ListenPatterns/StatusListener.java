package DesignPatterns.ListenPatterns;

import java.util.EventListener;

/**
 * 监听器
 * <P>
 *     EventListener接口仅仅是一个标志性接口，内部没有做任何处理。所有逻辑都由使用者自己实现。
 * </P>
 * @author daiwei
 * @date 2018/8/20 14:14
 */
public interface StatusListener extends EventListener {
    void changeStatus(ChangeEvent event);
}
