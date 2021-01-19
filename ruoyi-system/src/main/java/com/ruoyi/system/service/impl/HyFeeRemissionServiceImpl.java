package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.HyCommonMapper;
import com.ruoyi.system.mapper.HyFeeRemissionMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyMeterCaseMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyParkingInfMapper;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyDataIsExist;
import com.ruoyi.system.domain.HyFeeRemission;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.HyParkingInf;
import com.ruoyi.system.service.IHyDataIsExistService;
import com.ruoyi.system.service.IHyFeeRemissionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 费用减免Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-13
 */
@Service
public class HyFeeRemissionServiceImpl implements IHyFeeRemissionService {
	@Autowired
	private HyFeeRemissionMapper hyFeeRemissionMapper;

	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;

	@Autowired
	private HyMeterMapper hyMeterMapper;

	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;

	@Autowired
	private HyParkingInfMapper hyParkingInfMapper;
	
	@Autowired
	private HyCommonMapper hyCommonMapper;
	
	/**
	 * 查询费用减免
	 * 
	 * @param id 费用减免ID
	 * @return 费用减免
	 */
	@Override
	public HyFeeRemission selectHyFeeRemissionById(Long id) {
		return hyFeeRemissionMapper.selectHyFeeRemissionById(id);
	}

	/**
	 * 查询费用减免列表
	 * 
	 * @param hyFeeRemission 费用减免
	 * @return 费用减免
	 */
	@Override
	public List<HyFeeRemission> selectHyFeeRemissionList(HyFeeRemission hyFeeRemission) {
		return hyFeeRemissionMapper.selectHyFeeRemissionList(hyFeeRemission);
	}

	/**
	 * 新增费用减免
	 * 
	 * @param hyFeeRemission 费用减免
	 * @return 结果
	 */
	@Override
	public int insertHyFeeRemission(HyFeeRemission hyFeeRemission) {
		String hy=hyCommonMapper.selectNextValue("hy_database","hy_fee_remission");
		hyFeeRemission.setId(Long.valueOf(hy));
	
		HyOwnerRegistration hyOwnerRegistration = new HyOwnerRegistration();
		hyOwnerRegistration.setHouseNum(String.valueOf(hyFeeRemission.getId()));
		hyOwnerRegistration.setOwnerName(hyFeeRemission.getHyOwnerRegistration().getOwnerName());
		hyOwnerRegistrationMapper.insertHyOwnerRegistration((HyOwnerRegistration) Constants.REFLECT_UTIL
				.convertBean(hyOwnerRegistration, hyFeeRemission.getHyOwnerRegistration()));

		HyHouseInf hyHouseInf = new HyHouseInf();
		hyHouseInf.setHouseNumber(String.valueOf(hyFeeRemission.getId()));
		hyHouseInf.setHouseName(hyFeeRemission.getHouseName());
		hyHouseInfMapper.insertHyHouseInf(hyHouseInf);

		HyParkingInf hyParkingInf = new HyParkingInf();
		hyParkingInf.setHouseNumber(hyHouseInf.getHouseNumber());
		hyParkingInf.setParkingNumber(String.valueOf(hyFeeRemission.getParkingNumber()));
		hyParkingInfMapper.insertHyParkingInf(hyParkingInf);

		HyMeter hyMeter = new HyMeter();
		hyMeter.setHouseNum(hyParkingInf.getHouseNumber());
		hyMeter.setMeterName(hyFeeRemission.getMeterName());
		hyMeterMapper.insertHyMeter(hyMeter);

		return hyFeeRemissionMapper.insertHyFeeRemission(hyFeeRemission);

	}

	/**
	 * 修改费用减免
	 * 
	 * @param hyFeeRemission 费用减免
	 * @return 结果
	 */
	@Override
	public int updateHyFeeRemission(HyFeeRemission hyFeeRemission) {
		
		String hy=hyCommonMapper.selectNextValue("hy_database","hy_fee_remission");
		hyFeeRemission.setId(Long.valueOf(hy));
	
		HyOwnerRegistration hyOwnerRegistration = new HyOwnerRegistration();
		hyOwnerRegistration.setHouseNum(String.valueOf(hyFeeRemission.getId()));
		hyOwnerRegistration.setOwnerName(hyFeeRemission.getOwnerName());
		hyOwnerRegistrationMapper.insertHyOwnerRegistration((HyOwnerRegistration) Constants.REFLECT_UTIL
				.convertBean(hyOwnerRegistration, hyFeeRemission.getHyOwnerRegistration()));

		HyHouseInf hyHouseInf = new HyHouseInf();
		hyHouseInf.setHouseNumber(String.valueOf(hyFeeRemission.getId()));
		hyHouseInf.setHouseName(hyFeeRemission.getHouseName());
		hyHouseInfMapper.insertHyHouseInf(hyHouseInf);

		HyParkingInf hyParkingInf = new HyParkingInf();
		hyParkingInf.setHouseNumber(hyHouseInf.getHouseNumber());
		hyParkingInf.setParkingNumber(String.valueOf(hyFeeRemission.getParkingNumber()));
		hyParkingInfMapper.insertHyParkingInf(hyParkingInf);

		HyMeter hyMeter = new HyMeter();
		hyMeter.setHouseNum(hyParkingInf.getHouseNumber());
		hyMeter.setMeterName(hyFeeRemission.getMeterName());
		hyMeterMapper.insertHyMeter(hyMeter);

		
		return hyFeeRemissionMapper.updateHyFeeRemission(hyFeeRemission);
	}

	/**
	 * 删除费用减免对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHyFeeRemissionByIds(String ids) {
		return hyFeeRemissionMapper.deleteHyFeeRemissionByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除费用减免信息
	 * 
	 * @param id 费用减免ID
	 * @return 结果
	 */
	@Override
	public int deleteHyFeeRemissionById(Long id) {
		return hyFeeRemissionMapper.deleteHyFeeRemissionById(id);
	}
}
