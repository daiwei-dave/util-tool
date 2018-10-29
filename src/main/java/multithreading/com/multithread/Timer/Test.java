package multithreading.com.multithread.Timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @sees Java并发编程：Timer和TimerTask（转载）https://www.cnblogs.com/dolphin0520/p/3938991.html
 * @author daiwei
 * @date 2018/10/29 15:45
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("abc");
            }
        }, 200000 , 1000);
    }
}
