package com.ruoyi.system.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * 公共类表
 * 
 * @author Administrator
 *
 */
@Data
public class HyDataIsExist implements Serializable {

	/**
	 * Serializable id
	 */
	private static final long serialVersionUID = 1L;

	private String tableName;// 表名

	private String fieldName;// 字段名

	private String param;// 参数
}
