package multithreading.com.multithread.Volatile;

/**
 * volatile关键字无法保证原子性
 * @sees  https://www.cnblogs.com/dolphin0520/p/3920373.html#undefined
 * @author daiwei
 * @date 2018/9/15 17:15
 */
public class VolatileAtomicTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }


    public static void main(String[] args) {
        final VolatileAtomicTest test = new VolatileAtomicTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1) {  //保证前面的线程都执行完
            Thread.yield();
        }

        System.out.println(test.inc);
    }
}
