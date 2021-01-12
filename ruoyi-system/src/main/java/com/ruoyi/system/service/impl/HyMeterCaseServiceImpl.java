package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyMeterCaseMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.MeterAndCase;
import com.ruoyi.system.service.IHyMeterCaseService;
import com.ruoyi.common.core.text.Convert;

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

	/**
	 * 查询箱
	 * 
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
	public int insertHyMeterCase(MeterAndCase meterAndCase) {
		HyMeter hyMeter = new HyMeter();
		hyMeter.setHouseNum(meterAndCase.getHouseNum());
		hyMeter.setMeterType(meterAndCase.getMeterType());
		hyMeter.setMeterSerialNum(meterAndCase.getMeterSerialNum());
		hyMeter.setMeterName(meterAndCase.getMeterName());
		hyMeter.setInitialRead(meterAndCase.getInitialRead());
		hyMeter.setTransfRatio(meterAndCase.getTransfRatio());
		hyMeter.setReverseNot(meterAndCase.getReverseNot());
		hyMeter.setStrappingType(meterAndCase.getStrappingType());
		HyMeterCase hyMeterCase = new HyMeterCase();
		hyMeterCase.setMeterCaseName(meterAndCase.getMeterCaseName());
		hyMeterCase.setMeterCasePosition(meterAndCase.getMeterCasePosition());
		hyMeterCase.setMeterSerial(meterAndCase.getMeterCasePosition());
		if (hyMeterMapper.insertHyMeter(hyMeter) >= 1) {
			return hyMeterCaseMapper.insertHyMeterCase(hyMeterCase);
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
	public int deleteHyMeterCaseById(Long id) {
		return hyMeterCaseMapper.deleteHyMeterCaseById(id);
	}
}
