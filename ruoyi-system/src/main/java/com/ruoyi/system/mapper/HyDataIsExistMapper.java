package com.ruoyi.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyDataIsExist;

@Mapper
public interface HyDataIsExistMapper {

	@Select("select * from ${tableName} where ${fieldName}=#{param}")
	public Object selectHyDataIsExist(HyDataIsExist hyDataIsExist);

}
