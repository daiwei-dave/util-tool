package time;

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
		System.out.println("hah");


		List<Date> listDate = getDatesBetweenTwoDate(start, end);
		for(int i=0;i<listDate.size();i++){
			System.out.println(sdf.format(listDate.get(i)));
		}



//		checkDates("2018年9月,2018年10月");

//		checkDates("2018年9月,2018年13月");
//		checkDates("2018年9月,2018-02");
        checkDates("2018年9月，2018-02");
	}


    /**
     * JAVA 判断一个字符串是不是一个合法的日期格式
     * @sees https://www.cnblogs.com/xdp-gacl/p/3548307.html
     * @param str
     * @return
     */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
		try {
			format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

    /**
     * JAVA 判断一个字符串是不是一个合法的日期格式
     * @sees https://www.cnblogs.com/xdp-gacl/p/3548307.html
     * @param str
     * @return
     */
	public static boolean checkDates(String str) {
		boolean convertSuccess = true;
        String regex = ",|，|\\s+";
        String[] strs = str.split(regex); // 用,分割
		if (strs==null||str.length()==0){
			return false;
		}
		for (int i = 0; i <strs.length ; i++) {
			String var = strs[i];

			SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
			try {
				// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
				format.setLenient(false);
				Date parseDate = format.parse(var);
				String dateStr = format.format(parseDate);
				System.out.println(dateStr);


				format.parse(var);
			} catch (ParseException e) {
				e.printStackTrace();
				// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
				convertSuccess = false;
			}
		}
		return convertSuccess;
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


	/**
	 * 获取某月第一天
	 * @return
	 */
	public static String getFirstDay(SimpleDateFormat format,String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		//获取当前月第一天：
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(format.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		String first = df.format(c.getTime());
		System.out.println("===============first:"+first);
		return first;
	}


	/**
	 * 获取某月最后一天
	 * @return
	 */
	public static String getLastDay(SimpleDateFormat format,String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		//获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		try {
			ca.setTime(format.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);
		String last = df.format(ca.getTime());
		System.out.println("===============last:"+last);
		return last;
	}



	public static Date getLastMonthDayStart() {
		Calendar calendar = Calendar.getInstance();
		//当前月的前1个月
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);


		return calendar.getTime();
	}


	public static Date getLastAmountMonthDayStart(int amount) {
		Calendar calendar = Calendar.getInstance();
		//当前月的前amount个月
		calendar.add(Calendar.MONTH, amount);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);


		return calendar.getTime();
	}



	/**
	 * 获取指定日期的开始时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getCurrentDateStartTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
	}

	/**
	 * 获取指定日期的结束时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getCurrentDateEndTime(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		now.set(Calendar.MILLISECOND, 999);
		return now.getTime();
	}




}

