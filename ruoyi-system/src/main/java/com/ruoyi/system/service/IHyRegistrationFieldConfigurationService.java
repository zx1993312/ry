package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyRegistrationFieldConfiguration;

/**
 * 注册字段配置Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyRegistrationFieldConfigurationService 
{
    /**
     * 查询注册字段配置
     * 
     * @param id 注册字段配置ID
     * @return 注册字段配置
     */
    public HyRegistrationFieldConfiguration selectHyRegistrationFieldConfigurationById(Long id);

    /**
     * 查询注册字段配置列表
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 注册字段配置集合
     */
    public List<HyRegistrationFieldConfiguration> selectHyRegistrationFieldConfigurationList(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration);

    /**
     * 新增注册字段配置
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 结果
     */
    public int insertHyRegistrationFieldConfiguration(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration);

    /**
     * 修改注册字段配置
     * 
     * @param hyRegistrationFieldConfiguration 注册字段配置
     * @return 结果
     */
    public int updateHyRegistrationFieldConfiguration(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration);

    /**
     * 批量删除注册字段配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyRegistrationFieldConfigurationByIds(String ids);

    /**
     * 删除注册字段配置信息
     * 
     * @param id 注册字段配置ID
     * @return 结果
     */
    public int deleteHyRegistrationFieldConfigurationById(Long id);
}
