package com.ruoyi.system.utils;

import java.lang.reflect.Field;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * javabean转换为JsonString
 * 
 * @author Administrator
 *
 */
public class ObjectConverUtil<T> {

	public String coverString(T t) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer sb = new StringBuffer();
		Field[] fields = t.getClass().getDeclaredFields();
		sb.append("{");
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (null == fields[i].get(t)) {
				continue;
			}
			if (fields[i].get(t).getClass().isPrimitive()) {
				continue;
			}
			if (BaseEntity.class.isAssignableFrom(fields[i].get(t).getClass())) {
				Field[] sonFields = fields[i].get(t).getClass().getDeclaredFields();
				for (int j = 0; j < sonFields.length; j++) {
					fields[j].setAccessible(true);// 私有属性必须设置访问权限
					sb.append("\" " + sonFields[j].getName() + "\" : " + sonFields[j].get(t));
					if (j != sonFields.length - 1) {
						sb.append(",");
					}
				}
			}
			sb.append("\" " + fields[i].getName() + "\" : " + fields[i].get(t));
			if (i != fields.length - 1) {
				sb.append(",");
			}

		}
		sb.append("}");
		return sb.toString();
	}

}
