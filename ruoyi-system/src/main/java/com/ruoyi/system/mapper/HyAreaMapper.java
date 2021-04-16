package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyArea;

@Mapper
public interface HyAreaMapper {

	/**
	 * 查询所有省
	 * 
	 * @return
	 */
	@Select("select id, areaname, parentid, shortname, areacode, zipcode, pinyin, lng, lat, level, position, sort from area where parentid =0")
	public List<HyArea> selectChinaProvince();

	/**
	 * 查询所有市
	 * 
	 * @return
	 */
	@Select("select id, areaname, parentid, shortname, areacode, zipcode, pinyin, lng, lat, level, position, sort  from area where parentid = #{parentid}")
	public List<HyArea> selectChinaCity(Long parentid);
	
}
