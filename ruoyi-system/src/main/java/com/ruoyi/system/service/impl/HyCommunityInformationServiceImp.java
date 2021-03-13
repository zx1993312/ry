package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyCommunityInformation;
import com.ruoyi.system.mapper.HyCommunityInformationMapper;
import com.ruoyi.system.service.IHyCommunityInformationService;

/**
 * 社区咨询Service业务层处理
 * @author Administrator
 *
 */
@Service
public class HyCommunityInformationServiceImp implements IHyCommunityInformationService{
	@Autowired
	private HyCommunityInformationMapper hyCommunityInformationMapper;
	/**
	 * 查询社区咨询
	 * @param id 社区咨询id
	 * @return 社区咨询
	 */
	@Override
	public HyCommunityInformation selectHyCommunityInformationById(Long id) {
		return hyCommunityInformationMapper.selectHyCommunityInformationById(id);
	}
	/**
	 * 查询社区咨询列表
	 * @param hyCommunityInformation 社区咨询
	 * @return 社区咨询
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public List<HyCommunityInformation> selectHyCommunityInformationList(HyCommunityInformation hyCommunityInformation){
		return hyCommunityInformationMapper.selectHyCommunityInformationList(hyCommunityInformation);
	}
	/**
	 * 新增社区咨询
	 * @param hyCommunityInformation 社区咨询
	 * @return 结果
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int insertHyCommunityInformation(HyCommunityInformation hyCommunityInformation) {
		return hyCommunityInformationMapper.insertHyCommunityInformation(hyCommunityInformation);
	}
	/**
	 * 修改社区咨询
	 * @param hyCommunityInformation 社区咨询
	 * @return 结果
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int updateHyCommunityInformation(HyCommunityInformation hyCommunityInformation) {
		return hyCommunityInformationMapper.updateHyCommunityInformation(hyCommunityInformation);
	}
	/**
	 * 删除社区咨询
	 * @param id 社区咨询id
	 * @return 结果
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int deleteHyCommunityInformationById(Long id) {
		return hyCommunityInformationMapper.deleteHyCommunityInformationById(id);
	}
	/**
	 * 删除社区咨询对象
	 * @param ids 社区咨询id
	 * @return 结果
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int deleteHyCommunityInformationByIds(String ids) {
		return hyCommunityInformationMapper.deleteHyCommunityInformationByIds(Convert.toStrArray(ids));
	}
	
	
	
	
	
	

}
