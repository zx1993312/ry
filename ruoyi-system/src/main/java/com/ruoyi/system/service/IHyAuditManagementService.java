package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyAuditManagement;

/**
 * 审核管理
Service接口
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public interface IHyAuditManagementService 
{
    /**
     * 查询审核管理

     * 
     * @param id 审核管理
ID
     * @return 审核管理

     */
    public HyAuditManagement selectHyAuditManagementById(Long id);

    /**
     * 查询审核管理
列表
     * 
     * @param hyAuditManagement 审核管理

     * @return 审核管理
集合
     */
    public List<HyAuditManagement> selectHyAuditManagementList(HyAuditManagement hyAuditManagement);

    /**
     * 新增审核管理

     * 
     * @param hyAuditManagement 审核管理

     * @return 结果
     */
    public int insertHyAuditManagement(HyAuditManagement hyAuditManagement);

    /**
     * 修改审核管理

     * 
     * @param hyAuditManagement 审核管理

     * @return 结果
     */
    public int updateHyAuditManagement(HyAuditManagement hyAuditManagement);

    /**
     * 批量删除审核管理

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAuditManagementByIds(String ids);

    /**
     * 删除审核管理
信息
     * 
     * @param id 审核管理
ID
     * @return 结果
     */
    public int deleteHyAuditManagementById(Long id);
}
