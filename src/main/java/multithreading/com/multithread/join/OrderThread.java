package multithreading.com.multithread.join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 按子线程顺序执行demo
 * @sees https://blog.csdn.net/qq_35130231/article/details/79287717
 * @author daiwei
 * @date 2018/12/12 16:12
 */
public class OrderThread {


    static Thread t1 = new Thread(new Runnable() {
        public void run() {
            System.out.println("currentThread:"+Thread.currentThread().getName());
            System.out.println("Thread1");
        }
    });
    static Thread t2 = new Thread(new Runnable() {
        public void run() {
            System.out.println("currentThread:"+Thread.currentThread().getName());
            System.out.println("Thread2");
        }
    });
    static Thread t3 = new Thread(new Runnable() {
        public void run() {
            System.out.println("currentThread:"+Thread.currentThread().getName());
            System.out.println("Thread3");
        }
    });

    static ExecutorService es = Executors.newSingleThreadExecutor();







    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();




        es.submit(t1);
        es.submit(t2);
        es.submit(t3);
        es.shutdown();

    //    Thread.sleep(3000);
        System.out.println("main thread end");
    }
}
