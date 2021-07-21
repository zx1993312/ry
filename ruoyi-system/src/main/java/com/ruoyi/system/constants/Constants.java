package com.ruoyi.system.constants;

import java.text.SimpleDateFormat;

/**
 * system常量
 * 
 * @author Administrator
 *
 */
public class Constants {

	public static final String BYTE = "Byte";

	public static final String SHORT = "Short";

	public static final String INTEGER = "Integer";

	public static final String LONG = "Long";

	public static final String FLOAT = "Float";

	public static final String DOUBLE = "Double";

	public static final String BOOLEAN = "Boolean";

	public static final String CHARACTER = "Character";

	public static final String STRING = "String";
	
	public static final String CRON_DAY = "0 */1 * * * ?";//每天
	
	public static final String CRON_WEEK = "";//每周
	
	public static final String CRON_MONTH = "";//每月

	public static final int CODE_WIDTH = 300;

	public static final int CODE_HEIGHT = 300;
	
	public static final SimpleDateFormat TIME_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间转换年月日时分秒

	public static final SimpleDateFormat TIME_YEAR = new SimpleDateFormat("yyyy");// 时间转换年

	public static final SimpleDateFormat TIME_MONTH = new SimpleDateFormat("MM");// 时间转换月

	public static final SimpleDateFormat TIME_DAY = new SimpleDateFormat("dd");// 时间转换日

	public static final SimpleDateFormat TIME_YEAR_MONTH = new SimpleDateFormat("yyyy-MM");// 时间转换日

	public static final SimpleDateFormat TIME_YEAR_MONTH_DAY = new SimpleDateFormat("yyyy-MM-dd");// 时间转换年月日

	public static final SimpleDateFormat TIME_HOUR_MINUTE_SECOND = new SimpleDateFormat("HH:mm:ss");// 时间转换时分秒

	public static final SimpleDateFormat TIME_HOUR_MINUTE = new SimpleDateFormat("HH:mm");// 时间转换时分

	public static final String[] HY_DATA_IS_EXIST = new String[] { "tableName", "fieldName", "param" };// 设置需要赋值的字段名HyDataIsExist

	public static final String[] HY_METER = new String[] { "houseNum", "meterType", "meterSerialNum", "meterName",
			"initialRead", "transfRatio", "reverseNot", "strappingType" };// 设置需要赋值的字段名HyMeter

	public static final String[] HY_METER_CASE = new String[] { "meterCaseName", "meterCasePosition", "meterSerial" };// 设置需要赋值的字段名HyMeterCase

}
