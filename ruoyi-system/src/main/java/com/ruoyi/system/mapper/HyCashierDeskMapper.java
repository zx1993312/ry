package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.HyCost;

/**
 * 收银台Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface HyCashierDeskMapper {
	/**
	 * 查询收银台
	 * 
	 * @param id 收银台ID
	 * @return 收银台
	 */
	public HyCost selectHyCashierDeskById(Long id);

	/**
	 * 查询收银台列表
	 * 
	 * @param hyCost 收银台
	 * @return 收银台集合
	 */
	public List<HyCost> selectHyCashierDeskList(HyCost hyCost);

	/**
	 * 根据已支付未支付查询收银台列表
	 * 
	 * @param hyCost 收银台
	 * @return 收银台集合
	 */
	public List<HyCost> selectHyCashierDeskListByIsCollection(HyCost hyCost);

	/**
	 * 根据已支付未支付查询收银台列表
	 * 
	 * @param hyCost 收银台
	 * @return 收银台集合
	 */
	public List<HyCost> selectHyReportDataCollection(@Param("houseNumber") String houseNumber,
			@Param("ownerId") Long ownerId);

	/**
	 * 修改收银台
	 * 
	 * @param hyCost 收银台
	 * @return 结果
	 */
	public int updateHyCashierDesk(HyCost hyCost);

}
