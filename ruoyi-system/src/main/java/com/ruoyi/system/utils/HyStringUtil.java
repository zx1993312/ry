package com.ruoyi.system.utils;

/**
 * 字符串公共类
 * 
 * @author Administrator
 *
 */
public class HyStringUtil {

	/**
	 * 按,截取字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String getString(String param) {
		if (param.indexOf(",") >= 1) {
			String[] reStr = param.split(",");
			return reStr[0];
		}
		return param;
	}
}
