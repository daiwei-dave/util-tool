package DesignPatterns.SingletonPatterns;

/*
 * 饿汉模式
 *在jvm加载的同时就进行实例化
 */
public class HungryPatterns {
    //1.将构造方法私有化，不允许外部直接创建对象
    private HungryPatterns(){
    }

    //2.创建类的唯一实例，使用private static修饰
    private static HungryPatterns instance=new HungryPatterns();

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static HungryPatterns getInstance(){
        return instance;
    }
}
