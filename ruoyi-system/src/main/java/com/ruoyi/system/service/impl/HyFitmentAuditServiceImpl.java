package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyFitmentAuditMapper;
import com.ruoyi.system.domain.HyFitmentAudit;
import com.ruoyi.system.service.IHyFitmentAuditService;
import com.ruoyi.common.core.text.Convert;

/**
 * 装修审核Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Service
public class HyFitmentAuditServiceImpl implements IHyFitmentAuditService 
{
    @Autowired
    private HyFitmentAuditMapper hyFitmentAuditMapper;

    /**
     * 查询装修审核
     * 
     * @param id 装修审核ID
     * @return 装修审核
     */
    @Override
    public HyFitmentAudit selectHyFitmentAuditById(Long id)
    {
        return hyFitmentAuditMapper.selectHyFitmentAuditById(id);
    }

    /**
     * 查询装修审核列表
     * 
     * @param hyFitmentAudit 装修审核
     * @return 装修审核
     */
    @Override
    public List<HyFitmentAudit> selectHyFitmentAuditList(HyFitmentAudit hyFitmentAudit)
    {
        return hyFitmentAuditMapper.selectHyFitmentAuditList(hyFitmentAudit);
    }

    /**
     * 新增装修审核
     * 
     * @param hyFitmentAudit 装修审核
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyFitmentAudit(HyFitmentAudit hyFitmentAudit)
    {
        return hyFitmentAuditMapper.insertHyFitmentAudit(hyFitmentAudit);
    }

    /**
     * 修改装修审核
     * 
     * @param hyFitmentAudit 装修审核
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyFitmentAudit(HyFitmentAudit hyFitmentAudit)
    {
        return hyFitmentAuditMapper.updateHyFitmentAudit(hyFitmentAudit);
    }

    /**
     * 删除装修审核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFitmentAuditByIds(String ids)
    {
        return hyFitmentAuditMapper.deleteHyFitmentAuditByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除装修审核信息
     * 
     * @param id 装修审核ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFitmentAuditById(Long id)
    {
        return hyFitmentAuditMapper.deleteHyFitmentAuditById(id);
    }
}
