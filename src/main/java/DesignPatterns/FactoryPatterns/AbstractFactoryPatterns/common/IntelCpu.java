package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common;

import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Cpu;

/**
 * Created by daiwei on 2018/1/26.
 */
public class IntelCpu implements Cpu{

    /**
     * CPU的针脚数
     */
    private int pins = 0;
    public  IntelCpu(int pins){
        this.pins = pins;
    }
    public void calculate() {
        System.out.println("Intel CPU的针脚数：" + pins);
    }
}
