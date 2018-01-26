package DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.AbstractFactory;

import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Cpu;
import DesignPatterns.FactoryPatterns.AbstractFactoryPatterns.common.Mainboard;

/**
 * 抽象工厂类
 * Created by daiwei on 2018/1/24.
 */
public interface Factory {
    /**
     * 创建CPU对象
     * @return CPU对象
     */
   Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    Mainboard createMainboard();
}
