package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyPatrolScheme;

/**
 * 巡检计划Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface HyPatrolSchemeMapper 
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
     * 删除巡检计划
     * 
     * @param id 巡检计划ID
     * @return 结果
     */
    public int deleteHyPatrolSchemeById(Long id);

    /**
     * 批量删除巡检计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPatrolSchemeByIds(String[] ids);
}
