package com.ruoyi.system.utils;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyDataIsExist;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyMeterCase;

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
				String[] fieldNames = Constants.HY_DATA_IS_EXIST;

				for (int i = 0; i < fieldNames.length; i++) {
					SetFieldUtil.setFieldValueByFieldName(fieldNames[i], hyDataIsExist, params[i]);
				}
				return hyDataIsExist;
			}

			if (obj instanceof HyMeter) {// 校验对象类型
				String[] fieldNames = Constants.HY_METER;

				HyMeter hyMeter = (HyMeter) obj;

				for (int i = 0; i < fieldNames.length; i++) {
					if (StringUtils.isNull(params[i]) || params[i].equals("")) {
						continue;
					}
					SetFieldUtil.setFieldValueByFieldName(fieldNames[i], hyMeter, params[i]);
				}
				return hyMeter;
			}

			if (obj instanceof HyMeterCase) {// 校验对象类型
				String[] fieldNames = Constants.HY_METER_CASE;

				HyMeterCase hyMeterCase = (HyMeterCase) obj;

				for (int i = 0; i < fieldNames.length; i++) {
					if (StringUtils.isNull(params[i]) || params[i].equals("")) {
						continue;
					}
					SetFieldUtil.setFieldValueByFieldName(fieldNames[i], hyMeterCase, params[i]);
				}
				return hyMeterCase;
			}
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
