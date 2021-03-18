package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyRegistrationModeConfiguration;

/**
 * 注册方式配置Service接口
 * 
 * @author Administrator
 * @date 2021-03-17
 */
public interface IHyRegistrationModeConfigurationService 
{
    /**
     * 查询注册方式配置
     * 
     * @param id 注册方式配置ID
     * @return 注册方式配置
     */
    public HyRegistrationModeConfiguration selectHyRegistrationModeConfigurationById(Long id);

    /**
     * 查询注册方式配置列表
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 注册方式配置集合
     */
    public List<HyRegistrationModeConfiguration> selectHyRegistrationModeConfigurationList(HyRegistrationModeConfiguration hyRegistrationModeConfiguration);

    /**
     * 新增注册方式配置
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 结果
     */
    public int insertHyRegistrationModeConfiguration(HyRegistrationModeConfiguration hyRegistrationModeConfiguration);

    /**
     * 修改注册方式配置
     * 
     * @param hyRegistrationModeConfiguration 注册方式配置
     * @return 结果
     */
    public int updateHyRegistrationModeConfiguration(HyRegistrationModeConfiguration hyRegistrationModeConfiguration);

    /**
     * 批量删除注册方式配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyRegistrationModeConfigurationByIds(String ids);

    /**
     * 删除注册方式配置信息
     * 
     * @param id 注册方式配置ID
     * @return 结果
     */
    public int deleteHyRegistrationModeConfigurationById(Long id);
}
