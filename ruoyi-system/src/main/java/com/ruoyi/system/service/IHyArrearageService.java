package com.ruoyi.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.HyHouseInf;

/**
 * 欠费通知Service接口
 * 
 * @author 
 * @date 2021-01-06
 */
public interface IHyArrearageService 
{

    /**
     * 查询欠费通知列表
     * 
     * @param hyHouseInf 欠费通知
     * @return 欠费通知集合
     */
    public List<HyHouseInf> selectHyArrearageList(HyHouseInf hyHouseInf);
    
    /**
	 * 导出PDF
	 * @param response
	 * @throws Exception 
	 */
	public int downloadPDF(String warm,HttpServletResponse response) throws Exception;

}
