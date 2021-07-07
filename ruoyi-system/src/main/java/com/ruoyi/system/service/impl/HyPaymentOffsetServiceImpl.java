package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyPaymentOffset;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyPaymentOffsetMapper;
import com.ruoyi.system.service.IHyPaymentOffsetService;
import com.ruoyi.system.utils.ReceivableUtil;

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

	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;

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
		String[] costIds = hyPaymentOffset.getCostIds().split(",");
		for (String costId : costIds) {
			HyPaymentOffset offset = new HyPaymentOffset();
			offset.setCostId(Long.valueOf(costId));
			offset.setHouseId(hyPaymentOffset.getHouseId());
			List<HyPaymentOffset> paymentOffsetList = hyPaymentOffsetMapper.selectHyPaymentOffsetList(offset);
			if (paymentOffsetList.size() == 0) {//冲抵没有该条记录 插入操作
				HyPaymentOffset reOffset = new HyPaymentOffset();
				reOffset = (HyPaymentOffset) Constants.REFLECT_UTIL.convertBean(new HyPaymentOffset(), hyPaymentOffset);
				HouseAndCost houseAndCost = new HouseAndCost();
				houseAndCost.setCostId(Long.valueOf(costId));
				houseAndCost.setHouseId(hyPaymentOffset.getHouseId());
				List<HouseAndCost> houseAndCostList = hyCustomerMapper.selectCostIds(houseAndCost);
				houseAndCost = houseAndCostList.get(0);
				String offsetDate = "";
				BigDecimal offsetMoney = new BigDecimal(0.00);
				String payFeeDate = houseAndCost.getPayFeeDate();
				if (hyPaymentOffset.getOffsetYear() != null && !"".equals(hyPaymentOffset.getOffsetYear())) {
					int m = Integer.valueOf(hyPaymentOffset.getOffsetYear());
					String a = payFeeDate.split("-")[1];
					String b = payFeeDate.split("-")[0];
					String c = payFeeDate.split("-")[2];
					int n = Integer.parseInt(a);
					int y = Integer.parseInt(b);
					String z = y + m + "";
					offsetDate = z + "-0" + n + "-" + c;
					HyCost hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
					HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
					BigDecimal amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
							hyCost.getCalculationMehod(), hyHouseInf.getBilingArea());
					offsetMoney = amountReceivable.multiply(new BigDecimal(m));
					if (hyPaymentOffset.getOffsetMonth() != null && !"".equals(hyPaymentOffset.getOffsetMonth())) {
						m = Integer.valueOf(hyPaymentOffset.getOffsetMonth());
						int w = Integer.valueOf(hyPaymentOffset.getOffsetYear());
						hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
						hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
						amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
								hyCost.getCalculationMehod(), hyHouseInf.getBilingArea());
						BigDecimal amountReceivableByMonth = ReceivableUtil.getReceivable(
								hyCost.getCalculationStandard(), hyCost.getCalculationMehod(),
								hyHouseInf.getBilingArea(), m + "");
						offsetMoney = amountReceivable.multiply(new BigDecimal(w)).add(amountReceivableByMonth);
						a = payFeeDate.split("-")[1];
						b = payFeeDate.split("-")[0];
						c = payFeeDate.split("-")[2];
						n = Integer.parseInt(a);
						y = Integer.parseInt(b);
						if (m + n > 12) {
							z = y + 1 + w + "";
							String p = m + n - 12 + "";
							offsetDate = z + "-0" + p + "-" + c;
						} else {
							String p = m + n + "";
							if (Integer.parseInt(p) > 9) {
								z = y + w + "";
								offsetDate = z + "-" + p + "-" + c;
							} else {
								z = y + w + "";
								offsetDate = z + "-0" + p + "-" + c;
							}
						}
					}
				} else if (hyPaymentOffset.getOffsetMonth() != null && !"".equals(hyPaymentOffset.getOffsetMonth())) {
					int m = Integer.valueOf(hyPaymentOffset.getOffsetMonth());
					String a = payFeeDate.split("-")[1];
					String b = payFeeDate.split("-")[0];
					String c = payFeeDate.split("-")[2];
					int n = Integer.parseInt(a);
					int y = Integer.parseInt(b);
					HyCost hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
					HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
					BigDecimal amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
							hyCost.getCalculationMehod(), hyHouseInf.getBilingArea(), m + "");
					offsetMoney = amountReceivable;
					if (m + n > 12) {
						String z = y + 1 + "";
						String p = m + n - 12 + "";
						offsetDate = z + "-0" + p + "-" + c;
					} else {
						String p = m + n + "";
						if (Integer.parseInt(p) > 9) {
							offsetDate = b + "-" + p + "-" + c;
						} else {
							offsetDate = b + "-0" + p + "-" + c;
						}
					}
				}
				reOffset.setOffsetDate(offsetDate);
				reOffset.setCostId(Long.valueOf(costId));
				reOffset.setOffsetMoney(offsetMoney);
				hyPaymentOffsetMapper.insertHyPaymentOffset(reOffset);
			} else {//冲抵已有该条记录  修改操作
				HyPaymentOffset reOffset = new HyPaymentOffset();
				reOffset = (HyPaymentOffset) Constants.REFLECT_UTIL.convertBean(new HyPaymentOffset(), hyPaymentOffset);
				HyPaymentOffset hyPaymentOffsets = paymentOffsetList.get(0);
				String offsetDate = "";
				BigDecimal offsetMoney = new BigDecimal(0.00);
				String payFeeDate = hyPaymentOffsets.getOffsetDate();
				if (hyPaymentOffset.getOffsetYear() != null && !"".equals(hyPaymentOffset.getOffsetYear())) {
					int m = Integer.valueOf(hyPaymentOffset.getOffsetYear());
					String a = payFeeDate.split("-")[1];
					String b = payFeeDate.split("-")[0];
					String c = payFeeDate.split("-")[2];
					int n = Integer.parseInt(a);
					int y = Integer.parseInt(b);
					String z = y + m + "";
					offsetDate = z + "-0" + n + "-" + c;
					HyCost hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
					HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
					BigDecimal amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
							hyCost.getCalculationMehod(), hyHouseInf.getBilingArea());
					offsetMoney = hyPaymentOffsets.getOffsetMoney().add(amountReceivable.multiply(new BigDecimal(m)));
					if (hyPaymentOffset.getOffsetMonth() != null && !"".equals(hyPaymentOffset.getOffsetMonth())) {
						m = Integer.valueOf(hyPaymentOffset.getOffsetMonth());
						int w = Integer.valueOf(hyPaymentOffset.getOffsetYear());
						hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
						hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
						amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
								hyCost.getCalculationMehod(), hyHouseInf.getBilingArea());
						BigDecimal amountReceivableByMonth = ReceivableUtil.getReceivable(
								hyCost.getCalculationStandard(), hyCost.getCalculationMehod(),
								hyHouseInf.getBilingArea(), m + "");
						offsetMoney = hyPaymentOffsets.getOffsetMoney().add(amountReceivable.multiply(new BigDecimal(w)).add(amountReceivableByMonth));
						a = payFeeDate.split("-")[1];
						b = payFeeDate.split("-")[0];
						c = payFeeDate.split("-")[2];
						n = Integer.parseInt(a);
						y = Integer.parseInt(b);
						if (m + n > 12) {
							z = y + 1 + w + "";
							String p = m + n - 12 + "";
							offsetDate = z + "-0" + p + "-" + c;
						} else {
							String p = m + n + "";
							if (Integer.parseInt(p) > 9) {
								z = y + w + "";
								offsetDate = z + "-" + p + "-" + c;
							} else {
								z = y + w + "";
								offsetDate = z + "-0" + p + "-" + c;
							}
						}
					}
				} else if (hyPaymentOffset.getOffsetMonth() != null && !"".equals(hyPaymentOffset.getOffsetMonth())) {
					int m = Integer.valueOf(hyPaymentOffset.getOffsetMonth());
					String a = payFeeDate.split("-")[1];
					String b = payFeeDate.split("-")[0];
					String c = payFeeDate.split("-")[2];
					int n = Integer.parseInt(a);
					int y = Integer.parseInt(b);
					HyCost hyCost = hyCostMapper.selectHyCostById(Long.valueOf(costId));
					HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(hyPaymentOffset.getHouseId());
					BigDecimal amountReceivable = ReceivableUtil.getReceivable(hyCost.getCalculationStandard(),
							hyCost.getCalculationMehod(), hyHouseInf.getBilingArea(), m + "");
					offsetMoney = hyPaymentOffsets.getOffsetMoney().add(amountReceivable);
					if (m + n > 12) {
						String z = y + 1 + "";
						String p = m + n - 12 + "";
						offsetDate = z + "-0" + p + "-" + c;
					} else {
						String p = m + n + "";
						if (Integer.parseInt(p) > 9) {
							offsetDate = b + "-" + p + "-" + c;
						} else {
							offsetDate = b + "-0" + p + "-" + c;
						}
					}
				}
				
				if(hyPaymentOffset.getOffsetYear()!=null&&!"".equals(hyPaymentOffset.getOffsetYear())) {
					int y =Integer.valueOf(hyPaymentOffsets.getOffsetYear())+Integer.valueOf(hyPaymentOffset.getOffsetYear());
					reOffset.setOffsetYear(y+"");
					if(hyPaymentOffset.getOffsetMonth()!=null&&!"".equals(hyPaymentOffset.getOffsetMonth())) {
						if(hyPaymentOffset.getOffsetMonth()!=null&&!"".equals(hyPaymentOffset.getOffsetMonth())) {
							int m = Integer.valueOf(hyPaymentOffsets.getOffsetMonth())+Integer.valueOf(hyPaymentOffset.getOffsetMonth());
							if(m>=12) {
								reOffset.setOffsetMonth(m-12+"");
								reOffset.setOffsetYear(y+1+"");
							}else {
								reOffset.setOffsetMonth(m+"");
							}
						}
						
					}
				}else if(hyPaymentOffset.getOffsetMonth()!=null&&!"".equals(hyPaymentOffset.getOffsetMonth())) {
					if(hyPaymentOffsets.getOffsetYear()!=null&&!"".equals(hyPaymentOffsets.getOffsetYear())) {
						int y =Integer.valueOf(hyPaymentOffsets.getOffsetYear());
						int m = Integer.valueOf(hyPaymentOffsets.getOffsetMonth())+Integer.valueOf(hyPaymentOffset.getOffsetMonth());
						if(m>=12) {
							reOffset.setOffsetMonth(m-12+"");
							reOffset.setOffsetYear(y+1+"");
						}else {
							reOffset.setOffsetMonth(m+"");
						}
					}else {
						int m = Integer.valueOf(hyPaymentOffsets.getOffsetMonth())+Integer.valueOf(hyPaymentOffset.getOffsetMonth());
						if(m>=12) {
							reOffset.setOffsetMonth(m-12+"");
							reOffset.setOffsetYear(1+"");
						}else {
							reOffset.setOffsetMonth(m+"");
						}
					}
				}
				reOffset.setId(hyPaymentOffsets.getId());
				reOffset.setOffsetDate(offsetDate);
				reOffset.setOffsetMoney(offsetMoney);
				hyPaymentOffsetMapper.updateHyPaymentOffset(reOffset);
			}
		}
		return 1;
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