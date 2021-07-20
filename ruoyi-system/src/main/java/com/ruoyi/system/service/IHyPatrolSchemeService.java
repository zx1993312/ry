package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPatrolScheme;

/**
 * 巡检计划Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyPatrolSchemeService 
{
    /**
     * 查询巡检计划
     * 
     * @param id 巡检计划ID
     * @return 巡检计划
     */
    public HyPatrolScheme selectHyPatrolSchemeById(Long id);

    /**
     * 查询巡检计划列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeList(HyPatrolScheme hyPatrolScheme);
    
    /**
     * 查询巡检计划未完成列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeListByUnfinished(HyPatrolScheme hyPatrolScheme);
    
    /**
     * 查询巡检计划进行中列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeListByUnderway(HyPatrolScheme hyPatrolScheme);
    
    /**
     * 查询巡检计划已完成列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeListByFinished(HyPatrolScheme hyPatrolScheme);
    
    /**
     * 查询巡检计划明细列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeDetailList(HyPatrolScheme hyPatrolScheme);

    /**
     * 新增巡检计划
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 结果
     */
    public int insertHyPatrolScheme(HyPatrolScheme hyPatrolScheme);

    /**
     * 修改巡检计划
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 结果
     */
    public int updateHyPatrolScheme(HyPatrolScheme hyPatrolScheme);

    /**
     * 批量删除巡检计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPatrolSchemeByIds(String ids);

    /**
     * 删除巡检计划信息
     * 
     * @param id 巡检计划ID
     * @return 结果
     */
    public int deleteHyPatrolSchemeById(Long id);
}
