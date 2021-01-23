package com.ruoyi.system.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;

/**
 * Date转换工具类
 * 
 * @author Administrator
 *
 */
public class HyDateUtil {

	/**
	 * 获取map,开始时间startTime,结束时间endTime
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, Date> getDate(Date date) {
		if (StringUtils.isNull(date)) {
			return new HashMap<String, Date>();
		}
		Map<String, Date> map = new HashMap<>();
		Calendar startTime = Calendar.getInstance();
		startTime.setTime(date);
		startTime.set(Calendar.HOUR_OF_DAY, 0);// 时
		startTime.set(Calendar.MINUTE, 0);// 分
		startTime.set(Calendar.SECOND, 0);// 秒

		Calendar endTime = Calendar.getInstance();
		endTime.setTime(date);
		endTime.set(Calendar.HOUR_OF_DAY, 23);// 时
		endTime.set(Calendar.MINUTE, 59);// 分
		endTime.set(Calendar.SECOND, 59);// 秒

		map.put("startTime", startTime.getTime());
		map.put("endTime", endTime.getTime());
		return map;
	}
}
