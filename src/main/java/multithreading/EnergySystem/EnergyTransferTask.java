package multithreading.EnergySystem;

/**
 * Created by daiwei on 2017/4/1.
 */
public class EnergyTransferTask implements Runnable{
    //共享的能量世界
    private EnergySystem energySystem;
    //能量转移的源能量盒子下标
    private int fromBox;
    //单次能量转移最大单元
    private double maxAmount;
    //最大休眠时间（毫秒）
    private int DELAY = 10;


    public EnergyTransferTask(EnergySystem energySystem, int from, double max){
        this.energySystem = energySystem;
        this.fromBox = from;
        this.maxAmount = max;
    }



    public void run() {
        try{
            while (true){
                int toBox = (int) (energySystem.getBoxAmount()* Math.random());
                //这样设置可能会造成死锁，10个线程都处于阻塞状态，系统无法运行，可参考coreJava相关例子
//                 double amount = 200 * Math.random();

                double amount = maxAmount * Math.random();
                energySystem.transfer(fromBox, toBox, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
