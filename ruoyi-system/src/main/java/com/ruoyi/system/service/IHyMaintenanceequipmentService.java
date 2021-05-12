package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceequipment;

/**
 * 保养设备Service接口
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public interface IHyMaintenanceequipmentService 
{
    /**
     * 查询保养设备
     * 
     * @param id 保养设备ID
     * @return 保养设备
     */
    public HyMaintenanceequipment selectHyMaintenanceequipmentById(Long id);

    /**
     * 查询保养设备列表
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 保养设备集合
     */
    public List<HyMaintenanceequipment> selectHyMaintenanceequipmentList(HyMaintenanceequipment hyMaintenanceequipment);

    /**
     * 新增保养设备
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 结果
     */
    public int insertHyMaintenanceequipment(HyMaintenanceequipment hyMaintenanceequipment);

    /**
     * 修改保养设备
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 结果
     */
    public int updateHyMaintenanceequipment(HyMaintenanceequipment hyMaintenanceequipment);

    /**
     * 批量删除保养设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceequipmentByIds(String ids);

    /**
     * 删除保养设备信息
     * 
     * @param id 保养设备ID
     * @return 结果
     */
    public int deleteHyMaintenanceequipmentById(Long id);
}
