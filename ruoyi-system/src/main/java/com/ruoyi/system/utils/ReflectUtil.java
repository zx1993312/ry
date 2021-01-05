package com.ruoyi.system.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
		log.info("1111111111111111111111111111111111");
		try {
			Map<String, Object> map = new HashMap<>();
			Field[] fields = t.getClass().getFields();
			for (Field field : fields) {
				map.put(field.getName(), field.get(t));
			}
			return map;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
