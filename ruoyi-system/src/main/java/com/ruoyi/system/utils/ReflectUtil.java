package com.ruoyi.system.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.constants.Constants;

import lombok.extern.log4j.Log4j2;

/**
 * 转换工具累
 * 
 * @author zx
 *
 * @param <T>
 */
@Log4j2
public class ReflectUtil<T> {

	/**
	 * JavaBean 转换为Map
	 * 
	 * @param <T>需转换的JavaBean
	 */
	public Map<String, Object> convertMap(T t) {
		try {
			Map<String, Object> map = new HashMap<>();
			Field[] fields = t.getClass().getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);// 私有属性必须设置访问权限
				EnumAnn enumAnn = field.getAnnotation(EnumAnn.class);
				if (enumAnn != null) {
					Method method = enumAnn.enumClass().getDeclaredMethod("getValue", int.class);
					String enumType = enumAnn.enumType();
					if (null == field.get(t)) {
						break;
					}
					Object s = new Object();
					if (null != field.get(t)) {
						switch (enumType) {
						case "String":
							String fieldString = (String) field.get(t);
							s = method.invoke(enumAnn.enumClass(), Integer.valueOf(fieldString));
							break;
						case "Integer":
							s = method.invoke(enumAnn.enumClass(), (Integer) field.get(t));
							break;
						}
					}
					map.put(field.getName(), s.toString());
				} else {
					map.put(field.getName(), field.get(t));
				}
			}
			return map;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 将t2值赋给t1
	 *
	 * @param t1 需要转换的实体类（接收数据）
	 * @param t2 被转换的实体类（发送数据）
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public T convertBean(T t1, T t2) {
		try {
			if (null == t1 || null == t2) {
				return null;
			}

			Class clazz1 = t1.getClass();// 获取t1的class
			Field[] fields1 = clazz1.getDeclaredFields();// 获取字段

			for (Field field1 : fields1) {
				field1.setAccessible(true);// 私有属性必须设置访问权限

				Class clazz2 = t2.getClass();// 获取t2的class
				Field[] fields2 = clazz2.getDeclaredFields();// 获取字段

				for (Field field2 : fields2) {
					field2.setAccessible(true);// 私有属性必须设置访问权限
					if (Modifier.isFinal(field2.getModifiers())) {
						continue;
					}
					if (field2.get(t2) != null) {
						if (field1.getName().equals(field2.getName())) {// 校验字段名称是否相等
							if (field2.get(t2).getClass() == Date.class) {
								setFieldValueByFieldName(field1.getName(), t1,
										Constants.TIME_ALL.format(field2.get(t2)));// 设置字段值
							} else {
								setFieldValueByFieldName(field1.getName(), t1, String.valueOf(field2.get(t2)));// 设置字段值
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			return null;
		}

		return t1;
	}

	/**
	 * 根据属性名设置属性值，属性id需自己转换
	 *
	 * @param fieldName
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private void setFieldValueByFieldName(String fieldName, Object object, String value) {
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
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
	}
}
