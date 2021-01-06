package com.ruoyi.system.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.system.annotation.EnumAnn;

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
		log.info("转换javabean");
		try {
			Map<String, Object> map = new HashMap<>();
			Field[] fields = t.getClass().getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);// 私有属性必须设置访问权限
				EnumAnn enumAnn = field.getAnnotation(EnumAnn.class);
				if (enumAnn != null) {
					Method method = enumAnn.enumClass().getDeclaredMethod("getValue", int.class);
					String enumType = enumAnn.enumType();
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
}
