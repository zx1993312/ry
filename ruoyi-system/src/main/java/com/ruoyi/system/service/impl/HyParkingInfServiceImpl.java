package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyParkingInf;
import com.ruoyi.system.mapper.HyParkingInfMapper;
import com.ruoyi.system.service.IHyParkingInfService;

/**
 * 车位资料 Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyParkingInfServiceImpl implements IHyParkingInfService {
	@Autowired
	private HyParkingInfMapper hyParkingInfMapper;

	/**
	 * 查询车位资料
	 * 
	 * 
	 * @param id 车位资料 ID
	 * @return 车位资料
	 * 
	 */
	@Override
	public HyParkingInf selectHyParkingInfById(Long id) {
		return hyParkingInfMapper.selectHyParkingInfById(id);
	}

	/**
	 * 查询车位资料 列表
	 * 
	 * @param hyParkingInf 车位资料
	 * 
	 * @return 车位资料
	 * 
	 */
	@Override
	public List<HyParkingInf> selectHyParkingInfList(HyParkingInf hyParkingInf) {
		List<HyParkingInf> list = hyParkingInfMapper.selectHyParkingInfList(hyParkingInf);
		for (HyParkingInf inf : list) {
			System.out.println(inf.toString());
		}
		return list;
	}

	/**
	 * 新增车位资料
	 * 
	 * 
	 * @param hyParkingInf 车位资料
	 * 
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyParkingInf(HyParkingInf hyParkingInf) {
		return hyParkingInfMapper.insertHyParkingInf(hyParkingInf);
	}

	/**
	 * 修改车位资料
	 * 
	 * 
	 * @param hyParkingInf 车位资料
	 * 
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyParkingInf(HyParkingInf hyParkingInf) {
		return hyParkingInfMapper.updateHyParkingInf(hyParkingInf);
	}

	/**
	 * 删除车位资料 对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyParkingInfByIds(String ids) {
		return hyParkingInfMapper.deleteHyParkingInfByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除车位资料 信息
	 * 
	 * @param id 车位资料 ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyParkingInfById(Long id) {
		return hyParkingInfMapper.deleteHyParkingInfById(id);
	}

	@Override
	public String importOwnerRegistration(List<HyParkingInf> userList, boolean updateSupport, String operName) {

		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入楼宇数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyParkingInf hyParkingInf : userList) {
			List<HyParkingInf> dataList = this.selectHyParkingInfList(hyParkingInf);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyParkingInf.getParkingType()) || StringUtils.isNull(hyParkingInf.getParkingProperty())
					|| StringUtils.isNull(hyParkingInf.getParkingName())
					|| StringUtils.isNull(hyParkingInf.getParkingArea())|| StringUtils.isNull(hyParkingInf.getParkingCard())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyParkingInf(hyParkingInf);
				successNum++;
				successMsg.append("<br/>" + successNum + "、业主名称 " + hyParkingInf.getParkingName() + " 导入成功");
			} else if (updateSupport) {
				hyParkingInf.setId(dataList.get(0).getId());
				this.updateHyParkingInf(hyParkingInf);
				successNum++;
				successMsg.append("<br/>" + successNum + "、业主名称 " + hyParkingInf.getParkingName() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、业主名称 " + hyParkingInf.getParkingName() + " 已存在");
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		
		
		
		return  successMsg.toString();
	}


}
