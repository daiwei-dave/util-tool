package multithreading.com.multithread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daiwei
 * @date 2018/8/1 17:18
 */
public class TryLockTest {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    Lock lock = new ReentrantLock();    //注意这个地方

    public static void main(String[] args)  {
        final TryLockTest test = new TryLockTest();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }



    public void insert(Thread thread) {

        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                Thread.sleep(200);
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }
}
