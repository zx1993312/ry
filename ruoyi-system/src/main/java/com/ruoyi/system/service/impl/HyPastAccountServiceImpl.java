package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyPastAccount;
import com.ruoyi.system.mapper.HyPastAccountMapper;
import com.ruoyi.system.service.IHyPastAccountService;

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

	@Override
	public String importCost(List<HyPastAccount> userList, boolean updateSupport, String operName) {

if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入楼宇数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyPastAccount hyPastAccount : userList) {
			List<HyPastAccount> dataList = this.selectHyPastAccountList(hyPastAccount);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyPastAccount.getManageProjects()) || StringUtils.isNull(hyPastAccount.getCustomerName())
					|| StringUtils.isNull(hyPastAccount.getHouseNum())
					|| StringUtils.isNull(hyPastAccount.getParkingNum())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyPastAccount(hyPastAccount);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核 " + hyPastAccount.getManageProjects() + " 导入成功");
			} else if (updateSupport) {
				hyPastAccount.setId(dataList.get(0).getId());
				this.updateHyPastAccount(hyPastAccount);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核" + hyPastAccount.getManageProjects() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、收费科目是否需要审核 " + hyPastAccount.getManageProjects() + " 已存在");
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		
		
		return  successMsg.toString();
	}
}
