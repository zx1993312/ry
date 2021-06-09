package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.mapper.HyCashierDeskMapper;
import com.ruoyi.system.service.IHyCashierDeskService;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyCashierDeskServiceImpl implements IHyCashierDeskService {
	@Autowired
	private HyCashierDeskMapper hyCashierDeskMapper;

	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	@Override
	public HyCost selectHyCashierDeskById(Long id) {
		return hyCashierDeskMapper.selectHyCashierDeskById(id);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCashierDeskList(HyCost hyCost) {
		return hyCashierDeskMapper.selectHyCashierDeskList(hyCost);
	}


	/**
	 * 修改费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	@Override
	public int updateHyCashierDesk(HyCost hyCost) {
		return hyCashierDeskMapper.updateHyCashierDesk(hyCost);
	}

}
