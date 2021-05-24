package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyBillSet;
import com.ruoyi.system.mapper.HyBillSetMapper;
import com.ruoyi.system.service.IHyBillSetService;
import com.ruoyi.system.utils.HyDateUtil;

/**
 * 票据设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyBillSetServiceImpl implements IHyBillSetService {
	@Autowired
	private HyBillSetMapper hyBillSetMapper;

	/**
	 * 查询票据设置
	 * 
	 * @param id 票据设置ID
	 * @return 票据设置
	 */
	@Override
	public HyBillSet selectHyBillSetById(Long id) {
		return hyBillSetMapper.selectHyBillSetById(id);
	}

	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置
	 */
	@Override
	public List<HyBillSet> selectHyBillSetList(HyBillSet hyBillSet) {
		return hyBillSetMapper.selectHyBillSetList(hyBillSet);
		
	}
	
	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置集合
	 */
	/*public List<HyBillSet> selectHyBillSetListByDate(HyBillSet hyBillSet) {
		Map<String, Date> billDateMap = HyDateUtil.getDate(hyBillSet.getBillDate());// 获取转换后billDate时间
		Map<String, Date> billDateMapNew = HyDateUtil.getDate(hyBillSet.getBillDateNew());// 获取转换后billDateNew时间

		Date billDate = null;
		Date startTiem = null;
		Date endTime = null;

		Date billDateNew = null;
		Date startTimeNew = null;
		Date endTimeNew = null;

		if (null == billDateMap.get("startTime") && null == billDateMapNew.get("startTime")) {
			return hyBillSetMapper.selectHyBillSetListOr(hyBillSet);// billDate时间为空并且billDateNew时间为空
		}

		if (null != billDateMap.get("startTime")) {
			billDate = new Date();
			startTiem = billDateMap.get("startTime");
			endTime = billDateMap.get("endTime");
		}

		if (null != billDateMapNew.get("startTime")) {
			billDateNew = new Date();
			startTimeNew = billDateMapNew.get("startTime");
			endTimeNew = billDateMapNew.get("endTime");
		}

		return hyBillSetMapper.selectHyBillSetListByDate(hyBillSet.getBillTypes(), hyBillSet.getBillCategory(),
				hyBillSet.getPrefix(), hyBillSet.getSuffix(), hyBillSet.getDigit(), hyBillSet.getBillSample(),
				hyBillSet.getBillPanel(), hyBillSet.getPanel(), billDate, startTiem, endTime, billDateNew, startTimeNew,
				endTimeNew);
	}*/

	/**
	 * 新增票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyBillSet(HyBillSet hyBillSet) {
		return hyBillSetMapper.insertHyBillSet(hyBillSet);
	}

	/**
	 * 修改票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyBillSet(HyBillSet hyBillSet) {
		return hyBillSetMapper.updateHyBillSet(hyBillSet);
	}

	/**
	 * 删除票据设置对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyBillSetByIds(String ids) {
		return hyBillSetMapper.deleteHyBillSetByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除票据设置信息
	 * 
	 * @param id 票据设置ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyBillSetById(Long id) {
		return hyBillSetMapper.deleteHyBillSetById(id);
	}

}
