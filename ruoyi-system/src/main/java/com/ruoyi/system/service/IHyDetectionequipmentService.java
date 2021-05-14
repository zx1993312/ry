package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDetectionequipment;

/**
 * 检测设备Service接口
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public interface IHyDetectionequipmentService 
{
    /**
     * 查询检测设备
     * 
     * @param id 检测设备ID
     * @return 检测设备
     */
    public HyDetectionequipment selectHyDetectionequipmentById(Long id);

    /**
     * 查询检测设备列表
     * 
     * @param hyDetectionequipment 检测设备
     * @return 检测设备集合
     */
    public List<HyDetectionequipment> selectHyDetectionequipmentList(HyDetectionequipment hyDetectionequipment);

    /**
     * 新增检测设备
     * 
     * @param hyDetectionequipment 检测设备
     * @return 结果
     */
    public int insertHyDetectionequipment(HyDetectionequipment hyDetectionequipment);

    /**
     * 修改检测设备
     * 
     * @param hyDetectionequipment 检测设备
     * @return 结果
     */
    public int updateHyDetectionequipment(HyDetectionequipment hyDetectionequipment);

    /**
     * 批量删除检测设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDetectionequipmentByIds(String ids);

    /**
     * 删除检测设备信息
     * 
     * @param id 检测设备ID
     * @return 结果
     */
    public int deleteHyDetectionequipmentById(Long id);
}
