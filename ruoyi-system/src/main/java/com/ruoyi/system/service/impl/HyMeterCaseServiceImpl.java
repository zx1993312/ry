package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.MeterAndCase;
import com.ruoyi.system.mapper.HyCommonMapper;
import com.ruoyi.system.mapper.HyMeterCaseMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.service.IHyMeterCaseService;
import com.ruoyi.system.utils.HyDataUtil;
import com.ruoyi.system.utils.HyStringUtil;

/**
 * 箱 Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Service
public class HyMeterCaseServiceImpl implements IHyMeterCaseService {
	@Autowired
	private HyMeterCaseMapper hyMeterCaseMapper;

	@Autowired
	private HyMeterMapper hyMeterMapper;

	@Autowired
	private HyCommonMapper hyCommonMapper;

	/**
	 * 查询箱
	 * 
	 * @param id 箱 ID
	 * @return 箱
	 * 
	 */
	@Override
	public HyMeterCase selectHyMeterCaseById(Long id) {
		return hyMeterCaseMapper.selectHyMeterCaseById(id);
	}

	/**
	 * 查询箱 列表
	 * 
	 * @param hyMeterCase 箱
	 * 
	 * @return 箱
	 * 
	 */
	@Override
	public List<HyMeterCase> selectHyMeterCaseList(HyMeterCase hyMeterCase) {
		return hyMeterCaseMapper.selectHyMeterCaseList(hyMeterCase);
	}

	/**
	 * 新增箱
	 * 
	 * 
	 * @param hyMeterCase 箱
	 * 
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyMeterCase(MeterAndCase meterAndCase) {

		HyMeter hyMeter = new HyMeter();
		HyMeter getHyMeter = (HyMeter) Constants.REFLECT_UTIL.convertBean(hyMeter, meterAndCase);

		HyMeterCase getHyMeterCase = (HyMeterCase) HyDataUtil.setData(HyMeterCase.class,
				HyStringUtil.getString(meterAndCase.getMeterCaseName()),
				HyStringUtil.getString(meterAndCase.getMeterCasePosition()),
				HyStringUtil.getString(meterAndCase.getMeterSerial()));
		String value = hyCommonMapper.selectNextValue("hy_database", "hy_meter");
		getHyMeterCase.setCaseId(Integer.valueOf(value));

		if (hyMeterMapper.insertHyMeter(getHyMeter) >= 1) {
			return hyMeterCaseMapper.insertHyMeterCase(getHyMeterCase);
		}
		return -1;
	}

	/**
	 * 修改箱
	 * 
	 * 
	 * @param hyMeterCase 箱
	 * 
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyMeterCase(HyMeterCase hyMeterCase) {
		return hyMeterCaseMapper.updateHyMeterCase(hyMeterCase);
	}

	/**
	 * 删除箱 对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyMeterCaseByIds(String ids) {
		return hyMeterCaseMapper.deleteHyMeterCaseByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除箱 信息
	 * 
	 * @param id 箱 ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyMeterCaseById(Long id) {
		return hyMeterCaseMapper.deleteHyMeterCaseById(id);
	}
}
