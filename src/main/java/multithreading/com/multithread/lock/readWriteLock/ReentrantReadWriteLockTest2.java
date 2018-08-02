package multithreading.com.multithread.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author daiwei
 * @date 2018/8/1 17:18
 */
public class ReentrantReadWriteLockTest2 {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final ReentrantReadWriteLockTest2 test = new ReentrantReadWriteLockTest2();



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



    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 10) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
