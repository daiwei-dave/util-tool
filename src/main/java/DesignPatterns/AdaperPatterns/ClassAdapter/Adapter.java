package DesignPatterns.AdaperPatterns.ClassAdapter;

import DesignPatterns.AdaperPatterns.common.Adaptee;
import DesignPatterns.AdaperPatterns.common.Target;

/**
 * Adapter适配器
 * Created by daiwei on 2017/3/15.
 */
public class Adapter extends Adaptee implements Target {

    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //写相关的代码
        System.out.println("sampleOperation2");
    }

}
