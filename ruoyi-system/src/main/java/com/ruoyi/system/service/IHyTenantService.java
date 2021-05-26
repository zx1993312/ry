package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyTenant;

/**
 * 租户资料登记Service接口
 * 
 * @author Administrator
 * @date 2021-05-25
 */
public interface IHyTenantService 
{
    /**
     * 查询租户资料登记
     * 
     * @param id 租户资料登记ID
     * @return 租户资料登记
     */
    public HyTenant selectHyTenantById(Long id);

    /**
     * 查询租户资料登记列表
     * 
     * @param hyTenant 租户资料登记
     * @return 租户资料登记集合
     */
    public List<HyTenant> selectHyTenantList(HyTenant hyTenant);

    /**
     * 新增租户资料登记
     * 
     * @param hyTenant 租户资料登记
     * @return 结果
     */
    public int insertHyTenant(HyTenant hyTenant);

    /**
     * 修改租户资料登记
     * 
     * @param hyTenant 租户资料登记
     * @return 结果
     */
    public int updateHyTenant(HyTenant hyTenant);

    /**
     * 批量删除租户资料登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyTenantByIds(String ids);

    /**
     * 删除租户资料登记信息
     * 
     * @param id 租户资料登记ID
     * @return 结果
     */
    public int deleteHyTenantById(Long id);
}
