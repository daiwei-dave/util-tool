package time;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daiwei on 2018/2/9.
 */
public class CalendarDemoTest {

    @Test
    public void setCalendar() throws Exception {
        CalendarDemo.setCalendar();
        String url="http://bjgc3-gos.gomecloud.com/ax-upload/storage/emulated/0/Android/data/com.gome.axlogistics/tiny/tiny-975-2018-06-15-14-22-54.jpg";
        System.out.println(url.length());
    }


    /**
     * 移位运算测试
     * @sees https://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
     * @throws Exception
     */
    @Test
    public void shiftTest() throws Exception {
        int number = 10;
        //原始数二进制
        printInfo(number);
        //左移一位
        number = number << 1;

        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);

        number = number<< 22;
        System.out.println(number);
        number = number>> 22;
        System.out.println(number);

    }


    /**
     * 输出一个int的二进制数
     *@sees https://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
     * @param num
     */
    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }

}