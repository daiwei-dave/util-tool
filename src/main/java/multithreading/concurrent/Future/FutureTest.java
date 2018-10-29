package multithreading.concurrent.Future;

import java.util.concurrent.*;

/**
 * 使用Callable+Future获取执行结果
 * Created by daiwei on 2017/12/13.
 */
public class FutureTest {
    public static void main(String[] args) {
        /**
         * 线程池的大小会根据执行的任务数动态分配
         *
         * */
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        //关闭线程池
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");


        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("所有任务执行完毕");
    }
}
class Task implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}