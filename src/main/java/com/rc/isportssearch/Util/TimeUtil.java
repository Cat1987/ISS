package com.rc.isportssearch.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.rc.isportssearch.memload.DateRex;

/**
 * 日期处理类
 * 
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月18日
 */
public class TimeUtil 
{
	/**
	 * 获取QQ视频每日日期匹配日期<br>
	 * 当前日期yyyy-mm-dd
	 * @return
	 */
	public static String getTodayTimeRex(String rex)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(rex);
		// 取当前日期。
		Calendar cal = Calendar.getInstance();
		// 取当前日期     后面减一就是前一天
		cal.add(Calendar.DAY_OF_MONTH, 0);
		return sdf.format(cal.getTime());

	}
}
