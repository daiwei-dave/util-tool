package multithreading.com.multithread.wait;

/**
 * wait用法，常和notify一起使用。在同步块中会释放锁
 * Created by daiwei on 2017/7/27.
 * @seehttp://www.cnblogs.com/GarfieldEr007/p/5746362.html
 */
public class MyThreadPrinter2 implements Runnable{
    private String name;
    private Object prev;
    private Object self;

    private MyThreadPrinter2(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    public void run() {
        int count = 10;
        while (count > 0) {
            /**
             * 锁住prey，其他线程没锁将没法进入
             */
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    // synchronized (self)执行完后释放self锁
                    self.notify();
                }
                try {
                    //释放prev锁，并休眠
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
