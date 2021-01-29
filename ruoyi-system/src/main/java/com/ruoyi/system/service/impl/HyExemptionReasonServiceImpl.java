package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyExemptionReasonMapper;
import com.ruoyi.system.domain.HyExemptionReason;
import com.ruoyi.system.service.IHyExemptionReasonService;
import com.ruoyi.common.core.text.Convert;

/**
 * 减免原因设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyExemptionReasonServiceImpl implements IHyExemptionReasonService 
{
    @Autowired
    private HyExemptionReasonMapper hyExemptionReasonMapper;

    /**
     * 查询减免原因设置
     * 
     * @param id 减免原因设置ID
     * @return 减免原因设置
     */
    @Override
    public HyExemptionReason selectHyExemptionReasonById(Long id)
    {
        return hyExemptionReasonMapper.selectHyExemptionReasonById(id);
    }

    /**
     * 查询减免原因设置列表
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 减免原因设置
     */
    @Override
    public List<HyExemptionReason> selectHyExemptionReasonList(HyExemptionReason hyExemptionReason)
    {
        return hyExemptionReasonMapper.selectHyExemptionReasonList(hyExemptionReason);
    }

    /**
     * 新增减免原因设置
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyExemptionReason(HyExemptionReason hyExemptionReason)
    {
        return hyExemptionReasonMapper.insertHyExemptionReason(hyExemptionReason);
    }

    /**
     * 修改减免原因设置
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyExemptionReason(HyExemptionReason hyExemptionReason)
    {
        return hyExemptionReasonMapper.updateHyExemptionReason(hyExemptionReason);
    }

    /**
     * 删除减免原因设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyExemptionReasonByIds(String ids)
    {
        return hyExemptionReasonMapper.deleteHyExemptionReasonByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除减免原因设置信息
     * 
     * @param id 减免原因设置ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyExemptionReasonById(Long id)
    {
        return hyExemptionReasonMapper.deleteHyExemptionReasonById(id);
    }
}
