package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyAllotequipment;

/**
 * 调拨设备Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-17
 */
public interface HyAllotequipmentMapper 
{
    /**
     * 查询调拨设备
     * 
     * @param id 调拨设备ID
     * @return 调拨设备
     */
    public HyAllotequipment selectHyAllotequipmentById(Long id);

    /**
     * 查询调拨设备列表
     * 
     * @param hyAllotequipment 调拨设备
     * @return 调拨设备集合
     */
    public List<HyAllotequipment> selectHyAllotequipmentList(HyAllotequipment hyAllotequipment);

    /**
     * 新增调拨设备
     * 
     * @param hyAllotequipment 调拨设备
     * @return 结果
     */
    public int insertHyAllotequipment(HyAllotequipment hyAllotequipment);

    /**
     * 修改调拨设备
     * 
     * @param hyAllotequipment 调拨设备
     * @return 结果
     */
    public int updateHyAllotequipment(HyAllotequipment hyAllotequipment);

    /**
     * 删除调拨设备
     * 
     * @param id 调拨设备ID
     * @return 结果
     */
    public int deleteHyAllotequipmentById(Long id);

    /**
     * 批量删除调拨设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAllotequipmentByIds(String[] ids);
}
