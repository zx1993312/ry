package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDetectionequipmentMapper;
import com.ruoyi.system.domain.HyDetectionequipment;
import com.ruoyi.system.service.IHyDetectionequipmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检测设备Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Service
public class HyDetectionequipmentServiceImpl implements IHyDetectionequipmentService 
{
    @Autowired
    private HyDetectionequipmentMapper hyDetectionequipmentMapper;

    /**
     * 查询检测设备
     * 
     * @param id 检测设备ID
     * @return 检测设备
     */
    @Override
    public HyDetectionequipment selectHyDetectionequipmentById(Long id)
    {
        return hyDetectionequipmentMapper.selectHyDetectionequipmentById(id);
    }

    /**
     * 查询检测设备列表
     * 
     * @param hyDetectionequipment 检测设备
     * @return 检测设备
     */
    @Override
    public List<HyDetectionequipment> selectHyDetectionequipmentList(HyDetectionequipment hyDetectionequipment)
    {
        return hyDetectionequipmentMapper.selectHyDetectionequipmentList(hyDetectionequipment);
    }

    /**
     * 新增检测设备
     * 
     * @param hyDetectionequipment 检测设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDetectionequipment(HyDetectionequipment hyDetectionequipment)
    {
        return hyDetectionequipmentMapper.insertHyDetectionequipment(hyDetectionequipment);
    }

    /**
     * 修改检测设备
     * 
     * @param hyDetectionequipment 检测设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDetectionequipment(HyDetectionequipment hyDetectionequipment)
    {
        return hyDetectionequipmentMapper.updateHyDetectionequipment(hyDetectionequipment);
    }

    /**
     * 删除检测设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionequipmentByIds(String ids)
    {
        return hyDetectionequipmentMapper.deleteHyDetectionequipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除检测设备信息
     * 
     * @param id 检测设备ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionequipmentById(Long id)
    {
        return hyDetectionequipmentMapper.deleteHyDetectionequipmentById(id);
    }
}
