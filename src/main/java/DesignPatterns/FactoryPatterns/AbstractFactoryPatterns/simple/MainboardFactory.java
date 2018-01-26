package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.simple;

import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Mainboard;

/**
 * Created by daiwei on 2018/1/26.
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type){
        Mainboard mainboard = null;
        if(type == 1){
            mainboard = new IntelMainboard(755);
        }else if(type == 2){
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
