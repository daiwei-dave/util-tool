package DesignPatterns.SingletonPatterns;

import java.lang.reflect.Constructor;


/**
 * 利用反射打破单例
 * @sees https://blog.csdn.net/bjweimengshu/article/details/78716839
 * @author daiwei
 * @date 2018/9/15 19:20
 */
public class Singleton {


    //1.将构造方法私有化，不允许外部直接创建对象
    private Singleton(){
    }

    //2.创建类的唯一实例，使用private static修饰
    private static Singleton instance=new Singleton();

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static Singleton getInstance(){
        return instance;
    }


    public static void main(String[] args) throws Exception {
        //获得构造器
        Constructor con = Singleton.class.getDeclaredConstructor();
//设置为可访问
        con.setAccessible(true);
//构造两个不同的对象
        Singleton singleton1 = (Singleton)con.newInstance();
        System.out.println(singleton1);
        Singleton singleton2 = (Singleton)con.newInstance();
        System.out.println(singleton2);
//验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));




    }
}


