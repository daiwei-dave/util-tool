package multithreading.com.multithread.lock.readWriteLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daiwei
 * @date 2018/8/1 17:18
 */
public class ReentrantReadWriteLockTest1 {


    public static void main(String[] args)  {
        final ReentrantReadWriteLockTest1 test = new ReentrantReadWriteLockTest1();



        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
    }



    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 10) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }
}
