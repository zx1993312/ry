package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyGenerationMapper;
import com.ruoyi.system.service.IHyGenerationService;

/**
 * 账单生成Service业务层处理
 * 
 * @author liutianqi
 * @date 2021-03-19
 */
@Service
public class HyGenerationServiceImpl implements IHyGenerationService {
	@Autowired
	private HyGenerationMapper hyGenerationMapper;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	/**
	 * 查询账单生成
	 * 
	 * @param id 账单生成ID
	 * @return 账单生成
	 */
	@Override
	public HyHouseInf selectHyGenerationById(Long id) {
		return hyGenerationMapper.selectHyGenerationById(id);
	}

	/**
	 * 查询账单生成列表
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 账单生成
	 */
	@Override
	public List<HyHouseInf> selectHyGenerationList(HyHouseInf hyHouseInf) {
		return hyGenerationMapper.selectHyGenerationList(hyHouseInf);
	}

	/**
	 * 新增账单生成
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyGeneration(HyHouseInf hyHouseInf) {
		if (hyHouseInf.getIds() != null && !"".equals(hyHouseInf.getIds())) {// 判定选择没有选择房屋
			if (hyHouseInf.getIds().indexOf(",") != -1) {// 判定选择的房屋不止一个
				if (hyHouseInf.getCostIds().indexOf(",") != -1) {// 判定选择的费用项目不止一个
					String houseId = hyHouseInf.getIds();
					String[] houseIds = houseId.split(",");
					String costId = hyHouseInf.getCostIds();
					String[] costIds = costId.split(",");
					for (String ida : houseIds) {
						for (String ids : costIds) {
							HouseAndCost houseAndCost = new HouseAndCost();
							houseAndCost.setCostId(Long.valueOf(ids));
							houseAndCost.setHouseId(Long.valueOf(ida));
							List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
							if (houseAndList.size() == 0) {
								Date beginFeeDate = hyHouseInf.getBeginFeeDate();
								Date endFeeDate = hyHouseInf.getEndFeeDate();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String beginFeeDateStr = sdf.format(beginFeeDate);
								String endFeeDateeStr = sdf.format(endFeeDate);
								String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
								houseAndCost.setFeeDate(feeDate);
								if(hyHouseInf.getDiscount()!=null) {
									BigDecimal discount = hyHouseInf.getDiscount();
									houseAndCost.setDiscount(discount);
								}
								hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
							}
						}
					}
					return 1;
				} else {// 判定选择的费用项目只有一个
					String houseId = hyHouseInf.getIds();
					String[] houseIds = houseId.split(",");
					String costId = hyHouseInf.getCostIds();
					for (String ida : houseIds) {
						HouseAndCost houseAndCost = new HouseAndCost();
						houseAndCost.setCostId(Long.valueOf(costId));
						houseAndCost.setHouseId(Long.valueOf(ida));
						List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
						if (houseAndList.size() == 0) {
							Date beginFeeDate = hyHouseInf.getBeginFeeDate();
							Date endFeeDate = hyHouseInf.getEndFeeDate();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String beginFeeDateStr = sdf.format(beginFeeDate);
							String endFeeDateeStr = sdf.format(endFeeDate);
							String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
							houseAndCost.setFeeDate(feeDate);
							if(hyHouseInf.getDiscount()!=null) {
								BigDecimal discount = hyHouseInf.getDiscount();
								houseAndCost.setDiscount(discount);
							}
							hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
						}
					}
					return 1;
				}
			} else {// 判定选择的房屋只有一个
				if (hyHouseInf.getCostIds().indexOf(",") != -1) {// 判定选择的费用项目不止一个
					String houseId = hyHouseInf.getIds();
					String costId = hyHouseInf.getCostIds();
					String[] costIds = costId.split(",");
					for (String ids : costIds) {
						HouseAndCost houseAndCost = new HouseAndCost();
						houseAndCost.setCostId(Long.valueOf(ids));
						houseAndCost.setHouseId(Long.valueOf(houseId));
						List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
						if (houseAndList.size() == 0) {
							Date beginFeeDate = hyHouseInf.getBeginFeeDate();
							Date endFeeDate = hyHouseInf.getEndFeeDate();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String beginFeeDateStr = sdf.format(beginFeeDate);
							String endFeeDateeStr = sdf.format(endFeeDate);
							String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
							houseAndCost.setFeeDate(feeDate);
							if(hyHouseInf.getDiscount()!=null) {
								BigDecimal discount = hyHouseInf.getDiscount();
								houseAndCost.setDiscount(discount);
							}
							hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
						}
					}
					return 1;
				} else {// 判定选择的费用项目只有一个
					String houseId = hyHouseInf.getIds();
					String costId = hyHouseInf.getCostIds();
					HouseAndCost houseAndCost = new HouseAndCost();
					houseAndCost.setCostId(Long.valueOf(costId));
					houseAndCost.setHouseId(Long.valueOf(houseId));
					List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
					if (houseAndList.size() == 0) {
						Date beginFeeDate = hyHouseInf.getBeginFeeDate();
						Date endFeeDate = hyHouseInf.getEndFeeDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String beginFeeDateStr = sdf.format(beginFeeDate);
						String endFeeDateeStr = sdf.format(endFeeDate);
						String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
						houseAndCost.setFeeDate(feeDate);
						if(hyHouseInf.getDiscount()!=null) {
							BigDecimal discount = hyHouseInf.getDiscount();
							houseAndCost.setDiscount(discount);
						}
						hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
					}
					return 1;
				}
			}

		}else if(hyHouseInf.getUnit()!=null&&!"".equals(hyHouseInf.getUnit())){//房屋没选判定选择没选择单元
			if (hyHouseInf.getCostIds().indexOf(",") != -1) {// 判定选择的费用项目不止一个
				HyHouseInf houseInf = new HyHouseInf();
				houseInf.setUnit(hyHouseInf.getUnit());
				List<HyHouseInf> houseInfList = hyGenerationMapper.selectHyGenerationList(houseInf);
				String houseId = "";
				for(HyHouseInf inf : houseInfList) {
					houseId = houseId + inf.getId() + ",";
				}
				String[] houseIds = houseId.split(",");
				String costId = hyHouseInf.getCostIds();
				String[] costIds = costId.split(",");
				for (String ida : houseIds) {
					for (String ids : costIds) {
						HouseAndCost houseAndCost = new HouseAndCost();
						houseAndCost.setCostId(Long.valueOf(ids));
						houseAndCost.setHouseId(Long.valueOf(ida));
						List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
						if (houseAndList.size() == 0) {
							Date beginFeeDate = hyHouseInf.getBeginFeeDate();
							Date endFeeDate = hyHouseInf.getEndFeeDate();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String beginFeeDateStr = sdf.format(beginFeeDate);
							String endFeeDateeStr = sdf.format(endFeeDate);
							String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
							houseAndCost.setFeeDate(feeDate);
							if(hyHouseInf.getDiscount()!=null) {
								BigDecimal discount = hyHouseInf.getDiscount();
								houseAndCost.setDiscount(discount);
							}
							hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
						}
					}
				}
				return 1;
			} else {// 判定选择的费用项目只有一个
				HyHouseInf houseInf = new HyHouseInf();
				houseInf.setUnit(hyHouseInf.getUnit());
				List<HyHouseInf> houseInfList = hyGenerationMapper.selectHyGenerationList(houseInf);
				String houseId = "";
				for(HyHouseInf inf : houseInfList) {
					houseId = houseId + inf.getId() + ",";
				}
				String[] houseIds = houseId.split(",");
				String costId = hyHouseInf.getCostIds();
				for (String ida : houseIds) {
					HouseAndCost houseAndCost = new HouseAndCost();
					houseAndCost.setCostId(Long.valueOf(costId));
					houseAndCost.setHouseId(Long.valueOf(ida));
					List<HouseAndCost> list = hyCustomerMapper.selectCostIds(houseAndCost);
					if (list.size() == 0) {
						Date beginFeeDate = hyHouseInf.getBeginFeeDate();
						Date endFeeDate = hyHouseInf.getEndFeeDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String beginFeeDateStr = sdf.format(beginFeeDate);
						String endFeeDateeStr = sdf.format(endFeeDate);
						String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
						houseAndCost.setFeeDate(feeDate);
						if(hyHouseInf.getDiscount()!=null) {
							BigDecimal discount = hyHouseInf.getDiscount();
							houseAndCost.setDiscount(discount);
						}
						hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
					}
				}
				return 1;
			}
		}else if(hyHouseInf.getBuildingId()!=null){//房屋没选单元没选判定选择没选择楼栋
			if (hyHouseInf.getCostIds().indexOf(",") != -1) {// 判定选择的费用项目不止一个
				HyHouseInf houseInf = new HyHouseInf();
				houseInf.setBuildingId(hyHouseInf.getBuildingId());
				List<HyHouseInf> houseInfList = hyGenerationMapper.selectHyGenerationList(houseInf);
				String houseId = "";
				for(HyHouseInf inf : houseInfList) {
					houseId = houseId + inf.getId() + ",";
				}
				String[] houseIds = houseId.split(",");
				String costId = hyHouseInf.getCostIds();
				String[] costIds = costId.split(",");
				for (String ida : houseIds) {
					for (String ids : costIds) {
						HouseAndCost houseAndCost = new HouseAndCost();
						houseAndCost.setCostId(Long.valueOf(ids));
						houseAndCost.setHouseId(Long.valueOf(ida));
						List<HouseAndCost> houseAndList = hyCustomerMapper.selectCostIds(houseAndCost);
						if (houseAndList.size() == 0) {
							Date beginFeeDate = hyHouseInf.getBeginFeeDate();
							Date endFeeDate = hyHouseInf.getEndFeeDate();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String beginFeeDateStr = sdf.format(beginFeeDate);
							String endFeeDateeStr = sdf.format(endFeeDate);
							String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
							houseAndCost.setFeeDate(feeDate);
							if(hyHouseInf.getDiscount()!=null) {
								BigDecimal discount = hyHouseInf.getDiscount();
								houseAndCost.setDiscount(discount);
							}
							hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
						}
					}
				}
				return 1;
			} else {// 判定选择的费用项目只有一个
				HyHouseInf houseInf = new HyHouseInf();
				houseInf.setBuildingId(hyHouseInf.getBuildingId());
				List<HyHouseInf> houseInfList = hyGenerationMapper.selectHyGenerationList(houseInf);
				String houseId = "";
				for(HyHouseInf inf : houseInfList) {
					houseId = houseId + inf.getId() + ",";
				}
				String[] houseIds = houseId.split(",");
				String costId = hyHouseInf.getCostIds();
				for (String ida : houseIds) {
					HouseAndCost houseAndCost = new HouseAndCost();
					houseAndCost.setCostId(Long.valueOf(costId));
					houseAndCost.setHouseId(Long.valueOf(ida));
					List<HouseAndCost> list = hyCustomerMapper.selectCostIds(houseAndCost);
					if (list.size() == 0) {
						Date beginFeeDate = hyHouseInf.getBeginFeeDate();
						Date endFeeDate = hyHouseInf.getEndFeeDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String beginFeeDateStr = sdf.format(beginFeeDate);
						String endFeeDateeStr = sdf.format(endFeeDate);
						String feeDate = beginFeeDateStr + "-" + endFeeDateeStr;
						houseAndCost.setFeeDate(feeDate);
						if(hyHouseInf.getDiscount()!=null) {
							BigDecimal discount = hyHouseInf.getDiscount();
							houseAndCost.setDiscount(discount);
						}
						hyCustomerMapper.insertHouseAndCostByHouseIdAndCostId(houseAndCost);
					}
				}
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 修改账单生成
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyGeneration(HyHouseInf hyHouseInf) {
		return hyGenerationMapper.updateHyGeneration(hyHouseInf);
	}

}
