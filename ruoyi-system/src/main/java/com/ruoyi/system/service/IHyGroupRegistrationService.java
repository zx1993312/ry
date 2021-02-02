package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyGroupRegistration;

/**
 * 组团登记Service接口
 * 
 * @author Administrator
 * @date 2021-02-02
 */
public interface IHyGroupRegistrationService 
{
    /**
     * 查询组团登记
     * 
     * @param id 组团登记ID
     * @return 组团登记
     */
    public HyGroupRegistration selectHyGroupRegistrationById(Long id);

    /**
     * 查询组团登记列表
     * 
     * @param hyGroupRegistration 组团登记
     * @return 组团登记集合
     */
    public List<HyGroupRegistration> selectHyGroupRegistrationList(HyGroupRegistration hyGroupRegistration);

    /**
     * 新增组团登记
     * 
     * @param hyGroupRegistration 组团登记
     * @return 结果
     */
    public int insertHyGroupRegistration(HyGroupRegistration hyGroupRegistration);

    /**
     * 修改组团登记
     * 
     * @param hyGroupRegistration 组团登记
     * @return 结果
     */
    public int updateHyGroupRegistration(HyGroupRegistration hyGroupRegistration);

    /**
     * 批量删除组团登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyGroupRegistrationByIds(String ids);

    /**
     * 删除组团登记信息
     * 
     * @param id 组团登记ID
     * @return 结果
     */
    public int deleteHyGroupRegistrationById(Long id);
}
