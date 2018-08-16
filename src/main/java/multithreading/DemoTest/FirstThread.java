package multithreading.DemoTest;

import java.util.Random;

/**
 *多线程抢红包案例
 * @sees https://blog.csdn.net/qq_27717967/article/details/78388450
 * <p>
 *      1、如果钱数0.04，数量4个，类似这样的需要特殊处理

2、为了生成钱数的概率达到尽可能的平等 val = new Random().nextInt(totalVal/count);

3、便于金额的操作，换算为整形进行操作

4、随机生成的金额可能是0，需要进行判断处理
 * </p>
 * @author daiwei
 * @date 2018/8/16 14:15
 */
public class FirstThread {


    /**
     * 10个红包，5个人抢
     * @param args
     */
    public static void main(String[] args) {

        //5个红包，10块钱
        Bao bao = new Bao(10, 5);
        User user = new User(bao);
        for(int i=0;i<10;i++) {
            new Thread(user).start();
        }
    }



}
// 每一个用户都是一个线程
class User implements Runnable{
    private Bao bao;
    public User(Bao bao) {
        this.bao = bao;
    }

    public void run() {
        double money = bao.getRandomMoney();
        if(money == 0) {
            System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
        }else {
            System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
        }

    }
}


class Bao{
    private double total; // 总钱数
    private int totalVal; // 随机生成整数，将钱数化为整数
    private int count;	  // 红包总数

    public Bao(double total, int count) {
        this.total = total;
        this.count = count;
        this.totalVal = (int)(total * 100);
    }

    public synchronized double getRandomMoney() {
        //最后被抢到的金额
        int val;
        // 1.当前剩余钱数 0.04 4人，保证最后的人都能获得0.01
        if(count !=0 && totalVal / count == 1) {
            val = 1;
            totalVal = totalVal - val;
            count--;
            return val/100.0;
        }
        // 2.红包总数为0
        if(count <= 0) {
            val = 0;
        }else if(count == 1) {  // 3.红包总数为1
            val = totalVal;
        }else {
            int temp; //剩下的金额
            while(true) {
                // 随机生成当前金额的随机数 [0,totalVal/count),尽量平均一点
                val = new Random().nextInt(totalVal/count);
                temp = totalVal - val;
                // 4.判断生成的金额大于0，且剩余的钱数够剩下人平分到0.01元
                if(temp*1.0/(count-1) >= 1 && val > 0) {
                    break;
                }
            }
            totalVal = totalVal - val;
        }
        count--;
        return val/100.0;
    }
}


