package multithreading.GuardedBlocks;

public class ProducerConsumerExample {
    /**
     * 开启了两个线程
     * @param args
     */
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
       (new Thread(new Consumer(drop))).start();
    }
}