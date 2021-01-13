package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyFeeRemission;

/**
 * 费用减免Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-13
 */
public interface HyFeeRemissionMapper 
{
    /**
     * 查询费用减免
     * 
     * @param id 费用减免ID
     * @return 费用减免
     */
    public HyFeeRemission selectHyFeeRemissionById(Long id);

    /**
     * 查询费用减免列表
     * 
     * @param hyFeeRemission 费用减免
     * @return 费用减免集合
     */
    public List<HyFeeRemission> selectHyFeeRemissionList(HyFeeRemission hyFeeRemission);

    /**
     * 新增费用减免
     * 
     * @param hyFeeRemission 费用减免
     * @return 结果
     */
    public int insertHyFeeRemission(HyFeeRemission hyFeeRemission);

    /**
     * 修改费用减免
     * 
     * @param hyFeeRemission 费用减免
     * @return 结果
     */
    public int updateHyFeeRemission(HyFeeRemission hyFeeRemission);

    /**
     * 删除费用减免
     * 
     * @param id 费用减免ID
     * @return 结果
     */
    public int deleteHyFeeRemissionById(Long id);

    /**
     * 批量删除费用减免
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyFeeRemissionByIds(String[] ids);
}
