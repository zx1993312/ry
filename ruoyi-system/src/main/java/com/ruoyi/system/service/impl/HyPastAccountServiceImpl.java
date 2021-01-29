package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPastAccountMapper;
import com.ruoyi.system.domain.HyPastAccount;
import com.ruoyi.system.service.IHyPastAccountService;
import com.ruoyi.common.core.text.Convert;

/**
 * 往期应收调账Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-07
 */
@Service
public class HyPastAccountServiceImpl implements IHyPastAccountService {
	@Autowired
	private HyPastAccountMapper hyPastAccountMapper;

	/**
	 * 查询往期应收调账
	 * 
	 * @param id 往期应收调账ID
	 * @return 往期应收调账
	 */
	@Override
	public HyPastAccount selectHyPastAccountById(Long id) {
		return hyPastAccountMapper.selectHyPastAccountById(id);
	}

	/**
	 * 查询往期应收调账列表
	 * 
	 * @param hyPastAccount 往期应收调账
	 * @return 往期应收调账
	 */
	@Override
	public List<HyPastAccount> selectHyPastAccountList(HyPastAccount hyPastAccount) {
		return hyPastAccountMapper.selectHyPastAccountList(hyPastAccount);
	}

	/**
	 * 新增往期应收调账
	 * 
	 * @param hyPastAccount 往期应收调账
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyPastAccount(HyPastAccount hyPastAccount) {
		return hyPastAccountMapper.insertHyPastAccount(hyPastAccount);
	}

	/**
	 * 修改往期应收调账
	 * 
	 * @param hyPastAccount 往期应收调账
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyPastAccount(HyPastAccount hyPastAccount) {
		return hyPastAccountMapper.updateHyPastAccount(hyPastAccount);
	}

	/**
	 * 删除往期应收调账对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyPastAccountByIds(String ids) {
		return hyPastAccountMapper.deleteHyPastAccountByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除往期应收调账信息
	 * 
	 * @param id 往期应收调账ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyPastAccountById(Long id) {
		return hyPastAccountMapper.deleteHyPastAccountById(id);
	}
}
