package DesignPatterns.AdaperPatterns;

/**
 * Created by daiwei on 2017/3/15.
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();
    /**
     * 这是源类Adaptee没有的方法
     */
    public void sampleOperation2();
}
