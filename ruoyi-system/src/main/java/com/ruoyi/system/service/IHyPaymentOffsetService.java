package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPaymentOffset;

/**
 * 预交冲抵Service接口
 * 
 * @author Administrator
 * @date 2021-05-26
 */
public interface IHyPaymentOffsetService 
{
    /**
     * 查询预交冲抵
     * 
     * @param id 预交冲抵ID
     * @return 预交冲抵
     */
    public HyPaymentOffset selectHyPaymentOffsetById(Long id);

    /**
     * 查询预交冲抵列表
     * 
     * @param hyPaymentOffset 预交冲抵
     * @return 预交冲抵集合
     */
    public List<HyPaymentOffset> selectHyPaymentOffsetList(HyPaymentOffset hyPaymentOffset);
    
    /**
     * 查询预交冲抵列表
     * 
     * @param hyPaymentOffset 预交冲抵
     * @return 预交冲抵集合
     */
    public List<HyPaymentOffset> selectHyPaymentOffsetListAAA(HyPaymentOffset hyPaymentOffset);

    /**
     * 新增预交冲抵
     * 
     * @param hyPaymentOffset 预交冲抵
     * @return 结果
     */
    public int insertHyPaymentOffset(HyPaymentOffset hyPaymentOffset);

    /**
     * 修改预交冲抵
     * 
     * @param hyPaymentOffset 预交冲抵
     * @return 结果
     */
    public int updateHyPaymentOffset(HyPaymentOffset hyPaymentOffset);

    /**
     * 批量删除预交冲抵
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPaymentOffsetByIds(String ids);

    /**
     * 删除预交冲抵信息
     * 
     * @param id 预交冲抵ID
     * @return 结果
     */
    public int deleteHyPaymentOffsetById(Long id);

}