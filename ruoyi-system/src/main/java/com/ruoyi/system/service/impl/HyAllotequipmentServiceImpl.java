package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAllotequipmentMapper;
import com.ruoyi.system.domain.HyAllotequipment;
import com.ruoyi.system.service.IHyAllotequipmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 调拨设备Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-17
 */
@Service
public class HyAllotequipmentServiceImpl implements IHyAllotequipmentService 
{
    @Autowired
    private HyAllotequipmentMapper hyAllotequipmentMapper;

    /**
     * 查询调拨设备
     * 
     * @param id 调拨设备ID
     * @return 调拨设备
     */
    @Override
    public HyAllotequipment selectHyAllotequipmentById(Long id)
    {
        return hyAllotequipmentMapper.selectHyAllotequipmentById(id);
    }

    /**
     * 查询调拨设备列表
     * 
     * @param hyAllotequipment 调拨设备
     * @return 调拨设备
     */
    @Override
    public List<HyAllotequipment> selectHyAllotequipmentList(HyAllotequipment hyAllotequipment)
    {
        return hyAllotequipmentMapper.selectHyAllotequipmentList(hyAllotequipment);
    }

    /**
     * 新增调拨设备
     * 
     * @param hyAllotequipment 调拨设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAllotequipment(HyAllotequipment hyAllotequipment)
    {
        return hyAllotequipmentMapper.insertHyAllotequipment(hyAllotequipment);
    }

    /**
     * 修改调拨设备
     * 
     * @param hyAllotequipment 调拨设备
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAllotequipment(HyAllotequipment hyAllotequipment)
    {
        return hyAllotequipmentMapper.updateHyAllotequipment(hyAllotequipment);
    }

    /**
     * 删除调拨设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAllotequipmentByIds(String ids)
    {
        return hyAllotequipmentMapper.deleteHyAllotequipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除调拨设备信息
     * 
     * @param id 调拨设备ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAllotequipmentById(Long id)
    {
        return hyAllotequipmentMapper.deleteHyAllotequipmentById(id);
    }
}
