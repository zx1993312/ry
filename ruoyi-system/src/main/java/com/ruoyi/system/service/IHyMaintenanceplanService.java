package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceplan;

/**
 * 设备保养计划Service接口
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public interface IHyMaintenanceplanService 
{
    /**
     * 查询设备保养计划
     * 
     * @param id 设备保养计划ID
     * @return 设备保养计划
     */
    public HyMaintenanceplan selectHyMaintenanceplanById(Long id);

    /**
     * 查询设备保养计划列表
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 设备保养计划集合
     */
    public List<HyMaintenanceplan> selectHyMaintenanceplanList(HyMaintenanceplan hyMaintenanceplan);

    /**
     * 新增设备保养计划
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 结果
     */
    public int insertHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan);

    /**
     * 修改设备保养计划
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 结果
     */
    public int updateHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan);

    /**
     * 批量删除设备保养计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceplanByIds(String ids);

    /**
     * 删除设备保养计划信息
     * 
     * @param id 设备保养计划ID
     * @return 结果
     */
    public int deleteHyMaintenanceplanById(Long id);
}
