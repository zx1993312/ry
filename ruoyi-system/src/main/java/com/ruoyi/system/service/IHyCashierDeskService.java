package com.ruoyi.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.HyCost;

/**
 * 收银台Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyCashierDeskService {
	/**
	 * 查询收银台
	 * 
	 * @param id 收银台ID
	 * @return 收银台
	 */
	public HyCost selectHyCashierDeskById(Long id);

	/**
	 * 查询收银台列表
	 * 
	 * @param hyCost 收银台
	 * @return 收银台集合
	 */
	public List<HyCost> selectHyCashierDeskList(HyCost hyCost);

	/**
	 * 修改收银台
	 * 
	 * @param hyCost 收银台
	 * @return 结果
	 */
	public int updateHyCashierDesk(HyCost hyCost);
	/**
	 * 打印收据
	 * @param response
	 * @return
	 */
	public int printReceipt(HttpServletResponse response)throws Exception;
	/**
	 * 打印催收单
	 * @param response
	 * @return
	 */
	public int printCollection(HttpServletResponse response)throws Exception;

}
