package DesignPatterns.DelegatePatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * //委派者
 * @author daiwei
 * @date 2018/8/28 10:58
 */
public class Leader {
    private Map<String,ITarget> targets = new HashMap<String,ITarget>();

    //在这里根据策略委派任务
    public Leader() {
        dispatch();
    }

    private void dispatch() {
        targets.put("加密",new TargetA());
        targets.put("登录",new TargetB());
    }

    //项目经理自己不干活
    public void doing(String command){
        targets.get(command).doing(command);
    }
}



