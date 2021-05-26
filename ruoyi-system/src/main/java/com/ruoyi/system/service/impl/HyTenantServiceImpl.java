package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyTenantMapper;
import com.ruoyi.system.domain.HyTenant;
import com.ruoyi.system.service.IHyTenantService;
import com.ruoyi.common.core.text.Convert;

/**
 * 租户资料登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-25
 */
@Service
public class HyTenantServiceImpl implements IHyTenantService 
{
    @Autowired
    private HyTenantMapper hyTenantMapper;

    /**
     * 查询租户资料登记
     * 
     * @param id 租户资料登记ID
     * @return 租户资料登记
     */
    @Override
    public HyTenant selectHyTenantById(Long id)
    {
        return hyTenantMapper.selectHyTenantById(id);
    }

    /**
     * 查询租户资料登记列表
     * 
     * @param hyTenant 租户资料登记
     * @return 租户资料登记
     */
    @Override
    public List<HyTenant> selectHyTenantList(HyTenant hyTenant)
    {
        return hyTenantMapper.selectHyTenantList(hyTenant);
    }

    /**
     * 新增租户资料登记
     * 
     * @param hyTenant 租户资料登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyTenant(HyTenant hyTenant)
    {
        return hyTenantMapper.insertHyTenant(hyTenant);
    }

    /**
     * 修改租户资料登记
     * 
     * @param hyTenant 租户资料登记
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyTenant(HyTenant hyTenant)
    {
        return hyTenantMapper.updateHyTenant(hyTenant);
    }

    /**
     * 删除租户资料登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTenantByIds(String ids)
    {
        return hyTenantMapper.deleteHyTenantByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除租户资料登记信息
     * 
     * @param id 租户资料登记ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTenantById(Long id)
    {
        return hyTenantMapper.deleteHyTenantById(id);
    }
}
