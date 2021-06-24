package com.ruoyi.system.utils;

import java.lang.reflect.Field;

import com.alibaba.fastjson.JSONArray;

/**
 * javabean转换为JsonString
 * 
 * @author Administrator
 *
 */
public class ObjectConverUtil<T> {

	public String coverString(T t) {
		Field[] fields = t.getClass().getFields();
		for (Field f : fields) {
			f.setAccessible(true);
			/*if(f ) {
				
			}*/
		}
		return JSONArray.toJSON(t).toString();
	}

}
