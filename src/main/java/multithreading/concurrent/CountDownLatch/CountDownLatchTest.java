package multithreading.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @sees http://www.cnblogs.com/dolphin0520/p/3920397.html
 * Created by daiwei on 2017/12/15.
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        //计数器的数目必须和子线程数相等
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    //将count值减1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();


        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();


        try {
            System.out.println("等待2个子线程执行完毕...");
            //所有任务没有执行完，主线程一直等待
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
