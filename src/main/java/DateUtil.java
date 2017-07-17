import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description 时间转换工具
* @auther liyi7
* @Date 2017年4月27日 下午5:14:19
* @Copyright(c) gome inc Gome Co.,LTD
 */
public class DateUtil {
	
    private final static Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * 将时间转换成时间字符串，格式为yyyy-MM-dd HH:mm:ss
	 * @param date  带转换的时间
	 * @return  时间字符串
	 */
	public static String toDateString(Date date) {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			log.debug("时间字符串转换错误：待转换的时间-->" + date);
		}
		return dateStr;
	}
	
	/**
	 * 将时间转换成时间字符串，格式为yyyy-MM-dd
	 * @param date  带转换的时间
	 * @return  时间字符串
	 */
	public static String toShortDateString(Date date) {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			log.debug("时间字符串转换错误：待转换的时间-->" + date);
		}
		return dateStr;
	}
	
	/**
	 * 将时间转换成时间字符串，需自定义格式
	 * @param date  带转换的时间
	 * @param formatStr  自定义格式
	 * @return  时间字符串
	 */
	public static String toDateString(Date date, String formatStr) {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			log.debug("时间字符串转换错误：待转换的时间-->" + date);
		}
		return dateStr;
	}
			
	/**
	 * 将时间字符串转换成时间，需自定义格式
	 * @param dateStr  时间字符串
	 * @param formatStr 自定义格式
	 * @return
	 */
	public static Date toDate(String dateStr, String formatStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			log.debug("时间转换错误：待转换的时间字符串-->" + dateStr);
		}
		return date;
	}
}

