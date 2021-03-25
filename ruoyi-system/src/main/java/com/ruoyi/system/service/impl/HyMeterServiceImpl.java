package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyControlSet;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.mapper.HyMeterCaseMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.service.IHyMeterService;

/**
 * 抄设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Service
public class HyMeterServiceImpl implements IHyMeterService {
	@Autowired
	private HyMeterMapper hyMeterMapper;

	@Autowired
	private HyMeterCaseMapper hyMeterCaseMapper;

	/**
	 * 查询抄设置
	 * 
	 * @param id 抄设置ID
	 * @return 抄设置
	 */
	@Override
	public HyMeter selectHyMeterById(Long id) {
		return hyMeterMapper.selectHyMeterById(id);
	}

	/**
	 * 查询抄设置列表
	 * 
	 * @param hyMeter 抄设置
	 * @return 抄设置
	 */
	@Override
	public List<HyMeter> selectHyMeterList(HyMeter hyMeter) {
	
			return hyMeterMapper.selectHyMeterList(hyMeter);
		
	}
	/**查询抄表*/
	@Override
	public List<HyMeter> selectHyMeterCase(HyMeter hyMeter) {
		return hyMeterMapper.selectHyMeterCase(hyMeter);
	}
		/**查询抄表和表箱全部*/
	@Override
	public List<HyMeter> selectHyMeterListOr(HyMeter hyMeter) {
		return hyMeterMapper.selectHyMeterListOr(hyMeter);
	}
/**查询抄表和表箱列表*/
	@Override
	public List<HyMeter> selectHyMeter(HyMeter hyMeter) {
		return hyMeterMapper.selectHyMeter(hyMeter);
	}

	/**
	 * 新增抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyMeter(HyMeter hyMeter) {
		return hyMeterMapper.insertHyMeter(hyMeter);
	}

	/**
	 * 修改抄设置
	 * 
	 * @param hyMeter 抄设置
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyMeter(HyMeter hyMeter) {
		return hyMeterMapper.updateHyMeter(hyMeter);
	}

	/**
	 * 删除抄设置对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyMeterByIds(String ids) {
		int delMeterResult = hyMeterMapper.deleteHyMeterByIds(Convert.toStrArray(ids));
		int delCaseResult = hyMeterCaseMapper.deleteHyMeterCaseByIds(Convert.toStrArray(ids));
		if (delMeterResult > 0 || delCaseResult > 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * 删除抄设置信息
	 * 
	 * @param id 抄设置ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyMeterById(Long id) {
		int result = hyMeterMapper.deleteHyMeterById(id);
		if (result > 0) {
			result = hyMeterCaseMapper.deleteHyMeterCaseById(id);
		}
		return result;
	}

	

	@Override
	public String importMeter(List<HyMeter> userList, boolean updateSupport, String operName) {


		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入抄表数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyMeter hyMeter : userList) {
			List<HyMeter> dataList = this.selectHyMeter(hyMeter);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyMeter.getMeterSerialNum()) || StringUtils.isNull(hyMeter.getMeterName())
					|| StringUtils.isNull(hyMeter.getMeterType())
					|| StringUtils.isNull(hyMeter.getInitialRead())|| StringUtils.isNull(hyMeter.getAbnormalPrompt()))
					 {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyMeter(hyMeter);
				successNum++;
				successMsg.append("<br/>" + successNum + "、表计序号 " + hyMeter.getMeterSerialNum() + " 导入成功");
			} else if (updateSupport) {
				hyMeter.setId(dataList.get(0).getId());
				this.updateHyMeter(hyMeter);
				successNum++;
				successMsg.append("<br/>" + successNum + "、表计序号" + hyMeter.getMeterSerialNum() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、表计序号" + hyMeter.getMeterSerialNum() + " 已存在");
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
