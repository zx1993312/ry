package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyVatAuditMapper;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyVatAudit;
import com.ruoyi.system.service.IHyVatAuditService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;

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

	@Override
	public String importHyVatAudit(List<HyVatAudit> userList, boolean updateSupport, String operName) {

		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入费用项目数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyVatAudit hyVatAudit : userList) {
			List<HyVatAudit> dataList = this.selectHyVatAuditList(hyVatAudit);

			// 判断这些是否为空
			if (StringUtils.isNull(hyVatAudit.getEntryName()) || StringUtils.isNull(hyVatAudit.getTaxScale())
					|| StringUtils.isNull(hyVatAudit.getExpenseAccount())|| StringUtils.isNull(hyVatAudit.getTaxRate())
					|| StringUtils.isNull(hyVatAudit.getTaxRate())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}

			// 查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyVatAudit(hyVatAudit);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核 " + hyVatAudit.getEntryName() + " 导入成功");
			} else if (updateSupport) {
				hyVatAudit.setId(dataList.get(0).getId());
				this.updateHyVatAudit(hyVatAudit);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核" + hyVatAudit.getEntryName() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、收费科目是否需要审核 " + hyVatAudit.getEntryName() + " 已存在");
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}

		return successMsg.toString();
	}

		
}
