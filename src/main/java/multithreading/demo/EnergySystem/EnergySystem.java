package multithreading.demo.EnergySystem;

/**
 * 宇宙的能量系统 遵循能量守恒定律： 能量不会凭空创生或消失，只会从一处转移到另一处
 * Created by daiwei on 2017/4/1.
 */
public class EnergySystem {
    // 能量盒子，能量存贮的地方
    private final double[] energyBoxes;
    private final Object lockObj = new Object();

    /**
     * 为每个盒子赋值
     *
     * @param n
     *            能量盒子的数量
     * @param initialEnergy
     *            每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n, double initialEnergy) {
        energyBoxes = new double[n];
        for (int i = 0; i < energyBoxes.length; i++) {
            energyBoxes[i] = initialEnergy;
        }
    }

    /**
     * 能量的转移，从一个盒子到另一个盒子
     *
     * @param from
     *            能量源
     * @param to
     *            能量终点
     * @param amount
     *            能量值
     */
    public void transfer(int from, int to, double amount) {

        /**
         * 同步代码块 ,实现互斥.{}里面的都只能有一个线程进入
         * 线程同步的作用与事务管理的作用有些类似
         */
        synchronized (lockObj) {
            // while循环，保证条件不满足时任务都会被条件阻挡
            // 而不是继续竞争CPU资源
            while (energyBoxes[from] < amount) {
                try {
                    // 条件不满足, 将当前线程放入Wait Set（等待池）。使该线程处于等待状态，其他线程可以进入了
                    lockObj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            // 传出能量
            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            // 收获能量
            energyBoxes[to] += amount;
            System.out.printf(" 能量总和：%10.2f%n", getTotalEnergies());

//            //使用notify()也有可能会死锁，因为唤醒等待的线程是随机的，可能某个线程一直不被唤醒
//            lockObj.notify();

            //唤醒所有在lockObj对象上等待的线程,将会由其他线程来执行唤醒操作
            lockObj.notifyAll();
        }
    }

    /**
     * 获取能量世界的能量总和
     */
    private double getTotalEnergies() {
        double sum=0;
        for(double amout: energyBoxes){
            sum+=amout;
        }
        return sum;
    }

    /**
     * 返回能量盒子的长度
     */
    public  int getBoxAmount(){
        return energyBoxes.length;
    }
}


