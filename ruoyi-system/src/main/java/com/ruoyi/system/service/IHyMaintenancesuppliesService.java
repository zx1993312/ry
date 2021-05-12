package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenancesupplies;

/**
 * 设备保养物料Service接口
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public interface IHyMaintenancesuppliesService 
{
    /**
     * 查询设备保养物料
     * 
     * @param id 设备保养物料ID
     * @return 设备保养物料
     */
    public HyMaintenancesupplies selectHyMaintenancesuppliesById(Long id);

    /**
     * 查询设备保养物料列表
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 设备保养物料集合
     */
    public List<HyMaintenancesupplies> selectHyMaintenancesuppliesList(HyMaintenancesupplies hyMaintenancesupplies);

    /**
     * 新增设备保养物料
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 结果
     */
    public int insertHyMaintenancesupplies(HyMaintenancesupplies hyMaintenancesupplies);

    /**
     * 修改设备保养物料
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 结果
     */
    public int updateHyMaintenancesupplies(HyMaintenancesupplies hyMaintenancesupplies);

    /**
     * 批量删除设备保养物料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenancesuppliesByIds(String ids);

    /**
     * 删除设备保养物料信息
     * 
     * @param id 设备保养物料ID
     * @return 结果
     */
    public int deleteHyMaintenancesuppliesById(Long id);
}
