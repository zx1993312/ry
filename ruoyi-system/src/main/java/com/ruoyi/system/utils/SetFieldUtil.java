package com.ruoyi.system.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.system.constants.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SetFieldUtil {
	/**
	 * 根据属性名设置属性值，属性id需自己转换
	 *
	 * @param fieldName
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static void setFieldValueByFieldName(String fieldName, Object object, String value) {
		try {
			// 获取obj类的字节文件对象
			Class c = object.getClass();
			// 获取该类的成员变量
			Field f = c.getDeclaredField(fieldName);
			// 取消语言访问检查
			f.setAccessible(true);
			Class<?> s = c.getDeclaredField(fieldName).getType();
			if (value != null && !value.equals("null")) {
				if (s == byte.class || s == Byte.class) {
					f.set(object, Byte.valueOf(value));
				} else if (s == short.class || s == Short.class) {
					f.set(object, Short.valueOf(value));
				} else if (s == int.class || s == Integer.class) {
					f.set(object, Integer.valueOf(value));
				} else if (s == long.class || s == Long.class) {
					f.set(object, Long.valueOf(value));
				} else if (s == float.class || s == Float.class) {
					f.set(object, Float.valueOf(value));
				} else if (s == double.class || s == Double.class) {
					f.set(object, Double.valueOf(value));
				} else if (s == boolean.class || s == Boolean.class) {
					f.set(object, Boolean.valueOf(value));
				} else if (s == Date.class) {
					f.set(object, Constants.TIME_ALL.parse(value));
				} else if (s == BigDecimal.class) {
					f.set(object, new BigDecimal(value));
				} else {
					// 给变量赋值
					f.set(object, value);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
