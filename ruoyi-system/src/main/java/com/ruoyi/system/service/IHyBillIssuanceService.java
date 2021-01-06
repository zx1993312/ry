package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyBillIssuance;

/**
 * 票据发放Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyBillIssuanceService 
{
    /**
     * 查询票据发放
     * 
     * @param id 票据发放ID
     * @return 票据发放
     */
    public HyBillIssuance selectHyBillIssuanceById(Long id);

    /**
     * 查询票据发放列表
     * 
     * @param hyBillIssuance 票据发放
     * @return 票据发放集合
     */
    public List<HyBillIssuance> selectHyBillIssuanceList(HyBillIssuance hyBillIssuance);

    /**
     * 新增票据发放
     * 
     * @param hyBillIssuance 票据发放
     * @return 结果
     */
    public int insertHyBillIssuance(HyBillIssuance hyBillIssuance);

    /**
     * 修改票据发放
     * 
     * @param hyBillIssuance 票据发放
     * @return 结果
     */
    public int updateHyBillIssuance(HyBillIssuance hyBillIssuance);

    /**
     * 批量删除票据发放
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyBillIssuanceByIds(String ids);

    /**
     * 删除票据发放信息
     * 
     * @param id 票据发放ID
     * @return 结果
     */
    public int deleteHyBillIssuanceById(Long id);
}
