package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceplan;

/**
 * 设备保养计划Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public interface HyMaintenanceplanMapper 
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
     * 查询设备保养计划未完成列表
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 设备保养计划集合
     */
    public List<HyMaintenanceplan> selectHyMaintenanceplanListByUnfinished(HyMaintenanceplan hyMaintenanceplan);
    
    /**
     * 查询设备保养计划进行中列表
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 设备保养计划集合
     */
    public List<HyMaintenanceplan> selectHyMaintenanceplanListByUnderway(HyMaintenanceplan hyMaintenanceplan);
    
    /**
     * 查询设备保养计划已完成列表
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 设备保养计划集合
     */
    public List<HyMaintenanceplan> selectHyMaintenanceplanListByFinished(HyMaintenanceplan hyMaintenanceplan);

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
     * 删除设备保养计划
     * 
     * @param id 设备保养计划ID
     * @return 结果
     */
    public int deleteHyMaintenanceplanById(Long id);

    /**
     * 批量删除设备保养计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceplanByIds(String[] ids);
}
