package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyFeeRemission;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.HyParkingInf;
import com.ruoyi.system.mapper.HyFeeRemissionMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyParkingInfMapper;
import com.ruoyi.system.service.IHyFeeRemissionService;

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
	@Transactional(rollbackFor = Exception.class)
	public int insertHyFeeRemission(HyFeeRemission hyFeeRemission) {
		return hyFeeRemissionMapper.insertHyFeeRemission(hyFeeRemission);

	}

	/**
	 * 修改费用减免
	 * 
	 * @param hyFeeRemission 费用减免
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyFeeRemission(HyFeeRemission hyFeeRemission) {
		hyFeeRemission.setRegistrationMark(1);// 将减免登记标识设置为1
		int result = hyFeeRemissionMapper.updateHyFeeRemission(hyFeeRemission);

		HyOwnerRegistration hyOwnerRegistration = new HyOwnerRegistration();
		hyOwnerRegistration.setHouseNum(hyFeeRemission.getHouseNumber());
		List<?> ownerList = hyOwnerRegistrationMapper.selectHyOwnerRegistrationListOrr(hyOwnerRegistration);// 根据houseNum查询数据是否存在
		hyOwnerRegistration.setOwnerName(hyFeeRemission.getOwnerName());
		if (StringUtils.isNull(ownerList) || ownerList.size() == 0) {// 数据存在，插入新数据
			result = hyOwnerRegistrationMapper.insertHyOwnerRegistration(hyOwnerRegistration);
		} else {
			result = hyOwnerRegistrationMapper.updateHyOwnerRegistrationByHouseNumber(hyOwnerRegistration);
		}

		HyHouseInf hyHouseInf = new HyHouseInf();
		hyHouseInf.setHouseNumber(hyFeeRemission.getHouseNumber());
		List<?> houseList = hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
		hyHouseInf.setHouseName(hyFeeRemission.getHouseName());
		if (StringUtils.isNull(houseList) || houseList.size() == 0) {
			result = hyHouseInfMapper.insertHyHouseInf(hyHouseInf);
		} else {
			result = hyHouseInfMapper.updateHyHouseInfByHouseNumber(hyHouseInf);
		}

		HyParkingInf hyParkingInf = new HyParkingInf();
		hyParkingInf.setParkingNumber(String.valueOf(hyFeeRemission.getParkingNumber()));
		List<?> parkingList = hyParkingInfMapper.selectHyParkingInfList(hyParkingInf);
		hyParkingInf.setHouseNumber(hyFeeRemission.getHouseNumber());
		if (StringUtils.isNull(parkingList) || parkingList.size() == 0) {
			result = hyParkingInfMapper.insertHyParkingInf(hyParkingInf);
		} else {
			result = hyParkingInfMapper.updateHyParkingInfByHouseNumber(hyParkingInf);
		}

		HyMeter hyMeter = new HyMeter();
		hyMeter.setHouseNum(hyFeeRemission.getHouseNumber());
		List<?> meterList = hyMeterMapper.selectHyMeter(hyMeter);
		hyMeter.setMeterName(hyFeeRemission.getMeterName());
		if (StringUtils.isNull(meterList) || meterList.size() == 0) {
			result = hyMeterMapper.insertHyMeter(hyMeter);
		} else {
			result = hyMeterMapper.updateHyMeterByHouseNumber(hyMeter);
		}

		return result;
	}

	/**
	 * 删除费用减免对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyFeeRemissionByIds(String ids) {
		String[] idss = Convert.toStrArray(ids);
		for (String id : idss) {
			HyFeeRemission hyFeeRemission = hyFeeRemissionMapper.selectHyFeeRemissionById(Long.valueOf(id));
			hyOwnerRegistrationMapper
					.deleteHyOwnerRegistrationByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
			hyHouseInfMapper.deleteHyHouseInfByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
			hyParkingInfMapper.deleteHyParkingInfByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
			hyMeterMapper.deleteHyMeterByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
		}
		return hyFeeRemissionMapper.deleteHyFeeRemissionByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除费用减免信息
	 * 
	 * @param id 费用减免ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyFeeRemissionById(Long id) {
		int result = hyFeeRemissionMapper.deleteHyFeeRemissionById(id);
		HyFeeRemission hyFeeRemission = hyFeeRemissionMapper.selectHyFeeRemissionById(Long.valueOf(id));
		result = hyOwnerRegistrationMapper
				.deleteHyOwnerRegistrationByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
		result = hyHouseInfMapper.deleteHyHouseInfByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
		result = hyParkingInfMapper.deleteHyParkingInfByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
		result = hyMeterMapper.deleteHyMeterByHoserNumber(Long.valueOf(hyFeeRemission.getHouseNumber()));
		return result;
	}
}
