package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyAdviceChargeMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.service.IHyAdviceChargeService;
import com.ruoyi.system.service.IHyHouseInfService;

/**
 * 缴费通知Service业务层处理
 * 
 * @author 
 * @date 2021-03-19
 */
@Service
public class HyAdviceChargeServiceImpl implements IHyAdviceChargeService {
	@Autowired
	private HyAdviceChargeMapper hyAdviceChargeMapper;

	/**
	 * 查询缴费通知列表
	 * 
	 * @param hyHouseInf 缴费通知
	 * @return 缴费通知
	 */
	@Override
	public List<HyHouseInf> selectHyAdviceChargeList(HyHouseInf hyHouseInf) {
		return hyAdviceChargeMapper.selectHyAdviceChargeList(hyHouseInf);
	}

}
