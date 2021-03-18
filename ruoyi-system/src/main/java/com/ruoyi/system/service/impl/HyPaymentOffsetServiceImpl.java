package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyPaymentOffset;
import com.ruoyi.system.mapper.HyPaymentOffsetMapper;
import com.ruoyi.system.service.IHyPaymentOffsetService;

/**
 * 预交冲抵Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-25
 */
@Service
public class HyPaymentOffsetServiceImpl implements IHyPaymentOffsetService {
	@Autowired
	private HyPaymentOffsetMapper hyPaymentOffsetMapper;

	/**
	 * 查询预交冲抵
	 * 
	 * @param id 预交冲抵ID
	 * @return 预交冲抵
	 */
	@Override
	public HyPaymentOffset selectHyPaymentOffsetById(Long id) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetById(id);
	}

	/**
	 * 查询预交冲抵列表
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 预交冲抵
	 */
	@Override
	public List<HyPaymentOffset> selectHyPaymentOffsetList(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.selectHyPaymentOffsetList(hyPaymentOffset);
	}

	public List<?> selectHyPaymentOffsetListTy(Date startFeeDate, Date endFeeDate, String auditStatus) {
		if (null == startFeeDate && null == endFeeDate && auditStatus.equals("")) {
			HyPaymentOffset hyPaymentOffset = new HyPaymentOffset();
			return hyPaymentOffsetMapper.selectHyPaymentOffsetList(hyPaymentOffset);
		}
		List<?> list = hyPaymentOffsetMapper.selectHyPaymentOffsetListTy(startFeeDate, endFeeDate, auditStatus);
		return list;

	}

	/**
	 * 新增预交冲抵
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.insertHyPaymentOffset(hyPaymentOffset);
	}

	/**
	 * 修改预交冲抵
	 * 
	 * @param hyPaymentOffset 预交冲抵
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		return hyPaymentOffsetMapper.updateHyPaymentOffset(hyPaymentOffset);
	}

	/**
	 * 删除预交冲抵对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyPaymentOffsetByIds(String ids) {
		return hyPaymentOffsetMapper.deleteHyPaymentOffsetByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除预交冲抵信息
	 * 
	 * @param id 预交冲抵ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyPaymentOffsetById(Long id) {
		return hyPaymentOffsetMapper.deleteHyPaymentOffsetById(id);
	}
}
