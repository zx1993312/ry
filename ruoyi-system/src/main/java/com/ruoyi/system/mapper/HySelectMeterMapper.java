package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HySelectMeter;

/**
 * 房间表mapper
 * 
 * @author Administrator
 *
 */
public interface HySelectMeterMapper {

	/**
	 * 根据id查询房间表
	 * 
	 * @param id
	 * @return
	 */
	public HySelectMeter selectHySelMeter(Long id);

	/**
	 * 查询房间表列表
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
	 * 批量删除房间表
	 * 
	 * @param strArray
	 * @return
	 */
	public int delectHySelMeterByIds(String[] strArray);

	/**
	 * 删除房间表
	 * 
	 * @param id
	 * @return
	 */
	public int deleteHySelMeterById(Long id);

	public List<HySelectMeter> selectHySelMeterOr(HySelectMeter hySelectMeter);

}
