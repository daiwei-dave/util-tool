package multithreading.concurrent.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @sees https://www.cnblogs.com/dolphin0520/p/3933551.html
 * @author daiwei
 * @date 2018/10/29 13:46
 */
public class Test {
    public static void main(String[] args) {
            test01();
   //     test02();
    }


    /**
     * 会出现ConcurrentModificationException异常
     */
    public static void test01(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }



    /**
     * 会出现ConcurrentModificationException异常
     */
    public static void test02(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.add(3);
        }
    }

    /**
     * 正确的方式
     */
    public static void test03(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                iterator.remove();   //注意这个地方
        }
    }


    /**
     * 在多线程环境下可能会出现问题
     */
    public static void test04(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    System.out.println(integer);
                    iterator.remove();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        Thread thread2 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(integer==2)
                        iterator.remove();
                }
            };
        };
        thread1.start();
        thread2.start();

    }










}
