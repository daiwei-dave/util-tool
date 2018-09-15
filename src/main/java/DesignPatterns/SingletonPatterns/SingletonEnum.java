package DesignPatterns.SingletonPatterns;

import java.lang.reflect.Constructor;

/**
 * 用枚举实现单例模式：
 * @sees https://blog.csdn.net/bjweimengshu/article/details/78716839
 * @author daiwei
 * @date 2018/9/15 19:23
 */
public enum  SingletonEnum {
    /**
     * 定义一个枚举的元素，它就代表了SingletonEnum的一个实例。
     */

    uniqueInstance;



    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation(){
        //功能处理
    }


    public static void main(String[] args) throws Exception{
        //获得构造器
        Constructor con = SingletonEnum.class.getDeclaredConstructor();
//设置为可访问
        con.setAccessible(true);
//构造两个不同的对象
        SingletonEnum singleton1 = (SingletonEnum)con.newInstance();
        System.out.println(singleton1);
        SingletonEnum singleton2 = (SingletonEnum)con.newInstance();
        System.out.println(singleton2);
//验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));
    }
}
