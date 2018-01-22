package multithreading.com.multithread.ThreadLocal;

/**
 * Created by daiwei on 2018/1/22.
 * @sees https://www.cnblogs.com/dolphin0520/p/3920407.html
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());


        Thread thread1 = new Thread(){
            public void run() {
                threadLocalTest.set();
                System.out.println(threadLocalTest.getLong());
                System.out.println(threadLocalTest.getString());
            };
        };
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());


    }
}
