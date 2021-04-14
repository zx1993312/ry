package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenance;

/**
 * 维修费用Service接口
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public interface IHyMaintenanceService 
{
    /**
     * 查询维修费用
     * 
     * @param id 维修费用ID
     * @return 维修费用
     */
    public HyMaintenance selectHyMaintenanceById(Long id);

    /**
     * 查询维修费用列表
     * 
     * @param hyMaintenance 维修费用
     * @return 维修费用集合
     */
    public List<HyMaintenance> selectHyMaintenanceList(HyMaintenance hyMaintenance);

    /**
     * 新增维修费用
     * 
     * @param hyMaintenance 维修费用
     * @return 结果
     */
    public int insertHyMaintenance(HyMaintenance hyMaintenance);

    /**
     * 修改维修费用
     * 
     * @param hyMaintenance 维修费用
     * @return 结果
     */
    public int updateHyMaintenance(HyMaintenance hyMaintenance);

    /**
     * 批量删除维修费用
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceByIds(String ids);

    /**
     * 删除维修费用信息
     * 
     * @param id 维修费用ID
     * @return 结果
     */
    public int deleteHyMaintenanceById(Long id);
}
