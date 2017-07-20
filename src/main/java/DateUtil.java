import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
* @Description 时间转换工具
* @auther diawei
* @Date 2017年6月27日 下午5:14:19
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

	public static void main(String[] args) throws Exception {

		//测试getDatesBetweenTwoDate
		String start = "2014-03-05";
		String end = "2014-03-05";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date dBegin = sdf.parse(start);
//		Date dEnd = sdf.parse(end);
//		List<Date> listDate = getDatesBetweenTwoDate(dBegin, dEnd);
		List<Date> listDate = getDatesBetweenTwoDate(start, end);
		for(int i=0;i<listDate.size();i++){
			System.out.println(sdf.format(listDate.get(i)));
		}




	}

	/**
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 *
	 * @param beginDate
	 * @param endDate
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(beginDate);// 把开始时间加入集合
		if(beginDate.getTime()==endDate.getTime()){
			return lDate;
		}
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(beginDate);
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			cal.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				lDate.add(cal.getTime());
			} else {
				break;
			}
		}
		lDate.add(endDate);// 把结束时间加入集合
		return lDate;
	}

	/**
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static List<Date> getDatesBetweenTwoDate(String startDate,String endDate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date sDate =sdf.parse(startDate);
		Date eDate =sdf.parse(endDate);
		return getDatesBetweenTwoDate(sDate,eDate);
	}




	/**
	 * 获取指定日期所在月份的天数
	 *
	 * @paramdate
	 *            指定日期，yyyy-MM-dd
	 * @return 天数
	 */
	public static final int getDaysOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);//Java月份才0开始算
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 获取当前年的天数
	 * @param year
	 * @return
	 */
	public static final int getDaysOfYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param startDate 较小的时间
	 * @param endDate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(String startDate,String endDate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date sDate =sdf.parse(startDate);
		Date eDate =sdf.parse(endDate);
		return daysBetween(sDate, eDate);
	}



}

