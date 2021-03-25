package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.service.IHyOwnerRegistrationService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;

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

	@Override
	public List<HyOwnerRegistration> selectHyOwnerRegistrationListOr(HyOwnerRegistration hyOwnerRegistration) {
		
		return hyOwnerRegistrationMapper.selectHyOwnerRegistrationListOr(hyOwnerRegistration);
	}

	@Override
	public List<HyOwnerRegistration> selectHyOwnerRegistrationListOrr(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationMapper.selectHyOwnerRegistrationListOrr(hyOwnerRegistration);
	}

	
	/**
	 * 
	 */
	@Override
	public String importOwnerRegistration(List<HyOwnerRegistration> hyOwnerRegistrationList, boolean updateSupport, String operName) {
		if (StringUtils.isNull(hyOwnerRegistrationList) || hyOwnerRegistrationList.size() == 0) {
			throw new BusinessException("导入楼宇数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyOwnerRegistration hyOwnerRegistration : hyOwnerRegistrationList) {
			List<HyOwnerRegistration> dataList = this.selectHyOwnerRegistrationListOor(hyOwnerRegistration);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyOwnerRegistration.getOwnerName()) || StringUtils.isNull(hyOwnerRegistration.getHouseNum())
					|| StringUtils.isNull(hyOwnerRegistration.getFixedTelephone())
					|| StringUtils.isNull(hyOwnerRegistration.getMobilePhone())|| StringUtils.isNull(hyOwnerRegistration.getIdCardNum())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyOwnerRegistration(hyOwnerRegistration);
				successNum++;
				successMsg.append("<br/>" + successNum + "、业主名称 " + hyOwnerRegistration.getOwnerName() + " 导入成功");
			} else if (updateSupport) {
				hyOwnerRegistration.setId(dataList.get(0).getId());
				this.updateHyOwnerRegistration(hyOwnerRegistration);
				successNum++;
				successMsg.append("<br/>" + successNum + "、业主名称 " + hyOwnerRegistration.getOwnerName() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、业主名称 " + hyOwnerRegistration.getOwnerName() + " 已存在");
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		
		
		return successMsg.toString();
	}

	@Override
	public List<HyOwnerRegistration> selectHyOwnerRegistrationListOor(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationMapper.selectHyOwnerRegistrationListOor(hyOwnerRegistration);
	}
}
