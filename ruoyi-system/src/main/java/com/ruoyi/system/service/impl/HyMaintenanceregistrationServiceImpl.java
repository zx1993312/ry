package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceregistrationMapper;
import com.ruoyi.system.domain.HyMaintenanceregistration;
import com.ruoyi.system.service.IHyMaintenanceregistrationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备保养登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Service
public class HyMaintenanceregistrationServiceImpl implements IHyMaintenanceregistrationService 
{
    @Autowired
    private HyMaintenanceregistrationMapper hyMaintenanceregistrationMapper;

    /**
     * 查询设备保养登记
     * 
     * @param id 设备保养登记ID
     * @return 设备保养登记
     */
    @Override
    public HyMaintenanceregistration selectHyMaintenanceregistrationById(Long id)
    {
        return hyMaintenanceregistrationMapper.selectHyMaintenanceregistrationById(id);
    }

    /**
     * 查询设备保养登记列表
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 设备保养登记
     */
    @Override
    public List<HyMaintenanceregistration> selectHyMaintenanceregistrationList(HyMaintenanceregistration hyMaintenanceregistration)
    {
        return hyMaintenanceregistrationMapper.selectHyMaintenanceregistrationList(hyMaintenanceregistration);
    }

    /**
     * 新增设备保养登记
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceregistration(HyMaintenanceregistration hyMaintenanceregistration)
    {
    	hyMaintenanceregistration.setRecordNumber(new Date().getTime());
    	hyMaintenanceregistration.setStartTime(new Date());
    	hyMaintenanceregistration.setEndTime(new Date());
        return hyMaintenanceregistrationMapper.insertHyMaintenanceregistration(hyMaintenanceregistration);
    }

    /**
     * 修改设备保养登记
     * 
     * @param hyMaintenanceregistration 设备保养登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceregistration(HyMaintenanceregistration hyMaintenanceregistration)
    {
        return hyMaintenanceregistrationMapper.updateHyMaintenanceregistration(hyMaintenanceregistration);
    }

    /**
     * 删除设备保养登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceregistrationByIds(String ids)
    {
        return hyMaintenanceregistrationMapper.deleteHyMaintenanceregistrationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备保养登记信息
     * 
     * @param id 设备保养登记ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceregistrationById(Long id)
    {
        return hyMaintenanceregistrationMapper.deleteHyMaintenanceregistrationById(id);
    }
}
