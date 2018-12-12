package multithreading.com.multithread.join;

/**
 * 多线程join方法
 * 1.join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，
 * 这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
 * 2.为什么要用join()方法
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 * Created by daiwei on 2017/7/26.
 * @seehttp://www.cnblogs.com/GarfieldEr007/p/5746362.html
 */
public class Main {
    /**
     * 不加join方法
     * @param args
     */
//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
//        Thread1 mTh1=new Thread1("A");
//        Thread1 mTh2=new Thread1("B");
//        mTh1.start();
//        mTh2.start();
//        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
//
//    }

    /**
     * 增加join方法
     * 主线程将会等待子线程结束后才往下执行
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mTh2.start();
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");

    }
}
class Thread1 extends Thread{
    private String name;
    public Thread1(String name) {
        super(name);
        this.name=name;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep(10);
    //            sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}