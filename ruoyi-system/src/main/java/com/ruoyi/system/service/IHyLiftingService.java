package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyLifting;

/**
 * 提料人Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyLiftingService {
	/**
	 * 查询提料人
	 * 
	 * @param id 提料人ID
	 * @return 提料人
	 */
	public HyLifting selectHyLiftingById(Long id);

	/**
	 * 查询提料人列表
	 * 
	 * @param hyLifting 提料人
	 * @return 提料人集合
	 */
	public List<HyLifting> selectHyLiftingList(HyLifting hyLifting);

	/**
	 * 查询提料待审核列表
	 * 
	 * @param hyLifting 提料人
	 * @return 提料人集合
	 */
	public List<HyLifting> selectHyLiftingListByAudit(HyLifting hyLifting);
	
	/**
	 * 查询提料已通过列表
	 * 
	 * @param hyLifting 提料人
	 * @return 提料人集合
	 */
	public List<HyLifting> selectHyLiftingListByThrough(HyLifting hyLifting);
	
	/**
	 * 查询提料已拒绝列表
	 * 
	 * @param hyLifting 提料人
	 * @return 提料人集合
	 */
	public List<HyLifting> selectHyLiftingListByRefusal(HyLifting hyLifting);
	
	/**
	 * 新增提料人
	 * 
	 * @param hyLifting 提料人
	 * @return 结果
	 */
	public int insertHyLifting(HyLifting hyLifting);

	/**
	 * 修改提料人
	 * 
	 * @param hyLifting 提料人
	 * @return 结果
	 */
	public int updateHyLifting(HyLifting hyLifting);

	/**
	 * 批量删除提料人
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyLiftingByIds(String ids);

	/**
	 * 删除提料人信息
	 * 
	 * @param id 提料人ID
	 * @return 结果
	 */
	public int deleteHyLiftingById(Long id);

	/**
	 * app端添加提料人
	 * 
	 * @param hyLifting
	 * @return
	 */
	public int appAddHyLiftingSave(HyLifting hyLifting);

	
}
