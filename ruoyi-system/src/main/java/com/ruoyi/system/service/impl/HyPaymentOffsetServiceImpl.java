package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyPaymentOffset;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyPaymentOffsetMapper;
import com.ruoyi.system.service.IHyPaymentOffsetService;

/**
 * 预交冲抵Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-26
 */
@Service
public class HyPaymentOffsetServiceImpl implements IHyPaymentOffsetService {
	@Autowired
	private HyPaymentOffsetMapper hyPaymentOffsetMapper;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Autowired
	private HyCostMapper hyCostMapper;

	/**
	 * 查询预交冲抵
	 * 
	 * @param id 预交冲抵ID
	 * @return 预交冲抵
	 */
	@Override
	public HyPaymentOffset selectHyPaymentOffsetById(Long id) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetById(id);
	}

	/**
	 * 查询预交冲抵列表
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 预交冲抵
	 */
	@Override
	public List<HyPaymentOffset> selectHyPaymentOffsetList(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetList(hyPaymentOffset);
	}

	/**
	 * 查询预交冲抵列表
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 预交冲抵
	 */
	@Override
	public List<HyPaymentOffset> selectHyPaymentOffsetListAAA(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetListAAA(hyPaymentOffset);
	}

	@Override
	public List<HyPaymentOffset> selectHyPaymentOffsetListAll(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetListAll(hyPaymentOffset);
	}

	/**
	 * 新增预交冲抵
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		hyPaymentOffset.setOffsetCategory(1);
		hyPaymentOffset.setOffsetPreson("航宇");
		hyPaymentOffset.setOffsetType("预交冲抵");
		hyPaymentOffset.setAuditStatus("0");
		BigDecimal a = hyPaymentOffset.getOffsetMoney();
		Long houseId = hyPaymentOffset.getHouseId();
		List<Long> list = hyCustomerMapper.selectCostId(String.valueOf(houseId), null);
		Long costId = list.get(0);
		HyCost hyCost = hyCostMapper.selectHyCostById(costId);
		BigDecimal b = hyCost.getAmountReceivable();
		BigDecimal amountActually = b.subtract(a);
		hyPaymentOffset.setAmountActually(amountActually);
		return hyPaymentOffsetMapper.insertHyPaymentOffset(hyPaymentOffset);
	}

	/**
	 * 修改预交冲抵
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		BigDecimal a = hyPaymentOffset.getOffsetMoney();
		Long houseId = hyPaymentOffset.getHouseId();
		List<Long> list = hyCustomerMapper.selectCostId(String.valueOf(houseId), null);
		Long costId = list.get(0);
		HyCost hyCost = hyCostMapper.selectHyCostById(costId);
		BigDecimal b = hyCost.getAmountReceivable();
		BigDecimal amountActually = b.subtract(a);
		hyPaymentOffset.setAmountActually(amountActually);
		return hyPaymentOffsetMapper.updateHyPaymentOffset(hyPaymentOffset);
	}

	/**
	 * 删除预交冲抵对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyPaymentOffsetByIds(String ids) {
		return hyPaymentOffsetMapper.deleteHyPaymentOffsetByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除预交冲抵信息
	 * 
	 * @param id 预交冲抵ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyPaymentOffsetById(Long id) {
		return hyPaymentOffsetMapper.deleteHyPaymentOffsetById(id);
	}

}