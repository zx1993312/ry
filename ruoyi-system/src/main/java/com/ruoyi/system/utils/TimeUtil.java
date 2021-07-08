package com.ruoyi.system.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.system.constants.Constants;

public class TimeUtil {

	public static Map<String, Object> getTime(Date startDate, Date endDate) {
		Calendar calendar = Calendar.getInstance();

		// 获取前月的第一天
		calendar = Calendar.getInstance();
		calendar.setTime(startDate);

		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		String firstday = Constants.TIME_ALL.format(calendar.getTime());

		// 获取前月的最后一天
		calendar = Calendar.getInstance();
		calendar.setTime(endDate);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		String lastday = Constants.TIME_ALL.format(calendar.getTime());
		Map<String, Object> map = new HashMap<>();

		map.put("firstday", firstday);
		map.put("lastday", lastday);
		return map;
	}

	public static void main(String[] args) throws ParseException {
		String s = "2021-06-30-2022-06-30";

		System.out.println(s.substring(0, 10));
		System.out.println(s.substring(11));

	}

}
