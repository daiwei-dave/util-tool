package multithreading.com.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author daiwei
 * @date 2018/8/1 16:35
 */
public class AtomicTest {
    public static void main(String[] args){


 //       test1();

        test2();

    }

    private static void test1() {
        AtomicDemo ad = new AtomicDemo();

        for(int i=0; i < 10; i++){
            new Thread(ad).start();
        }
    }


    private static void test2() {
        AtomicDemo2 ad = new AtomicDemo2();

        for(int i=0; i < 10; i++){
            new Thread(ad).start();
        }
    }

}

class AtomicDemo implements Runnable{
    private int serialNumber = 0;

    public void run(){

        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber++;
    }
}



// 改进: 使用原子变量
class AtomicDemo2 implements Runnable{

    private AtomicInteger serialNumber = new AtomicInteger();

    public void run(){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber(){
        // 自增运算
        return serialNumber.getAndIncrement();
    }
}
