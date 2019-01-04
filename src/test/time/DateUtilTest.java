package time;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author daiwei
 * @date 2019/1/4 9:54
 */
public class DateUtilTest {

    @Test
    public void toDateString() {
        String dateString = DateUtil.toDateString(new Date(), "yyyy-MM-dd HH:mm");
        System.out.println(dateString);
    }
}