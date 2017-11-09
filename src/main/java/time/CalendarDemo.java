package time;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by daiwei on 2017/11/7.
 */
public class CalendarDemo {
    private static Calendar calendar = Calendar.getInstance();
    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 基本用法，获取年月日时分秒星期
    public static void main(String[] args) {

  //     getBasicInfo();
        setCalendar();
    }

    /**
     * 基本用法，获取年月日时分秒星期
     */
    private static void getBasicInfo() {
        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // 获取时
        int hour = calendar.get(Calendar.HOUR);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示

        // 获取分
        int minute = calendar.get(Calendar.MINUTE);

        // 获取秒
        int second = calendar.get(Calendar.SECOND);

        // 星期，英语国家星期从星期日开始计算
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("现在是" + year + "年" + month + "月" + day + "日" + hour
                + "时" + minute + "分" + second + "秒" + "星期" + weekday);
        //获取当前时间
        sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(calendar.getTime()));
    }



    /**
     * 设置日期
     */
    public static void setCalendar() {
        //设置日期
        calendar.set(Calendar.YEAR, 2000);
        System.out.println("现在是" + calendar.get(Calendar.YEAR) + "年");

        calendar.set(2008, 8, 8);
        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月
        int month = calendar.get(Calendar.MONTH);

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("现在是" + year + "年" + month + "月" + day + "日");
    }


}
