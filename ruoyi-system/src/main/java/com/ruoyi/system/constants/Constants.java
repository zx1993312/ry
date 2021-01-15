package com.ruoyi.system.constants;

import java.text.SimpleDateFormat;

import com.ruoyi.system.utils.ReflectUtil;

/**
 * system常量
 * 
 * @author Administrator
 *
 */
public class Constants {

	public static final ReflectUtil<Object> REFLECT_UTIL = new ReflectUtil<>();// 转换javabean工具类

	public static final String BYTE = "Byte";

	public static final String SHORT = "Short";

	public static final String INTEGER = "Integer";

	public static final String LONG = "Long";

	public static final String FLOAT = "Float";

	public static final String DOUBLE = "Double";

	public static final String BOOLEAN = "Boolean";

	public static final String CHARACTER = "Character";

	public static final String STRING = "String";

	public static final SimpleDateFormat TIME_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间转换年月日时分秒

	public static final SimpleDateFormat TIME_YEAR_MONTH_DAY = new SimpleDateFormat("yyyy-MM-dd");// 时间转换年月日

	public static final SimpleDateFormat TIME_HOUR_MINUTE_SECOND = new SimpleDateFormat("HH:mm:ss");// 时间转换时分秒

	public static final SimpleDateFormat TIME_HOUR_MINUTE = new SimpleDateFormat("HH:mm");// 时间转换时分

	public static final String[] HY_DATA_IS_EXIST = new String[] { "tableName", "fieldName", "param" };// 设置需要赋值的字段名HyDataIsExist

	public static final String[] HY_METER = new String[] { "houseNum", "meterType", "meterSerialNum", "meterName",
			"initialRead", "transfRatio", "reverseNot", "strappingType" };// 设置需要赋值的字段名HyMeter

	public static final String[] HY_METER_CASE = new String[] { "meterCaseName", "meterCasePosition", "meterSerial" };// 设置需要赋值的字段名HyMeterCase

}
