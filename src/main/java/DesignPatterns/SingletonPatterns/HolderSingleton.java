package DesignPatterns.SingletonPatterns;

/**
 * @author daiwei
 * @date 2018/9/15 18:43
 */
public class HolderSingleton {
    private HolderSingleton(){}
    /**
     *    类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *    只有被调用到时才会装载不会随着外部类装载而装载，从而实现了延迟加载。
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance(){
        return SingletonHolder.instance;
    }


    public static void main(String[] args) {
        HolderSingleton instance = HolderSingleton.getInstance();
        System.out.println(instance);
        HolderSingleton instance2 = HolderSingleton.getInstance();
        System.out.println(instance2);
    }
}
