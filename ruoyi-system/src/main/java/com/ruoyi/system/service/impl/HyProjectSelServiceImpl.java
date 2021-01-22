package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyProjectSel;
import com.ruoyi.system.mapper.HyProjectSelMapper;
import com.ruoyi.system.service.IHyProjectSelService;

/**
 * 项目收费比例Service实现类
 * 
 * @author Administrator
 *
 */
@Service
public class HyProjectSelServiceImpl implements IHyProjectSelService {

	@Autowired
	private HyProjectSelMapper hyProjectMapper;// 注入mapper

	/**
	 * 查询项目收费比例
	 */
	@Override
	public List<HyProjectSel> selectProjectSelList(HyProjectSel hyProjectSel) {
		return  hyProjectMapper.selectProjectSelList(hyProjectSel);
	}

}
