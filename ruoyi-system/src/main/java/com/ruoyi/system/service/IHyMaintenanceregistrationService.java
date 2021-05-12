package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceregistration;

/**
 * 设备保养登记Service接口
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public interface IHyMaintenanceregistrationService 
{
    /**
     * 查询设备保养登记
     * 
     * @param id 设备保养登记ID
     * @return 设备保养登记
     */
    public HyMaintenanceregistration selectHyMaintenanceregistrationById(Long id);

    /**
     * 查询设备保养登记列表
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 设备保养登记集合
     */
    public List<HyMaintenanceregistration> selectHyMaintenanceregistrationList(HyMaintenanceregistration hyMaintenanceregistration);

    /**
     * 新增设备保养登记
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 结果
     */
    public int insertHyMaintenanceregistration(HyMaintenanceregistration hyMaintenanceregistration);

    /**
     * 修改设备保养登记
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 结果
     */
    public int updateHyMaintenanceregistration(HyMaintenanceregistration hyMaintenanceregistration);

    /**
     * 批量删除设备保养登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceregistrationByIds(String ids);

    /**
     * 删除设备保养登记信息
     * 
     * @param id 设备保养登记ID
     * @return 结果
     */
    public int deleteHyMaintenanceregistrationById(Long id);
}
