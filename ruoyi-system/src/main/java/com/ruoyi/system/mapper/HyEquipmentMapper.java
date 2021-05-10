package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyEquipment;

/**
 * 设备类别Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-08
 */
public interface HyEquipmentMapper 
{
    /**
     * 查询设备类别
     * 
     * @param id 设备类别ID
     * @return 设备类别
     */
    public HyEquipment selectHyEquipmentById(Long id);

    /**
     * 查询设备类别列表
     * 
     * @param hyEquipment 设备类别
     * @return 设备类别集合
     */
    public List<HyEquipment> selectHyEquipmentList(HyEquipment hyEquipment);

    /**
     * 新增设备类别
     * 
     * @param hyEquipment 设备类别
     * @return 结果
     */
    public int insertHyEquipment(HyEquipment hyEquipment);

    /**
     * 修改设备类别
     * 
     * @param hyEquipment 设备类别
     * @return 结果
     */
    public int updateHyEquipment(HyEquipment hyEquipment);

    /**
     * 删除设备类别
     * 
     * @param id 设备类别ID
     * @return 结果
     */
    public int deleteHyEquipmentById(Long id);

    /**
     * 批量删除设备类别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEquipmentByIds(String[] ids);
}
