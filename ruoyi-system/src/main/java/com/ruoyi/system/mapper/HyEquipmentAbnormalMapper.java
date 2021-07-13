package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyEquipmentAbnormal;

/**
 * 设备异常Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public interface HyEquipmentAbnormalMapper 
{
    /**
     * 查询设备异常
     * 
     * @param id 设备异常ID
     * @return 设备异常
     */
    public HyEquipmentAbnormal selectHyEquipmentAbnormalById(Long id);

    /**
     * 查询设备异常列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常集合
     */
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalList(HyEquipmentAbnormal hyEquipmentAbnormal);
    
    /**
     * 查询设备异常待审核列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常集合
     */
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByAudit(HyEquipmentAbnormal hyEquipmentAbnormal);
    
    /**
     * 查询设备异常已通过列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常集合
     */
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByThrough(HyEquipmentAbnormal hyEquipmentAbnormal);
    
    /**
     * 查询设备异常已拒绝列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常集合
     */
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByRefusal(HyEquipmentAbnormal hyEquipmentAbnormal);

    /**
     * 新增设备异常
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 结果
     */
    public int insertHyEquipmentAbnormal(HyEquipmentAbnormal hyEquipmentAbnormal);

    /**
     * 修改设备异常
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 结果
     */
    public int updateHyEquipmentAbnormal(HyEquipmentAbnormal hyEquipmentAbnormal);

    /**
     * 删除设备异常
     * 
     * @param id 设备异常ID
     * @return 结果
     */
    public int deleteHyEquipmentAbnormalById(Long id);

    /**
     * 批量删除设备异常
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEquipmentAbnormalByIds(String[] ids);
}
