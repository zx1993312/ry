package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceequipmentMapper;
import com.ruoyi.system.domain.HyMaintenanceequipment;
import com.ruoyi.system.service.IHyMaintenanceequipmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 保养设备Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Service
public class HyMaintenanceequipmentServiceImpl implements IHyMaintenanceequipmentService 
{
    @Autowired
    private HyMaintenanceequipmentMapper hyMaintenanceequipmentMapper;

    /**
     * 查询保养设备
     * 
     * @param id 保养设备ID
     * @return 保养设备
     */
    @Override
    public HyMaintenanceequipment selectHyMaintenanceequipmentById(Long id)
    {
        return hyMaintenanceequipmentMapper.selectHyMaintenanceequipmentById(id);
    }

    /**
     * 查询保养设备列表
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 保养设备
     */
    @Override
    public List<HyMaintenanceequipment> selectHyMaintenanceequipmentList(HyMaintenanceequipment hyMaintenanceequipment)
    {
        return hyMaintenanceequipmentMapper.selectHyMaintenanceequipmentList(hyMaintenanceequipment);
    }

    /**
     * 新增保养设备
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceequipment(HyMaintenanceequipment hyMaintenanceequipment)
    {
        return hyMaintenanceequipmentMapper.insertHyMaintenanceequipment(hyMaintenanceequipment);
    }

    /**
     * 修改保养设备
     * 
     * @param hyMaintenanceequipment 保养设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceequipment(HyMaintenanceequipment hyMaintenanceequipment)
    {
        return hyMaintenanceequipmentMapper.updateHyMaintenanceequipment(hyMaintenanceequipment);
    }

    /**
     * 删除保养设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceequipmentByIds(String ids)
    {
        return hyMaintenanceequipmentMapper.deleteHyMaintenanceequipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保养设备信息
     * 
     * @param id 保养设备ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceequipmentById(Long id)
    {
        return hyMaintenanceequipmentMapper.deleteHyMaintenanceequipmentById(id);
    }
}
