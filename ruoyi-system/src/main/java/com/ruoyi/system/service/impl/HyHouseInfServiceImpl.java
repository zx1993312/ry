package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.service.IHyHouseInfService;

/**
 * 房屋登记Service业务层处理
 * 
 * @author liutianqi
 * @date 2021-03-19
 */
@Service
public class HyHouseInfServiceImpl implements IHyHouseInfService {
	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;

	/**
	 * 查询房屋登记
	 * 
	 * @param id 房屋登记ID
	 * @return 房屋登记
	 */
	@Override
	public HyHouseInf selectHyHouseInfById(Long id) {
		return hyHouseInfMapper.selectHyHouseInfById(id);
	}

	/**
	 * 查询房屋登记列表
	 * 
	 * @param hyHouseInf 房屋登记
	 * @return 房屋登记
	 */
	@Override
	public List<HyHouseInf> selectHyHouseInfList(HyHouseInf hyHouseInf) {
		return hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
	}

	/**
	 * 新增房屋登记
	 * 
	 * @param hyHouseInf 房屋登记
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyHouseInf(HyHouseInf hyHouseInf) {
		return hyHouseInfMapper.insertHyHouseInf(hyHouseInf);
	}

	/**
	 * 修改房屋登记
	 * 
	 * @param hyHouseInf 房屋登记
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyHouseInf(HyHouseInf hyHouseInf) {
		return hyHouseInfMapper.updateHyHouseInf(hyHouseInf);
	}

	/**
	 * 删除房屋登记对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyHouseInfByIds(String ids) {
		return hyHouseInfMapper.deleteHyHouseInfByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除房屋登记信息
	 * 
	 * @param id 房屋登记ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyHouseInfById(Long id) {
		return hyHouseInfMapper.deleteHyHouseInfById(id);
	}

	/**
	 * 导入房屋登记数据
	 */
	@Override
	public String importHouseInf(List<HyHouseInf> hyHouseInfList, boolean updateSupport, String operName) {
		if (StringUtils.isNull(hyHouseInfList) || hyHouseInfList.size() == 0) {
			throw new BusinessException("导入房屋登记数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyHouseInf hyHouseInf : hyHouseInfList) {
			List<HyHouseInf> dataList = this.selectHyHouseInfList(hyHouseInf);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyHouseInf.getHyBuilding().getBuildingName()) || StringUtils.isNull(hyHouseInf.getHouseNumber())
					|| StringUtils.isNull(hyHouseInf.getHouseName()) || StringUtils.isNull(hyHouseInf.getUnit())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyHouseInf(hyHouseInf);
				successNum++;
				successMsg.append("<br/>" + successNum + "、房屋登记" + hyHouseInf.getHyBuilding().getBuildingName() + " 导入成功");
			} else if (updateSupport) {
				hyHouseInf.setId(dataList.get(0).getId());
				this.updateHyHouseInf(hyHouseInf);
				successNum++;
				successMsg.append("<br/>" + successNum + "、房屋登记 " + hyHouseInf.getHyBuilding().getBuildingName() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、房屋登记 " + hyHouseInf.getHyBuilding().getBuildingName() + " 已存在");
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
}
