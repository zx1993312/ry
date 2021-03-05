package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyBusiness;

/**
 * 商家Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-05
 */
public interface HyBusinessMapper {
	/**
	 * 查询商家
	 * 
	 * @param id 商家ID
	 * @return 商家
	 */
	public HyBusiness selectHyBusinessById(Long id);

	/**
	 * 查询商家列表
	 * 
	 * @param hyBusiness 商家
	 * @return 商家集合
	 */
	public List<HyBusiness> selectHyBusinessList(HyBusiness hyBusiness);

	/**
	 * 查询商家列表
	 * 
	 * @param hyBusiness 商家
	 * @return 商家集合
	 */
	public List<HyBusiness> selectHyselectHyBusinessDistinct(HyBusiness hyBusiness);

	/**
	 * 新增商家
	 * 
	 * @param hyBusiness 商家
	 * @return 结果
	 */
	public int insertHyBusiness(HyBusiness hyBusiness);

	/**
	 * 修改商家
	 * 
	 * @param hyBusiness 商家
	 * @return 结果
	 */
	public int updateHyBusiness(HyBusiness hyBusiness);

	/**
	 * 删除商家
	 * 
	 * @param id 商家ID
	 * @return 结果
	 */
	public int deleteHyBusinessById(Long id);

	/**
	 * 批量删除商家
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyBusinessByIds(String[] ids);
}
