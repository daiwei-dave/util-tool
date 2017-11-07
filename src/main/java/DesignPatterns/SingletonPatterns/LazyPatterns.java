package DesignPatterns.SingletonPatterns;

/*
 * 懒汉模式
 * 动态绑定，在jvm加载完后，在使用时进行实例化
 */
public class LazyPatterns {
    //1.将构造方式私有化，不允许外边直接创建对象
    private LazyPatterns(){
    }

    //2.声明类的唯一实例，使用private static修饰
    private static LazyPatterns instance;

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static LazyPatterns getInstance(){
        if(instance==null){
            instance=new LazyPatterns();
        }
        return instance;
    }
}
