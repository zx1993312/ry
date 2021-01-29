package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyVatAuditMapper;
import com.ruoyi.system.domain.HyVatAudit;
import com.ruoyi.system.service.IHyVatAuditService;
import com.ruoyi.common.core.text.Convert;

/**
 * 增值税率审核Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyVatAuditServiceImpl implements IHyVatAuditService {
	@Autowired
	private HyVatAuditMapper hyVatAuditMapper;

	/**
	 * 查询增值税率审核
	 * 
	 * @param id 增值税率审核ID
	 * @return 增值税率审核
	 */
	@Override
	public HyVatAudit selectHyVatAuditById(Long id) {
		return hyVatAuditMapper.selectHyVatAuditById(id);
	}

	/**
	 * 查询增值税率审核列表
	 * 
	 * @param hyVatAudit 增值税率审核
	 * @return 增值税率审核
	 */
	@Override
	public List<HyVatAudit> selectHyVatAuditList(HyVatAudit hyVatAudit) {
		return hyVatAuditMapper.selectHyVatAuditList(hyVatAudit);
	}

	/**
	 * 新增增值税率审核
	 * 
	 * @param hyVatAudit 增值税率审核
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyVatAudit(HyVatAudit hyVatAudit) {
		return hyVatAuditMapper.insertHyVatAudit(hyVatAudit);
	}

	/**
	 * 修改增值税率审核
	 * 
	 * @param hyVatAudit 增值税率审核
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyVatAudit(HyVatAudit hyVatAudit) {
		return hyVatAuditMapper.updateHyVatAudit(hyVatAudit);
	}

	/**
	 * 删除增值税率审核对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyVatAuditByIds(String ids) {
		return hyVatAuditMapper.deleteHyVatAuditByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除增值税率审核信息
	 * 
	 * @param id 增值税率审核ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyVatAuditById(Long id) {
		return hyVatAuditMapper.deleteHyVatAuditById(id);
	}
}
