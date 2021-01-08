package com.ruoyi.system.service;

/**
 * 校验数据是否重複
 * 
 * @author Administrator
 *
 */
public interface IHyDataIsExistService {
	
	/**
	 * 校验数据是否重复
	 * @param tableName 表名
	 * @param fieldName 字段名
	 * @param data 数据
	 * @return
	 */
	public Object selectHyDataIsExist(String tableName, String fieldName, Object data);
}
