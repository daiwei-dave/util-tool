package DesignPatterns.PrototypePatterns.theory;

/**
 * @author daiwei
 * @date 2018/11/16 14:23
 */
public interface Prototype {
    /**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
    public Prototype clone();
}
