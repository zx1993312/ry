package com.ruoyi.system.utils;

import com.alibaba.fastjson.JSONArray;

/**
 * javabean转换为JsonString
 * 
 * @author Administrator
 *
 */
public class ObjectConverUtil {

	public static String coverString(Object obj) {
		return JSONArray.toJSON(obj).toString();
	}

}
