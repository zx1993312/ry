package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyExemptionReason;

/**
 * 减免原因设置Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyExemptionReasonService 
{
    /**
     * 查询减免原因设置
     * 
     * @param id 减免原因设置ID
     * @return 减免原因设置
     */
    public HyExemptionReason selectHyExemptionReasonById(Long id);

    /**
     * 查询减免原因设置列表
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 减免原因设置集合
     */
    public List<HyExemptionReason> selectHyExemptionReasonList(HyExemptionReason hyExemptionReason);

    /**
     * 新增减免原因设置
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 结果
     */
    public int insertHyExemptionReason(HyExemptionReason hyExemptionReason);

    /**
     * 修改减免原因设置
     * 
     * @param hyExemptionReason 减免原因设置
     * @return 结果
     */
    public int updateHyExemptionReason(HyExemptionReason hyExemptionReason);

    /**
     * 批量删除减免原因设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyExemptionReasonByIds(String ids);

    /**
     * 删除减免原因设置信息
     * 
     * @param id 减免原因设置ID
     * @return 结果
     */
    public int deleteHyExemptionReasonById(Long id);
}
