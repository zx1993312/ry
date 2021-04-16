package com.ruoyi.system.domain;

import lombok.Data;

/**
 * 地区表实体类
 * 
 * @author Administrator
 *
 */
@Data
public class HyArea {
	private Long id;//id
	private String areaname;//区域名
	private Long parentid;//编码
	private String shortname;//简称
	private Integer areacode;//区域号码
	private Integer zipcode;//邮编
	private String pinyin;//汉语拼音
	private String lng;//经度
	private String lat;//纬度
	private Integer level;//级别
	private String position;//位置
	private Integer sort;//排序
}
