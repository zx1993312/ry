package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HyRefund;

/**
 * 退款申请Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-29
 */
public interface HyRefundMapper {
	/**
	 * 查询退款申请
	 * 
	 * @param id 退款申请ID
	 * @return 退款申请
	 */
	public HyRefund selectHyRefundById(Long id);

	/**
	 * 查询退款申请列表
	 * 
	 * @param hyRefund 退款申请
	 * @return 退款申请集合
	 */
	public List<HyRefund> selectHyRefundList(HyRefund hyRefund);

	/**
	 * 新增退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	public int insertHyRefund(HyRefund hyRefund);

	/**
	 * 修改退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	public int updateHyRefund(HyRefund hyRefund);

	/**
	 * 删除退款申请
	 * 
	 * @param id 退款申请ID
	 * @return 结果
	 */
	public int deleteHyRefundById(Long id);

	/**
	 * 批量删除退款申请
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyRefundByIds(String[] ids);

}