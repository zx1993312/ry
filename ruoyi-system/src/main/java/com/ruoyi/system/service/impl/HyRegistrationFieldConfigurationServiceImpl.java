package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyRegistrationFieldConfigurationMapper;
import com.ruoyi.system.domain.HyRegistrationFieldConfiguration;
import com.ruoyi.system.service.IHyRegistrationFieldConfigurationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 注册字段配置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyRegistrationFieldConfigurationServiceImpl implements IHyRegistrationFieldConfigurationService 
{
    @Autowired
    private HyRegistrationFieldConfigurationMapper hyRegistrationFieldConfigurationMapper;

    /**
     * 查询注册字段配置
     * 
     * @param id 注册字段配置ID
     * @return 注册字段配置
     */
    @Override
    public HyRegistrationFieldConfiguration selectHyRegistrationFieldConfigurationById(Long id)
    {
        return hyRegistrationFieldConfigurationMapper.selectHyRegistrationFieldConfigurationById(id);
    }

    /**
     * 查询注册字段配置列表
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 注册字段配置
     */
    @Override
    public List<HyRegistrationFieldConfiguration> selectHyRegistrationFieldConfigurationList(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        return hyRegistrationFieldConfigurationMapper.selectHyRegistrationFieldConfigurationList(hyRegistrationFieldConfiguration);
    }

    /**
     * 新增注册字段配置
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyRegistrationFieldConfiguration(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        return hyRegistrationFieldConfigurationMapper.insertHyRegistrationFieldConfiguration(hyRegistrationFieldConfiguration);
    }

    /**
     * 修改注册字段配置
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyRegistrationFieldConfiguration(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        return hyRegistrationFieldConfigurationMapper.updateHyRegistrationFieldConfiguration(hyRegistrationFieldConfiguration);
    }

    /**
     * 删除注册字段配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRegistrationFieldConfigurationByIds(String ids)
    {
        return hyRegistrationFieldConfigurationMapper.deleteHyRegistrationFieldConfigurationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除注册字段配置信息
     * 
     * @param id 注册字段配置ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRegistrationFieldConfigurationById(Long id)
    {
        return hyRegistrationFieldConfigurationMapper.deleteHyRegistrationFieldConfigurationById(id);
    }
}
