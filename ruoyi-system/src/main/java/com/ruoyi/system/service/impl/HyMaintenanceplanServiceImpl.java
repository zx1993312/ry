package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceplanMapper;
import com.ruoyi.system.domain.HyMaintenanceplan;
import com.ruoyi.system.service.IHyMaintenanceplanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备保养计划Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Service
public class HyMaintenanceplanServiceImpl implements IHyMaintenanceplanService 
{
    @Autowired
    private HyMaintenanceplanMapper hyMaintenanceplanMapper;

    /**
     * 查询设备保养计划
     * 
     * @param id 设备保养计划ID
     * @return 设备保养计划
     */
    @Override
    public HyMaintenanceplan selectHyMaintenanceplanById(Long id)
    {
        return hyMaintenanceplanMapper.selectHyMaintenanceplanById(id);
    }

    /**
     * 查询设备保养计划列表
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 设备保养计划
     */
    @Override
    public List<HyMaintenanceplan> selectHyMaintenanceplanList(HyMaintenanceplan hyMaintenanceplan)
    {
        return hyMaintenanceplanMapper.selectHyMaintenanceplanList(hyMaintenanceplan);
    }

    /**
     * 新增设备保养计划
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan)
    {
        return hyMaintenanceplanMapper.insertHyMaintenanceplan(hyMaintenanceplan);
    }

    /**
     * 修改设备保养计划
     * 
     * @param hyMaintenanceplan 设备保养计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan)
    {
        return hyMaintenanceplanMapper.updateHyMaintenanceplan(hyMaintenanceplan);
    }

    /**
     * 删除设备保养计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceplanByIds(String ids)
    {
        return hyMaintenanceplanMapper.deleteHyMaintenanceplanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备保养计划信息
     * 
     * @param id 设备保养计划ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceplanById(Long id)
    {
        return hyMaintenanceplanMapper.deleteHyMaintenanceplanById(id);
    }
}
