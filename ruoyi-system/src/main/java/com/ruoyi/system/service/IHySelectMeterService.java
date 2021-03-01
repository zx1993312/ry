package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HySelectMeter;

/**
 * 房间表查询service
 * 
 * @author Administrator
 *
 */
public interface IHySelectMeterService {

	/**
	 * 根据id查询表房间
	 * 
	 * @param id 抄设置ID
	 * @return 抄设置
	 */
	public HySelectMeter selectHySelMeterById(Long id);

	/**
	 * 查询房间表
	 * 
	 * @param hySelectMeter
	 * @return
	 */
	public List<HySelectMeter> selectHySelMeterList(HySelectMeter hySelectMeter);

	/**
	 * 修改房间表
	 * 
	 * @param hySelectMeter
	 * @return
	 */
	public int updateHySelMeter(HySelectMeter hySelectMeter);

	/**
	 * 添加房间表
	 * 
	 * @param hySelectMeter
	 * @return
	 */
	public int addHySelMeter(HySelectMeter hySelectMeter);

	/**
	 * 删除房间表
	 * 
	 * @param hySelectMeter
	 * @return
	 */
	public int deleteHySelMeterByIds(String ids);

	/**
	 * 删除房间表
	 * 
	 * @param id 抄设置ID
	 * @return 结果
	 */
	public int deleteHySelMeterById(Long id);

	public List<HySelectMeter> selectHySelMeterOr(HySelectMeter hySelectMeter);

}
