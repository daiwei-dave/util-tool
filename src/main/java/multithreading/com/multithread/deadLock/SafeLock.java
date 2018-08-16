package multithreading.com.multithread.deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己写的
 * <P>
 *     调用其他方法未获取到锁时，释放自己的锁
 * </P>
 * @author daiwei
 * @date 2018/8/16 11:34
 */
public class SafeLock implements Runnable{

    A1 a = new A1();
    B1 b = new B1();
    private Lock lock = new ReentrantLock();    //注意这个地方

    public void init() {
        Thread.currentThread().setName("主线程");
        System.out.println("进入主线程");
        a.foo(b);
    }

    public void run() {
        Thread.currentThread().setName("副线程");
        System.out.println("进入副线程");
        b.bar(a);
    }

    public static void main(String[] args) {
        SafeLock dl = new SafeLock();
        new Thread(dl).start();
        dl.init();
    }
}


class A1 {
    Lock lock = new ReentrantLock();    //注意这个地方
    public  void foo(B1 b) {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " 进入A的foo");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        while (true) {
            try {
                if (b.lock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + "得到了锁");
                    System.out.println(Thread.currentThread().getName() + " 试图调用B的last");
                    b.last();
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "未得到锁");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.State state = Thread.currentThread().getState();
     //           System.out.println("当前线程"+Thread.currentThread().getName()+"状态为"+state);
                try {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"释放了锁");
                } catch (Exception e) {

                }
            }
        }
    }


    public synchronized void last() {
        System.out.println("A1的last()");
    }
}

class B1 {
    Lock lock = new ReentrantLock();    //注意这个地方
    public  void bar(A1 a) {

        lock.lock();
        System.out.println(Thread.currentThread().getName() + " 进入B的bar");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        while (true){
            try {
                if (a.lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+"得到了锁");
                    System.out.println(Thread.currentThread().getName() + " 试图调用A的last");
                    a.last();
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+"未得到锁");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                Thread.State state = Thread.currentThread().getState();
 //               System.out.println("当前线程"+Thread.currentThread().getName()+"状态为"+state);
                try {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"释放了锁");
                } catch (Exception e) {

                }

            }
        }
    }

    public synchronized void last() {
        System.out.println("B1的last()");
    }
}