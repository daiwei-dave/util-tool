package DesignPatterns.AdaperPatterns.DefaultAdapter;

import DesignPatterns.AdaperPatterns.DefaultAdapter.和尚;

/**
 * 适配器类
 * Created by daiwei on 2017/3/15.
 */
public abstract class 天星 implements 和尚 {
    public void 吃斋(){}
    public void 念经(){}
    public void 打坐(){}
    public void 撞钟(){}
    public void 习武(){}
    public String getName(){
        return "鲁智深";
    }

}
