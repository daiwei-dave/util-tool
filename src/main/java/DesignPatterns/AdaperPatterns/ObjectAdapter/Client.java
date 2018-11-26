package DesignPatterns.AdaperPatterns.ObjectAdapter;

import DesignPatterns.AdaperPatterns.ObjectAdapter.Adapter;
import DesignPatterns.AdaperPatterns.common.Adaptee;

/**
 * 对象适配器
 * @author daiwei
 * @date 2018/8/21 16:56
 */
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee=new Adaptee();
        Adapter adapter=new Adapter(adaptee);
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
