package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyVatAudit;

/**
 * 增值税率审核Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyVatAuditService 
{
    /**
     * 查询增值税率审核
     * 
     * @param id 增值税率审核ID
     * @return 增值税率审核
     */
    public HyVatAudit selectHyVatAuditById(Long id);

    /**
     * 查询增值税率审核列表
     * 
     * @param hyVatAudit 增值税率审核
     * @return 增值税率审核集合
     */
    public List<HyVatAudit> selectHyVatAuditList(HyVatAudit hyVatAudit);

    /**
     * 新增增值税率审核
     * 
     * @param hyVatAudit 增值税率审核
     * @return 结果
     */
    public int insertHyVatAudit(HyVatAudit hyVatAudit);

    /**
     * 修改增值税率审核
     * 
     * @param hyVatAudit 增值税率审核
     * @return 结果
     */
    public int updateHyVatAudit(HyVatAudit hyVatAudit);

    /**
     * 批量删除增值税率审核
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyVatAuditByIds(String ids);

    /**
     * 删除增值税率审核信息
     * 
     * @param id 增值税率审核ID
     * @return 结果
     */
    public int deleteHyVatAuditById(Long id);
}
