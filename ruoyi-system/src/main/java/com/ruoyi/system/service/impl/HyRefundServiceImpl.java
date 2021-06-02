package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyRefund;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyRefundMapper;
import com.ruoyi.system.service.IHyRefundService;

/**
 * 退款申请Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-29
 */
@Service
public class HyRefundServiceImpl implements IHyRefundService {
	@Autowired
	private HyRefundMapper hyRefundMapper;
	
	@Autowired
	private HyCollectionMapper hyCollectionMapper;

	/**
	 * 查询退款申请
	 * 
	 * @param id 退款申请ID
	 * @return 退款申请
	 */
	@Override
	public HyRefund selectHyRefundById(Long id) {
		return hyRefundMapper.selectHyRefundById(id);
	}

	/**
	 * 查询退款申请列表
	 * 
	 * @param hyRefund 退款申请
	 * @return 退款申请
	 */
	@Override
	public List<HyRefund> selectHyRefundList(HyRefund hyRefund) {
		return hyRefundMapper.selectHyRefundList(hyRefund);
	}

	/**
	 * 新增退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyRefund(HyRefund hyRefund) {
		HyCollection hyCollection = new HyCollection();
		hyCollection.setIsRefund("0");
		hyCollection.setId(hyRefund.getCollectionId());
		hyCollectionMapper.updateHyCollection(hyCollection);
		return hyRefundMapper.insertHyRefund(hyRefund);
	}

	/**
	 * 修改退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyRefund(HyRefund hyRefund) {
		return hyRefundMapper.updateHyRefund(hyRefund);
	}

	/**
	 * 删除退款申请对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyRefundByIds(String ids) {
		return hyRefundMapper.deleteHyRefundByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除退款申请信息
	 * 
	 * @param id 退款申请ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyRefundById(Long id) {
		return hyRefundMapper.deleteHyRefundById(id);
	}

}