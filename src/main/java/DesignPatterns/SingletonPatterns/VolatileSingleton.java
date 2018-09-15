package DesignPatterns.SingletonPatterns;

/**
 * 双重检查加锁方式可以有些提高懒汉式的多线程性能问题
 * @sees https://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
 * @author daiwei
 * @date 2018/9/15 16:52
 */
public class VolatileSingleton {
    private volatile static VolatileSingleton instance = null;
    private VolatileSingleton(){}
    public static VolatileSingleton getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(instance == null){
            //同步块，线程安全的创建实例
            synchronized (VolatileSingleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(instance == null){
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        VolatileSingleton instance = VolatileSingleton.getInstance();
        System.out.println(instance);
        VolatileSingleton instance2 = VolatileSingleton.getInstance();
        System.out.println(instance2);
    }


}
