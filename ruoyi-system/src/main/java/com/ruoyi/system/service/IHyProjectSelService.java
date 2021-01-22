package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyProjectSel;

/**
 * 项目收费比例Service接口
 * 
 * @author Administrator
 *
 */
public interface IHyProjectSelService {

	/**
	 * 查询项目收费比例列表
	 * 
	 * @param hyProjectSel
	 * @return
	 */
	public List<HyProjectSel>  selectProjectSelList(HyProjectSel hyProjectSel);

}
