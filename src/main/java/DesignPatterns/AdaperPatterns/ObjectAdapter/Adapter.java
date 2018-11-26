package DesignPatterns.AdaperPatterns.ObjectAdapter;

import DesignPatterns.AdaperPatterns.common.Adaptee;
import DesignPatterns.AdaperPatterns.common.Target;

/**
 * Adapter适配器
 * Created by daiwei on 2017/3/15.
 */
public class Adapter extends Adaptee implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    @Override
    public void sampleOperation1(){
        this.adaptee.sampleOperation1();
    }
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
