package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.service.IHyMeterService;

/**
 * 抄设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Service
public class HyMeterServiceImpl implements IHyMeterService {
	@Autowired
	private HyMeterMapper hyMeterMapper;

	/**
	 * 查询抄设置
	 * 
	 * @param id 抄设置ID
	 * @return 抄设置
	 */
	@Override
	public HyMeter selectHyMeterById(Long id) {
		return hyMeterMapper.selectHyMeterById(id);
	}

	/**
	 * 查询抄设置列表
	 * 
	 * @param hyMeter 抄设置
	 * @return 抄设置
	 */
	@Override
	public List<HyMeter> selectHyMeterList(HyMeter hyMeter) {
		return hyMeterMapper.selectHyMeterList(hyMeter);
	}

	/**
	 * 新增抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	@Override
	public int insertHyMeter(HyMeter hyMeter) {
		return hyMeterMapper.insertHyMeter(hyMeter);
	}

	/**
	 * 修改抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	@Override
	public int updateHyMeter(HyMeter hyMeter) {
		return hyMeterMapper.updateHyMeter(hyMeter);
	}

	/**
	 * 删除抄设置对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHyMeterByIds(String ids) {
		return hyMeterMapper.deleteHyMeterByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除抄设置信息
	 * 
	 * @param id 抄设置ID
	 * @return 结果
	 */
	@Override
	public int deleteHyMeterById(Long id) {
		return hyMeterMapper.deleteHyMeterById(id);
	}

}
