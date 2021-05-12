package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceunit;

/**
 * 保养单位Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public interface HyMaintenanceunitMapper 
{
    /**
     * 查询保养单位
     * 
     * @param id 保养单位ID
     * @return 保养单位
     */
    public HyMaintenanceunit selectHyMaintenanceunitById(Long id);

    /**
     * 查询保养单位列表
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 保养单位集合
     */
    public List<HyMaintenanceunit> selectHyMaintenanceunitList(HyMaintenanceunit hyMaintenanceunit);

    /**
     * 新增保养单位
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 结果
     */
    public int insertHyMaintenanceunit(HyMaintenanceunit hyMaintenanceunit);

    /**
     * 修改保养单位
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 结果
     */
    public int updateHyMaintenanceunit(HyMaintenanceunit hyMaintenanceunit);

    /**
     * 删除保养单位
     * 
     * @param id 保养单位ID
     * @return 结果
     */
    public int deleteHyMaintenanceunitById(Long id);

    /**
     * 批量删除保养单位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceunitByIds(String[] ids);
}
