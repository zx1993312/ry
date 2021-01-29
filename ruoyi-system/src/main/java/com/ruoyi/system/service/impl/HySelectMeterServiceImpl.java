package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HySelectMeter;
import com.ruoyi.system.mapper.HySelectMeterMapper;
import com.ruoyi.system.service.IHySelectMeterService;

/**
 * IHySelectMeterService实现类
 * 
 * @author Administrator
 *
 */
@Service
public class HySelectMeterServiceImpl implements IHySelectMeterService {

	@Autowired
	private HySelectMeterMapper hySelMeterMapper;

	/**
	 * 根据id查询房间表
	 */
	@Override
	public HySelectMeter selectHySelMeterById(Long id) {
		return hySelMeterMapper.selectHySelMeter(id);
	}

	/**
	 * 查询房间表列表
	 */
	@Override
	public List<HySelectMeter> selectHySelMeterList(HySelectMeter hySelectMeter) {
		return hySelMeterMapper.selectHySelMeterList(hySelectMeter);
	}

	/**
	 * 修改房间表
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHySelMeter(HySelectMeter hySelectMeter) {
		return hySelMeterMapper.updateHySelMeter(hySelectMeter);
	}

	/**
	 * 添加房间表
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int addHySelMeter(HySelectMeter hySelectMeter) {
		return hySelMeterMapper.addHySelMeter(hySelectMeter);
	}

	/**
	 * 删除房间表（批量）
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHySelMeterByIds(String ids) {
		return hySelMeterMapper.delectHySelMeterByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除房间表
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHySelMeterById(Long id) {
		return hySelMeterMapper.deleteHySelMeterById(id);
	}

}
