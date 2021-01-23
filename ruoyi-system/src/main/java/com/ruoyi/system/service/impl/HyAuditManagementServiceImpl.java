package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyAuditManagementMapper;
import com.ruoyi.system.domain.HyAuditManagement;
import com.ruoyi.system.service.IHyAuditManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 审核管理
Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Service
public class HyAuditManagementServiceImpl implements IHyAuditManagementService 
{
    @Autowired
    private HyAuditManagementMapper hyAuditManagementMapper;

    /**
     * 查询审核管理

     * 
     * @param id 审核管理
ID
     * @return 审核管理

     */
    @Override
    public HyAuditManagement selectHyAuditManagementById(Long id)
    {
        return hyAuditManagementMapper.selectHyAuditManagementById(id);
    }

    /**
     * 查询审核管理
列表
     * 
     * @param hyAuditManagement 审核管理

     * @return 审核管理

     */
    @Override
    public List<HyAuditManagement> selectHyAuditManagementList(HyAuditManagement hyAuditManagement)
    {
        return hyAuditManagementMapper.selectHyAuditManagementList(hyAuditManagement);
    }

    /**
     * 新增审核管理

     * 
     * @param hyAuditManagement 审核管理

     * @return 结果
     */
    @Override
    public int insertHyAuditManagement(HyAuditManagement hyAuditManagement)
    {
        return hyAuditManagementMapper.insertHyAuditManagement(hyAuditManagement);
    }

    /**
     * 修改审核管理

     * 
     * @param hyAuditManagement 审核管理

     * @return 结果
     */
    @Override
    public int updateHyAuditManagement(HyAuditManagement hyAuditManagement)
    {
        return hyAuditManagementMapper.updateHyAuditManagement(hyAuditManagement);
    }

    /**
     * 删除审核管理
对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyAuditManagementByIds(String ids)
    {
        return hyAuditManagementMapper.deleteHyAuditManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审核管理
信息
     * 
     * @param id 审核管理
ID
     * @return 结果
     */
    @Override
    public int deleteHyAuditManagementById(Long id)
    {
        return hyAuditManagementMapper.deleteHyAuditManagementById(id);
    }
}
