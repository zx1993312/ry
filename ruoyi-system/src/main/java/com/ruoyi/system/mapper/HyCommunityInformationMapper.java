package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunityInformation;

/**
 * 社区咨询Mapper接口
 * 
 * @author Administrator
 *@data 2021-03-13
 */
public interface HyCommunityInformationMapper {

	/**
	 * 查询社区咨询
	 * @param id 社区咨询id
	 * @return 社区咨询
	 */
	public HyCommunityInformation selectHyCommunityInformationById(Long id);
	/**
	 * 
	 * 查询社区咨询列表
	 * @param hyCommunityInformation 社区咨询
	 * @return 社区咨询集合
	 */
	public List<HyCommunityInformation> selectHyCommunityInformationList(HyCommunityInformation hyCommunityInformation);
	/**
	 * 新增社区咨询
	 * @param hyCommunityInformation 社区咨询
	 * @return 结构
	 */
	public int insertHyCommunityInformation(HyCommunityInformation hyCommunityInformation);
	/**
	 * 修改社区咨询
	 * @param hyCommunityInformation 社区咨询
	 * @return 结果
	 */
	public int updateHyCommunityInformation(HyCommunityInformation hyCommunityInformation);
	/**
	 * 删除社区咨询
	 * @param id 社区咨询id
	 * @return 结果
	 */
	public int deleteHyCommunityInformationById(Long id);
	/**
	 * 批量删除社区咨询
	 * @param ids 需要删除的数据id
	 * @return 结果
	 */
	public int deleteHyCommunityInformationByIds(String[] ids); 
	
	
	
	
}
