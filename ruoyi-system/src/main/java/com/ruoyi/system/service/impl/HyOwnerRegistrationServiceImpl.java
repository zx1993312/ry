package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.service.IHyOwnerRegistrationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 业主资料登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-09
 */
@Service
public class HyOwnerRegistrationServiceImpl implements IHyOwnerRegistrationService {
	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;

	/**
	 * 查询业主资料登记
	 * 
	 * @param id 业主资料登记ID
	 * @return 业主资料登记
	 */
	@Override
	public HyOwnerRegistration selectHyOwnerRegistrationById(Long id) {
		return hyOwnerRegistrationMapper.selectHyOwnerRegistrationById(id);
	}

	/**
	 * 查询业主资料登记列表
	 * 
	 * @param hyOwnerRegistration 业主资料登记
	 * @return 业主资料登记
	 */
	@Override
	public List<HyOwnerRegistration> selectHyOwnerRegistrationList(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationMapper.selectHyOwnerRegistrationList(hyOwnerRegistration);
	}

	/**
	 * 新增业主资料登记
	 * 
	 * @param hyOwnerRegistration 业主资料登记
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationMapper.insertHyOwnerRegistration(hyOwnerRegistration);
	}

	/**
	 * 修改业主资料登记
	 * 
	 * @param hyOwnerRegistration 业主资料登记
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationMapper.updateHyOwnerRegistration(hyOwnerRegistration);
	}

	/**
	 * 删除业主资料登记对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyOwnerRegistrationByIds(String ids) {
		return hyOwnerRegistrationMapper.deleteHyOwnerRegistrationByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除业主资料登记信息
	 * 
	 * @param id 业主资料登记ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyOwnerRegistrationById(Long id) {
		return hyOwnerRegistrationMapper.deleteHyOwnerRegistrationById(id);
	}
}
