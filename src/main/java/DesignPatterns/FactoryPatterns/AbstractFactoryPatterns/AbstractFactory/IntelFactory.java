package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.AbstractFactory;

import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.AbstractFactory.Factory;
import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Cpu;
import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.IntelCpu;
import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Mainboard;
import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.simple.IntelMainboard;

/**
 * Created by daiwei on 2018/1/26.
 */
public class IntelFactory implements Factory {
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}
