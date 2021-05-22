package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyOwnerRegistration;

/**
 * 业主资料登记Service接口
 * 
 * @author Administrator
 * @date 2021-01-09
 */
public interface IHyOwnerRegistrationService 
{
    /**
     * 查询业主资料登记
     * 
     * @param id 业主资料登记ID
     * @return 业主资料登记
     */
    public HyOwnerRegistration selectHyOwnerRegistrationById(Long id);

    /**
     * 查询业主资料登记列表
     * 
     * @param hyOwnerRegistration 业主资料登记
     * @return 业主资料登记集合
     */
    public List<HyOwnerRegistration> selectHyOwnerRegistrationList(HyOwnerRegistration hyOwnerRegistration);
    
    
    /**
     * 新增业主资料登记
     * 
     * @param hyOwnerRegistration 业主资料登记
     * @return 结果
     */
    public int insertHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration);

    /**
     * 修改业主资料登记
     * 
     * @param hyOwnerRegistration 业主资料登记
     * @return 结果
     */
    public int updateHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration);

    /**
     * 批量删除业主资料登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyOwnerRegistrationByIds(String ids);

    /**
     * 删除业主资料登记信息
     * 
     * @param id 业主资料登记ID
     * @return 结果
     */
    public int deleteHyOwnerRegistrationById(Long id);



	public String importOwnerRegistration(List<HyOwnerRegistration> hyOwnerRegistrationList, boolean updateSupport,
			String operName);

}
