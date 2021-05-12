package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenancecycle;

/**
 * 设备保养周期Service接口
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public interface IHyMaintenancecycleService 
{
    /**
     * 查询设备保养周期
     * 
     * @param id 设备保养周期ID
     * @return 设备保养周期
     */
    public HyMaintenancecycle selectHyMaintenancecycleById(Long id);

    /**
     * 查询设备保养周期列表
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 设备保养周期集合
     */
    public List<HyMaintenancecycle> selectHyMaintenancecycleList(HyMaintenancecycle hyMaintenancecycle);

    /**
     * 新增设备保养周期
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 结果
     */
    public int insertHyMaintenancecycle(HyMaintenancecycle hyMaintenancecycle);

    /**
     * 修改设备保养周期
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 结果
     */
    public int updateHyMaintenancecycle(HyMaintenancecycle hyMaintenancecycle);

    /**
     * 批量删除设备保养周期
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenancecycleByIds(String ids);

    /**
     * 删除设备保养周期信息
     * 
     * @param id 设备保养周期ID
     * @return 结果
     */
    public int deleteHyMaintenancecycleById(Long id);
}
