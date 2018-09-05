package DesignPatterns.VisitorPattern.StaticDispatch;

import DesignPatterns.VisitorPattern.DynamicDispatch.BlackHorse;
import DesignPatterns.VisitorPattern.DynamicDispatch.Horse;
import DesignPatterns.VisitorPattern.DynamicDispatch.WhiteHorse;

/**
 * 静态分派(Static Dispatch)发生在编译时期，分派根据静态类型信息发生。静态分派对于我们来说并不陌生，方法重载就是静态分派。
 * @author daiwei
 * @date 2018/9/5 16:32
 */
public class Mozi {
    public void ride(Horse h){
        System.out.println("骑马");
    }

    public void ride(WhiteHorse wh){
        System.out.println("骑白马");
    }

    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }


    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
    }

}
