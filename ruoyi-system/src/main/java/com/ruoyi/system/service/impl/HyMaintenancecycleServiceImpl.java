package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenancecycleMapper;
import com.ruoyi.system.domain.HyMaintenancecycle;
import com.ruoyi.system.service.IHyMaintenancecycleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备保养周期Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Service
public class HyMaintenancecycleServiceImpl implements IHyMaintenancecycleService 
{
    @Autowired
    private HyMaintenancecycleMapper hyMaintenancecycleMapper;

    /**
     * 查询设备保养周期
     * 
     * @param id 设备保养周期ID
     * @return 设备保养周期
     */
    @Override
    public HyMaintenancecycle selectHyMaintenancecycleById(Long id)
    {
        return hyMaintenancecycleMapper.selectHyMaintenancecycleById(id);
    }

    /**
     * 查询设备保养周期列表
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 设备保养周期
     */
    @Override
    public List<HyMaintenancecycle> selectHyMaintenancecycleList(HyMaintenancecycle hyMaintenancecycle)
    {
        return hyMaintenancecycleMapper.selectHyMaintenancecycleList(hyMaintenancecycle);
    }

    /**
     * 新增设备保养周期
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenancecycle(HyMaintenancecycle hyMaintenancecycle)
    {
        return hyMaintenancecycleMapper.insertHyMaintenancecycle(hyMaintenancecycle);
    }

    /**
     * 修改设备保养周期
     * 
     * @param hyMaintenancecycle 设备保养周期
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenancecycle(HyMaintenancecycle hyMaintenancecycle)
    {
        return hyMaintenancecycleMapper.updateHyMaintenancecycle(hyMaintenancecycle);
    }

    /**
     * 删除设备保养周期对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenancecycleByIds(String ids)
    {
        return hyMaintenancecycleMapper.deleteHyMaintenancecycleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备保养周期信息
     * 
     * @param id 设备保养周期ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenancecycleById(Long id)
    {
        return hyMaintenancecycleMapper.deleteHyMaintenancecycleById(id);
    }
}
