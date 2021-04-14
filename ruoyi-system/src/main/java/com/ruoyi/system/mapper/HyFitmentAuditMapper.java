package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyFitmentAudit;

/**
 * 装修审核Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public interface HyFitmentAuditMapper 
{
    /**
     * 查询装修审核
     * 
     * @param id 装修审核ID
     * @return 装修审核
     */
    public HyFitmentAudit selectHyFitmentAuditById(Long id);

    /**
     * 查询装修审核列表
     * 
     * @param hyFitmentAudit 装修审核
     * @return 装修审核集合
     */
    public List<HyFitmentAudit> selectHyFitmentAuditList(HyFitmentAudit hyFitmentAudit);

    /**
     * 新增装修审核
     * 
     * @param hyFitmentAudit 装修审核
     * @return 结果
     */
    public int insertHyFitmentAudit(HyFitmentAudit hyFitmentAudit);

    /**
     * 修改装修审核
     * 
     * @param hyFitmentAudit 装修审核
     * @return 结果
     */
    public int updateHyFitmentAudit(HyFitmentAudit hyFitmentAudit);

    /**
     * 删除装修审核
     * 
     * @param id 装修审核ID
     * @return 结果
     */
    public int deleteHyFitmentAuditById(Long id);

    /**
     * 批量删除装修审核
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyFitmentAuditByIds(String[] ids);
}
