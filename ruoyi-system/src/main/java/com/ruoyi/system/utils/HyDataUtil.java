package com.ruoyi.system.utils;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyDataIsExist;
import com.ruoyi.system.domain.HyMeter;

import lombok.extern.log4j.Log4j2;

/**
 * 公共类，设置查询数据是否存在实体类值
 * 
 * @author Administrator
 *
 */
@Log4j2
public class HyDataUtil {

	/**
	 * HyDataIsExist字段赋值
	 * 
	 * @param tableName 表名
	 * @param fieldName 字段名
	 * @param data      数据
	 * @return
	 */
	public static Object setData(Class<?> clazz, String... params) {
		try {
			Object obj = clazz.newInstance();// 生成对象

			if (obj instanceof HyDataIsExist) {// 校验对象类型
				for (String param : params) {
					if (StringUtils.isNull(param) || param.equals("")) {
						return null;
					}
				}
				HyDataIsExist hyDataIsExist = (HyDataIsExist) obj;
				String[] fieldNames = new String[] { "tableName", "fieldName", "param" };// 设置需要赋值的字段名

				for (int i = 0; i < fieldNames.length; i++) {
					SetFieldUtil.setFieldValueByFieldName(fieldNames[i], hyDataIsExist, params[i]);
				}
				return hyDataIsExist;
			}
			if (obj instanceof HyMeter) {// 校验对象类型
				String[] fieldNames = new String[] { "houseNum", "meterType", "meterSerialNum", "meterName",
						"initialRead", "transfRatio", "reverseNot", "strappingType" };// 设置需要赋值的字段名
				HyMeter hyMeter = (HyMeter) obj;

				for (int i = 0; i < fieldNames.length; i++) {
					if (StringUtils.isNull(params[i]) || params[i].equals("")) {
						continue;
					}
					SetFieldUtil.setFieldValueByFieldName(fieldNames[i], hyMeter, params[i]);
				}
				return hyMeter;
			}
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
