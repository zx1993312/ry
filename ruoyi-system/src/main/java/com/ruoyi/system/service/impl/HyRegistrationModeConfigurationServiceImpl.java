package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyRegistrationModeConfigurationMapper;
import com.ruoyi.system.domain.HyRegistrationModeConfiguration;
import com.ruoyi.system.service.IHyRegistrationModeConfigurationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 注册方式配置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Service
public class HyRegistrationModeConfigurationServiceImpl implements IHyRegistrationModeConfigurationService 
{
    @Autowired
    private HyRegistrationModeConfigurationMapper hyRegistrationModeConfigurationMapper;

    /**
     * 查询注册方式配置
     * 
     * @param id 注册方式配置ID
     * @return 注册方式配置
     */
    @Override
    public HyRegistrationModeConfiguration selectHyRegistrationModeConfigurationById(Long id)
    {
        return hyRegistrationModeConfigurationMapper.selectHyRegistrationModeConfigurationById(id);
    }

    /**
     * 查询注册方式配置列表
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 注册方式配置
     */
    @Override
    public List<HyRegistrationModeConfiguration> selectHyRegistrationModeConfigurationList(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        return hyRegistrationModeConfigurationMapper.selectHyRegistrationModeConfigurationList(hyRegistrationModeConfiguration);
    }

    /**
     * 新增注册方式配置
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyRegistrationModeConfiguration(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        return hyRegistrationModeConfigurationMapper.insertHyRegistrationModeConfiguration(hyRegistrationModeConfiguration);
    }

    /**
     * 修改注册方式配置
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyRegistrationModeConfiguration(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        return hyRegistrationModeConfigurationMapper.updateHyRegistrationModeConfiguration(hyRegistrationModeConfiguration);
    }

    /**
     * 删除注册方式配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRegistrationModeConfigurationByIds(String ids)
    {
        return hyRegistrationModeConfigurationMapper.deleteHyRegistrationModeConfigurationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除注册方式配置信息
     * 
     * @param id 注册方式配置ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRegistrationModeConfigurationById(Long id)
    {
        return hyRegistrationModeConfigurationMapper.deleteHyRegistrationModeConfigurationById(id);
    }
}
