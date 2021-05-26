package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HyAbcPayment;
import com.ruoyi.system.domain.TenantAndHouse;

/**
 * 租户房屋关联Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-26
 */
public interface TenantAndHouseMapper 
{
	
	/**
     * 查询租户房屋关联
     * 
     * @param id 租户房屋关联ID
     * @return 租户房屋关联
     */
    public TenantAndHouse selectTenantAndHouseById(Long id);

    /**
     * 查询租户房屋关联列表
     * 
     * @param tenantAndHouse 租户房屋关联
     * @return 租户房屋关联集合
     */
    public List<TenantAndHouse> selectTenantAndHouseList(TenantAndHouse tenantAndHouse);
    /**
     * 新增租户房屋关联
     * 
     * @param tenantAndHouse 租户房屋关联
     * @return 结果
     */
    public int insertTenantAndHouse(TenantAndHouse tenantAndHouse);

    /**
     * 修改租户房屋关联
     * 
     * @param tenantAndHouse 租户房屋关联
     * @return 结果
     */
    public int updateTenantAndHouse(TenantAndHouse tenantAndHouse);

    /**
     * 删除租户房屋关联
     * 
     * @param id 租户房屋关联ID
     * @return 结果
     */
    public int deleteTenantAndHouseById(Long id);

}
