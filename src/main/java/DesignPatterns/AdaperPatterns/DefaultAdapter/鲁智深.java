package DesignPatterns.AdaperPatterns.DefaultAdapter;

import DesignPatterns.AdaperPatterns.DefaultAdapter.天星;

/**
 * 实现了接口但不实现接口中的所有方法
 * Created by daiwei on 2017/3/15.
 */
public class 鲁智深 extends 天星 {
    public void 习武(){
        System.out.println("拳打镇关西; 大闹五台山; 大闹桃花村; 火烧瓦官寺; 倒拔垂杨柳;");

    }
    public String getName(){
        return "鲁智深";
    }
}
