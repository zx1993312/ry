package com.ruoyi.system.domain;

import lombok.Data;

@Data
public class HySelectMeter {

	/** id */
	private Integer id;

	/** 楼宇名称 */
	private String buildingName;

	/** 房屋编号 */
	private String houseNum;

	/** 表计类型 */
	private String meterType;

	/** 表计序号 */
	private String meterSerialNum;

	/** 表计名称 */
	private String meterName;

	/** 初始读数 */
	private String initialRead;

	/** 起数 */
	private String meterStrNum;

	/** 止数 */
	private String meterEndNum;

	/** 变比 */
	private String transfRatio;

	/** 计量表类型 */
	private String strappingType;

	/** 抄表日期 */
	private String meterReadDate;

	/** 现用表 */
	private String newMeterConsumption;

	/** 旧表用量 */
	private String oldMeterConsumption;

	/** 损耗 */
	private String attritionRate;

	/** 单价 */
	private String unitPrice;

	/** 金额 */
	private String amountPrice;

	/** 客户名称 */
	private String customerName;

	/** 业主/租户 */
	private String ownerTenant;

	/** 房屋名称 */
	private String houseName;
	
	private HyHouseInf hyHouseInf;
}
