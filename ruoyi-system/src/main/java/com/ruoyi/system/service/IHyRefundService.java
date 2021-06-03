package com.ruoyi.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.HyRefund;

/**
 * 退款申请Service接口
 * 
 * @author Administrator
 * @date 2021-05-29
 */
public interface IHyRefundService {
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
	 * 批量删除退款申请
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyRefundByIds(String ids);

	/**
	 * 删除退款申请信息
	 * 
	 * @param id 退款申请ID
	 * @return 结果
	 */
	public int deleteHyRefundById(Long id);
	/**
	 * 导出PDF
	 * @param hyRefund
	 * @param response
	 * @return
	 */
	public int exportPDF(HyRefund hyRefund, HttpServletResponse response)throws Exception;

}