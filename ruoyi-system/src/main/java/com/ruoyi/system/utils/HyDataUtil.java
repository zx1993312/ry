package com.ruoyi.system.utils;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyDataIsExist;

/**
 * 公共类，设置查询数据是否存在实体类值
 * 
 * @author Administrator
 *
 */
public class HyDataUtil {

	/**
	 * HyDataIsExist字段赋值
	 * 
	 * @param tableName 表名
	 * @param fieldName 字段名
	 * @param data      数据
	 * @return
	 */
	public static HyDataIsExist setData(String tableName, String fieldName, Object param) {
		HyDataIsExist hyDataIsExist = new HyDataIsExist();
		if (StringUtils.isNotNull(tableName) && StringUtils.isNotNull(fieldName) && StringUtils.isNotNull(param)) {
			hyDataIsExist.setTableName(tableName);
			hyDataIsExist.setFieldName(fieldName);
			hyDataIsExist.setParam(String.valueOf(param));
			return hyDataIsExist;
		}
		return null;
	}
}
