package com.ruoyi.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyDataIsExist;

/**
 * hy公共mapper
 * 
 * @author Administrator
 *
 */
@Mapper
public interface HyCommonMapper {

	/**
	 * 查询指定表中数据是否存在
	 * 
	 * @param hyDataIsExist
	 * @return
	 */
	@Select("select * from ${tableName} where ${fieldName}=#{param}")
	public Object selectHyDataIsExist(HyDataIsExist hyDataIsExist);

	/**
	 * 查询表下一主键值
	 * 
	 * @param tableName
	 * @return
	 */
	@Select("SELECT Auto_increment FROM information_schema.`TABLES` WHERE Table_Schema=#{databaseName} AND table_name = #{tableName} limit 1;")
	public String selectNextValue(@Param("databaseName") String databaseName, @Param("tableName") String tableName);
}
