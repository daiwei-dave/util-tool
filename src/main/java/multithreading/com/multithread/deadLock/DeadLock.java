package multithreading.com.multithread.deadLock;

/**
 * @ sees https://www.cnblogs.com/liangstudyhome/p/4433205.html
 * @author daiwei
 * @date 2018/8/16 11:34
 */
public class DeadLock implements Runnable{

    A a = new A();
    B b = new B();

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
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}


class A {

    public synchronized void foo(B b) {
        System.out.println(Thread.currentThread().getName() + " 进入A的foo");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 试图调用B的last");
        b.last();
    }

    public synchronized void last() {
        System.out.println("A的last()");
    }
}

class B {

    public synchronized void bar(A a) {
        System.out.println(Thread.currentThread().getName() + " 进入B的bar");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 试图调用A的last");
        a.last();
    }

    public synchronized void last() {
        System.out.println("B的last()");
    }
}