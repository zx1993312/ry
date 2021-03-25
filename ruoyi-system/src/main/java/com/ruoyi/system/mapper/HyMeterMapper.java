package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HyMeter;

/**
 * 抄设置Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-12
 */
public interface HyMeterMapper {
	/**
	 * 查询抄设置
	 * 
	 * @param id 抄设置ID
	 * @return 抄设置
	 */
	public HyMeter selectHyMeterById(Long id);

	/**
	 * 查询抄设置列表
	 * 
	 * @param hyMeter 抄设置
	 * @return 抄设置集合
	 */
	public List<HyMeter> selectHyMeterList(HyMeter hyMeter);
	
	public List<HyMeter> selectHyMeterListOr(HyMeter hyMeter);

	public List<HyMeter> selectHyMeter(HyMeter hyMeter);
	
	public List<HyMeter> selectHyMeterCase(HyMeter hyMeter);

	/**
	 * 新增抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	public int insertHyMeter(HyMeter hyMeter);

	/**
	 * 修改抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	public int updateHyMeter(HyMeter hyMeter);

	/**
	 * 修改抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	public int updateHyMeterByHouseNumber(HyMeter hyMeter);

	/**
	 * 删除抄设置
	 * 
	 * @param id 抄设置ID
	 * @return 结果
	 */
	public int deleteHyMeterById(Long id);

	/**
	 * 删除抄设置
	 * 
	 * @param id 抄设置ID
	 * @return 结果
	 */
	public int deleteHyMeterByHoserNumber(Long id);

	/**
	 * 批量删除抄设置
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyMeterByIds(String[] ids);

}
