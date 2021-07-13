package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyEquipmentAbnormalMapper;
import com.ruoyi.system.domain.HyEquipmentAbnormal;
import com.ruoyi.system.service.IHyEquipmentAbnormalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备异常Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-13
 */
@Service
public class HyEquipmentAbnormalServiceImpl implements IHyEquipmentAbnormalService 
{
    @Autowired
    private HyEquipmentAbnormalMapper hyEquipmentAbnormalMapper;

    /**
     * 查询设备异常
     * 
     * @param id 设备异常ID
     * @return 设备异常
     */
    @Override
    public HyEquipmentAbnormal selectHyEquipmentAbnormalById(Long id)
    {
        return hyEquipmentAbnormalMapper.selectHyEquipmentAbnormalById(id);
    }

    /**
     * 查询设备异常列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常
     */
    @Override
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalList(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        return hyEquipmentAbnormalMapper.selectHyEquipmentAbnormalList(hyEquipmentAbnormal);
    }
    
    /**
     * 查询设备异常待审核列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常
     */
    @Override
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByAudit(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	return hyEquipmentAbnormalMapper.selectHyEquipmentAbnormalListByAudit(hyEquipmentAbnormal);
    }
    
    /**
     * 查询设备异常已通过列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常
     */
    @Override
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByThrough(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	return hyEquipmentAbnormalMapper.selectHyEquipmentAbnormalListByThrough(hyEquipmentAbnormal);
    }
    
    /**
     * 查询设备异常已拒绝列表
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 设备异常
     */
    @Override
    public List<HyEquipmentAbnormal> selectHyEquipmentAbnormalListByRefusal(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	return hyEquipmentAbnormalMapper.selectHyEquipmentAbnormalListByRefusal(hyEquipmentAbnormal);
    }

    /**
     * 新增设备异常
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyEquipmentAbnormal(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        return hyEquipmentAbnormalMapper.insertHyEquipmentAbnormal(hyEquipmentAbnormal);
    }

    /**
     * 修改设备异常
     * 
     * @param hyEquipmentAbnormal 设备异常
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyEquipmentAbnormal(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        return hyEquipmentAbnormalMapper.updateHyEquipmentAbnormal(hyEquipmentAbnormal);
    }

    /**
     * 删除设备异常对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentAbnormalByIds(String ids)
    {
        return hyEquipmentAbnormalMapper.deleteHyEquipmentAbnormalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备异常信息
     * 
     * @param id 设备异常ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentAbnormalById(Long id)
    {
        return hyEquipmentAbnormalMapper.deleteHyEquipmentAbnormalById(id);
    }
}
