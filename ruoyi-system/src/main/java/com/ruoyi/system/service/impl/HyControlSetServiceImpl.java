package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyControlSetMapper;
import com.ruoyi.system.domain.HyControlSet;
import com.ruoyi.system.service.IHyControlSetService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;

/**
 * 管控模型设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-07
 */
@Service
public class HyControlSetServiceImpl implements IHyControlSetService 
{
    @Autowired
    private HyControlSetMapper hyControlSetMapper;

    /**
     * 查询管控模型设置
     * 
     * @param id 管控模型设置ID
     * @return 管控模型设置
     */
    @Override
    public HyControlSet selectHyControlSetById(Long id)
    {
        return hyControlSetMapper.selectHyControlSetById(id);
    }

    /**
     * 查询管控模型设置列表
     * 
     * @param hyControlSet 管控模型设置
     * @return 管控模型设置
     */
    @Override
    public List<HyControlSet> selectHyControlSetList(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.selectHyControlSetList(hyControlSet);
    }

    /**
     * 新增管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyControlSet(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.insertHyControlSet(hyControlSet);
    }

    /**
     * 修改管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyControlSet(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.updateHyControlSet(hyControlSet);
    }

    /**
     * 删除管控模型设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyControlSetByIds(String ids)
    {
        return hyControlSetMapper.deleteHyControlSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除管控模型设置信息
     * 
     * @param id 管控模型设置ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyControlSetById(Long id)
    {
        return hyControlSetMapper.deleteHyControlSetById(id);
    }

	@Override
	public String importOwnerRegistration(List<HyControlSet> userList, boolean updateSupport, String operName) {

		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入楼宇数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyControlSet hyControlSet : userList) {
			List<HyControlSet> dataList = this.selectHyControlSetList(hyControlSet);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyControlSet.getChargeSubjectApproved()) || StringUtils.isNull(hyControlSet.getDeliveryEffectiveTime())
					|| StringUtils.isNull(hyControlSet.getDepositArrearsAllowed())
					|| StringUtils.isNull(hyControlSet.getPartialOffsetAllowed())|| StringUtils.isNull(hyControlSet.getSystemTicketnumNot())
					|| StringUtils.isNull(hyControlSet.getOddCarryForward())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyControlSet(hyControlSet);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核 " + hyControlSet.getChargeSubjectApproved() + " 导入成功");
			} else if (updateSupport) {
				hyControlSet.setId(dataList.get(0).getId());
				this.updateHyControlSet(hyControlSet);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核" + hyControlSet.getChargeSubjectApproved() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、收费科目是否需要审核 " + hyControlSet.getChargeSubjectApproved() + " 已存在");
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
