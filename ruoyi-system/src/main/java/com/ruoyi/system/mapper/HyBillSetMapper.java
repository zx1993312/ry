package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.HyBillSet;

/**
 * 票据设置Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface HyBillSetMapper {
	/**
	 * 查询票据设置
	 * 
	 * @param id 票据设置ID
	 * @return 票据设置
	 */
	public HyBillSet selectHyBillSetById(Long id);

	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置集合
	 */
	public List<HyBillSet> selectHyBillSetList(HyBillSet hyBillSet);

	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置集合
	 */
	public List<HyBillSet> selectHyBillSetListByDate(@Param("billTypes") String billTypes,
			@Param("billCategory") String billCategory, @Param("prefix") String prefix, @Param("suffix") String suffix,
			@Param("digit") String digit, @Param("billSample") String billSample, @Param("billPanel") String billPanel,
			@Param("panel") String panel, @Param("billDate") Date billDate, @Param("startTime") Date startTiem,
			@Param("endTime") Date endTime, @Param("billDateNew") Date billDateNew,
			@Param("startTimeNew") Date startTimeNew, @Param("endTimeNew") Date endTimeNew);

	/**
	 * 新增票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	public int insertHyBillSet(HyBillSet hyBillSet);

	/**
	 * 修改票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	public int updateHyBillSet(HyBillSet hyBillSet);

	/**
	 * 删除票据设置
	 * 
	 * @param id 票据设置ID
	 * @return 结果
	 */
	public int deleteHyBillSetById(Long id);

	/**
	 * 批量删除票据设置
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyBillSetByIds(String[] ids);
}
