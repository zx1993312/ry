package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyAnnualplan;

/**
 * 年度保养计划Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public interface HyAnnualplanMapper 
{
    /**
     * 查询年度保养计划
     * 
     * @param id 年度保养计划ID
     * @return 年度保养计划
     */
    public HyAnnualplan selectHyAnnualplanById(Long id);

    /**
     * 查询年度保养计划列表
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 年度保养计划集合
     */
    public List<HyAnnualplan> selectHyAnnualplanList(HyAnnualplan hyAnnualplan);

    /**
     * 新增年度保养计划
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 结果
     */
    public int insertHyAnnualplan(HyAnnualplan hyAnnualplan);

    /**
     * 修改年度保养计划
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 结果
     */
    public int updateHyAnnualplan(HyAnnualplan hyAnnualplan);

    /**
     * 删除年度保养计划
     * 
     * @param id 年度保养计划ID
     * @return 结果
     */
    public int deleteHyAnnualplanById(Long id);

    /**
     * 批量删除年度保养计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAnnualplanByIds(String[] ids);
}
