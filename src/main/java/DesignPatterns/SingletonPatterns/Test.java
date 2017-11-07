package DesignPatterns.SingletonPatterns;

/**
区别：饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快，线程安全
懒汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
 * Created by daiwei on 2017/11/7.
 */
public class Test {
    public static void main(String[] args) {
        //饿汉模式
        HungryPatterns s1= HungryPatterns.getInstance();
        HungryPatterns s2= HungryPatterns.getInstance();
        if(s1==s2){
            System.out.println("s1和s2是同一个实例");
        }else{
            System.out.println("s1和s2不是同一个实例");
        }

        //懒汉模式
        LazyPatterns s3=LazyPatterns.getInstance();
        LazyPatterns s4=LazyPatterns.getInstance();
        if(s3==s4){
            System.out.println("s3和s4是同一个实例");
        }else{
            System.out.println("S3和s4不是同一个实例");
        }

    }
}
