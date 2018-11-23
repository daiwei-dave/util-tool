package DesignPatterns.PrototypePatterns.register;

/**
 * @author daiwei
 * @date 2018/11/16 15:58
 */
public interface Prototype {
    public Prototype clone();
    public String getName();
    public void setName(String name);
}
