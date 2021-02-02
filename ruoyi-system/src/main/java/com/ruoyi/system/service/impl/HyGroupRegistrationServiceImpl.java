package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyGroupRegistrationMapper;
import com.ruoyi.system.domain.HyGroupRegistration;
import com.ruoyi.system.service.IHyGroupRegistrationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 组团登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-02-02
 */
@Service
public class HyGroupRegistrationServiceImpl implements IHyGroupRegistrationService 
{
    @Autowired
    private HyGroupRegistrationMapper hyGroupRegistrationMapper;

    /**
     * 查询组团登记
     * 
     * @param id 组团登记ID
     * @return 组团登记
     */
    @Override
    public HyGroupRegistration selectHyGroupRegistrationById(Long id)
    {
        return hyGroupRegistrationMapper.selectHyGroupRegistrationById(id);
    }

    /**
     * 查询组团登记列表
     * 
     * @param hyGroupRegistration 组团登记
     * @return 组团登记
     */
    @Override
    public List<HyGroupRegistration> selectHyGroupRegistrationList(HyGroupRegistration hyGroupRegistration)
    {
        return hyGroupRegistrationMapper.selectHyGroupRegistrationList(hyGroupRegistration);
    }

    /**
     * 新增组团登记
     * 
     * @param hyGroupRegistration 组团登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyGroupRegistration(HyGroupRegistration hyGroupRegistration)
    {
        return hyGroupRegistrationMapper.insertHyGroupRegistration(hyGroupRegistration);
    }

    /**
     * 修改组团登记
     * 
     * @param hyGroupRegistration 组团登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyGroupRegistration(HyGroupRegistration hyGroupRegistration)
    {
        return hyGroupRegistrationMapper.updateHyGroupRegistration(hyGroupRegistration);
    }

    /**
     * 删除组团登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyGroupRegistrationByIds(String ids)
    {
        return hyGroupRegistrationMapper.deleteHyGroupRegistrationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除组团登记信息
     * 
     * @param id 组团登记ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyGroupRegistrationById(Long id)
    {
        return hyGroupRegistrationMapper.deleteHyGroupRegistrationById(id);
    }
}
