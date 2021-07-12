package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyServiceregistration;
import com.ruoyi.system.mapper.HyServiceregistrationMapper;
import com.ruoyi.system.service.IHyServiceregistrationService;

/**
 * 设备维修登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Service
public class HyServiceregistrationServiceImpl implements IHyServiceregistrationService 
{
    @Autowired
    private HyServiceregistrationMapper hyServiceregistrationMapper;

    /**
     * 查询设备维修登记
     * 
     * @param id 设备维修登记ID
     * @return 设备维修登记
     */
    @Override
    public HyServiceregistration selectHyServiceregistrationById(Long id)
    {
        return hyServiceregistrationMapper.selectHyServiceregistrationById(id);
    }

    /**
     * 查询设备维修登记列表
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 设备维修登记
     */
    @Override
    public List<HyServiceregistration> selectHyServiceregistrationList(HyServiceregistration hyServiceregistration)
    {
        return hyServiceregistrationMapper.selectHyServiceregistrationList(hyServiceregistration);
    }

    /**
     * 新增设备维修登记
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyServiceregistration(HyServiceregistration hyServiceregistration)
    {
        return hyServiceregistrationMapper.insertHyServiceregistration(hyServiceregistration);
    }

    /**
     * 修改设备维修登记
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyServiceregistration(HyServiceregistration hyServiceregistration)
    {
        return hyServiceregistrationMapper.updateHyServiceregistration(hyServiceregistration);
    }

    /**
     * 删除设备维修登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServiceregistrationByIds(String ids)
    {
        return hyServiceregistrationMapper.deleteHyServiceregistrationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备维修登记信息
     * 
     * @param id 设备维修登记ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServiceregistrationById(Long id)
    {
        return hyServiceregistrationMapper.deleteHyServiceregistrationById(id);
    }
}
