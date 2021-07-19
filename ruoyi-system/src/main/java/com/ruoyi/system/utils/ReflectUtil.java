package com.ruoyi.system.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.BaseEntity;
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
public class ReflectUtil {

	/**
	 * JavaBean 转换为Map
	 * 
	 * @param <T>需转换的JavaBean
	 */
	public static <T> Map<String, Object> convertMap(T t) {
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
						continue;
					}
					Object s = new Object();
					if (null != field.get(t) && !field.get(t).equals("")) {
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
			return null;
		}

	}

	public List<Map<String, Object>> convertMap(List<?>... lists) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> relist = new ArrayList<>();
			for (int i = 0; i < lists.length; i++) {
				if (null == lists[i] || lists[i].size() == 0) {
					return new ArrayList<>();
				}
				for (Object t : lists[i]) {
					Field[] fields = t.getClass().getDeclaredFields();
					for (Field field : fields) {
						map = new HashMap<String, Object>();
						field.setAccessible(true);// 私有属性必须设置访问权限
						if (null == field.get(t)) {
							continue;
						}
						map.put(field.getName(), field.get(t));
						relist.add(map);
					}
				}
			}
			return relist;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 将t2值赋给t1
	 *
	 * @param t1 需要转换的实体类（接收数据）
	 * @param t2 被转换的实体类（发送数据）
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T convertBean(T t1, T t2) {
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
					if (field2.get(t2) != null && !field2.get(t2).getClass().isPrimitive()) {
						if (BaseEntity.class.isAssignableFrom(field2.get(t2).getClass())) {// 判断字段是否为BaseEntity子类
							continue;
						}

						if (field1.getName().equals(field2.getName())) {// 校验字段名称是否相等
							if (field2.get(t2).getClass() == Date.class) {
								SetFieldUtil.setFieldValueByFieldName(field1.getName(), t1,
										Constants.TIME_ALL.format(field2.get(t2)));// 设置字段值
							} else {
								SetFieldUtil.setFieldValueByFieldName(field1.getName(), t1,
										String.valueOf(field2.get(t2)));// 设置字段值
							}
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return t1;
	}

}
