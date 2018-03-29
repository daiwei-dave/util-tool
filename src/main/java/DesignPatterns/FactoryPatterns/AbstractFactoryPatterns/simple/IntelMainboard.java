package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.simple;

import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Mainboard;

/**
 * Created by daiwei on 2018/1/26.
 */
public class IntelMainboard implements Mainboard{
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;
    /**
     * 构造方法，传入CPU插槽的孔数
     * @param cpuHoles
     */
    public IntelMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}