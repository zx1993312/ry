package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyCost;

/**
 * 费用项目Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface HyCostMapper 
{
    /**
     * 查询费用项目
     * 
     * @param id 费用项目ID
     * @return 费用项目
     */
    public HyCost selectHyCostById(Long id);

    /**
     * 查询费用项目列表
     * 
     * @param hyCost 费用项目
     * @return 费用项目集合
     */
    public List<HyCost> selectHyCostList(HyCost hyCost);
    
    /**
     * 查询费用项目列表
     * 
     * @param hyCost 费用项目
     * @return 费用项目集合
     */
	public List<HyCost> selectHyCostListDistinct(HyCost hyCost);

    /**
     * 新增费用项目
     * 
     * @param hyCost 费用项目
     * @return 结果
     */
    public int insertHyCost(HyCost hyCost);

    /**
     * 修改费用项目
     * 
     * @param hyCost 费用项目
     * @return 结果
     */
    public int updateHyCost(HyCost hyCost);
    
    public int updateHyCostByIdCostItems(HyCost hyCost);
    
    
    public int updateHyCostOther(String currentState);
    
    
    

    /**
     * 删除费用项目
     * 
     * @param id 费用项目ID
     * @return 结果
     */
    public int deleteHyCostById(Long id);

    /**
     * 批量删除费用项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCostByIds(String[] ids);
    
    /**
	 * 查询表下一主键值
	 * 
	 * @param tableName
	 * @return
	 */
	@Select("SELECT Auto_increment FROM information_schema.`TABLES` WHERE Table_Schema=#{databaseName} AND table_name = #{tableName} limit 1;")
	public String selectNextValue(@Param("databaseName") String databaseName, @Param("tableName") String tableName);

}
