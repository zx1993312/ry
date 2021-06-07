package com.ruoyi.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;

/**
 * 前台收费Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyFrontDeskService {
	/**
	 * 查询前台收费
	 * 
	 * @param id 前台收费ID
	 * @return 前台收费
	 */
	public HyCost selectHyCostById(Long id);

	/**
	 * 查询前台收费列表
	 * 
	 * @param hyCost 前台收费
	 * @return 前台收费集合
	 */
	public List<HyCost> selectHyCostList(HyCost hyCost);


	/**
	 * 新增前台收费
	 * 
	 * @param hyCost 前台收费
	 * @return 结果
	 */
	public int insertHyCost(HyCost hyCost);

	/**
	 * 修改前台收费
	 * 
	 * @param hyCost 前台收费
	 * @return 结果
	 */
	public int updateHyCost(HyCost hyCost);

	/**
	 * 批量删除前台收费
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyCostByIds(String ids);

	/**
	 * 删除前台收费信息
	 * 
	 * @param id 前台收费ID
	 * @return 结果
	 */
	public int deleteHyCostById(Long id);
	/**
   	 * 导出PDF
   	 * @param response
   	 * @throws Exception 
   	 */
	public int downloadPDF(HyCollection hyCollection, HttpServletResponse response)throws Exception;

}
