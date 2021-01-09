package com.ruoyi.system.domain;

import lombok.Data;

/**
 * 公共类表
 * 
 * @author Administrator
 *
 */
@Data
public class HyDataIsExist {

	private String tableName;// 表名

	private String fieldName;// 字段名

	private String param;// 参数
}
