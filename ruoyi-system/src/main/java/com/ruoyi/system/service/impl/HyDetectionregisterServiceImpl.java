package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDetectionregisterMapper;
import com.ruoyi.system.domain.HyDetectionregister;
import com.ruoyi.system.service.IHyDetectionregisterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备检测登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Service
public class HyDetectionregisterServiceImpl implements IHyDetectionregisterService 
{
    @Autowired
    private HyDetectionregisterMapper hyDetectionregisterMapper;

    /**
     * 查询设备检测登记
     * 
     * @param id 设备检测登记ID
     * @return 设备检测登记
     */
    @Override
    public HyDetectionregister selectHyDetectionregisterById(Long id)
    {
        return hyDetectionregisterMapper.selectHyDetectionregisterById(id);
    }

    /**
     * 查询设备检测登记列表
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 设备检测登记
     */
    @Override
    public List<HyDetectionregister> selectHyDetectionregisterList(HyDetectionregister hyDetectionregister)
    {
        return hyDetectionregisterMapper.selectHyDetectionregisterList(hyDetectionregister);
    }

    /**
     * 新增设备检测登记
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDetectionregister(HyDetectionregister hyDetectionregister)
    {
        return hyDetectionregisterMapper.insertHyDetectionregister(hyDetectionregister);
    }

    /**
     * 修改设备检测登记
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDetectionregister(HyDetectionregister hyDetectionregister)
    {
        return hyDetectionregisterMapper.updateHyDetectionregister(hyDetectionregister);
    }

    /**
     * 删除设备检测登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionregisterByIds(String ids)
    {
        return hyDetectionregisterMapper.deleteHyDetectionregisterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备检测登记信息
     * 
     * @param id 设备检测登记ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionregisterById(Long id)
    {
        return hyDetectionregisterMapper.deleteHyDetectionregisterById(id);
    }
}
