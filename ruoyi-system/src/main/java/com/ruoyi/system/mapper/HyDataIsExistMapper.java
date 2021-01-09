package com.ruoyi.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyDataIsExist;

/**
 * 校验数据是否存在Mapper
 * 
 * @author Administrator
 *
 */
@Mapper
public interface HyDataIsExistMapper {

	/**
	 * 查询指定表中数据是否存在
	 * 
	 * @param hyDataIsExist
	 * @return
	 */
	@Select("select * from ${tableName} where ${fieldName}=#{param}")
	public Object selectHyDataIsExist(HyDataIsExist hyDataIsExist);

}
