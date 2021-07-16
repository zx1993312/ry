package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyProduct;

/**
 * 商品Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public interface HyProductMapper {
	/**
	 * 查询商品
	 * 
	 * @param id 商品ID
	 * @return 商品
	 */
	public HyProduct selectHyProductById(Long id);
	
	/**
	 * 查询商品列表
	 * 
	 * @param hyProduct 商品
	 * @return 商品集合
	 */
	public List<HyProduct> selectHyProductList(HyProduct hyProduct);

	/**
	 * 新增商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	public int insertHyProduct(HyProduct hyProduct);

	/**
	 * 修改商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	public int updateHyProduct(HyProduct hyProduct);

	/**
	 * 删除商品
	 * 
	 * @param id 商品ID
	 * @return 结果
	 */
	public int deleteHyProductById(Long id);

	/**
	 * 批量删除商品
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyProductByIds(String[] ids);
	/**
	 * 查询表下一主键值
	 * 
	 * @param tableName
	 * @return
	 */
	@Select("SELECT Auto_increment FROM information_schema.`TABLES` WHERE Table_Schema=#{databaseName} AND table_name = #{tableName} limit 1;")
	public String selectNextValue(@Param("databaseName") String databaseName, @Param("tableName") String tableName);

}
