package com.ruoyi.system.service;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import com.ruoyi.system.domain.HyCollection;

import net.sf.jasperreports.engine.JRException;

/**
 * 收款管理 Collection managementService接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IHyCollectionService {
	/**
	 * 查询收款管理 Collection management
	 * 
	 * @param id 收款管理 Collection managementID
	 * @return 收款管理 Collection management
	 */
	public HyCollection selectHyCollectionById(Long id);

	/**
	 * 查询收款管理 Collection management列表
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 收款管理 Collection management集合
	 */
	public List<HyCollection> selectHyCollectionList(HyCollection hyCollection);

	/**
	 * 查询收款管理 Collection management列表
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 收款管理 Collection management集合
	 */
	public List<HyCollection> selectHyPaymoneyList(HyCollection hyCollection);

	/**
	 * 新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	public String insertHyCollection(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException;
	
	/**
	 * 新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	public int insertHyCollection(HyCollection hyCollection);

	/**
	 * 部分新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	public String insertHyCollectionBuFen(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException;

	/**
	 * 新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	public String insertHyCollectionByCostIds(HyCollection hyCollection);

	/**
	 * 修改收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	public int updateHyCollection(HyCollection hyCollection);

	/**
	 * 批量删除收款管理 Collection management
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyCollectionByIds(String ids);

	/**
	 * 删除收款管理 Collection management信息
	 * 
	 * @param id 收款管理 Collection managementID
	 * @return 结果
	 */
	public int deleteHyCollectionById(Long id);

	/**
	 * 导出PDF
	 * 
	 * @param response
	 * @throws Exception
	 */
	public int downloadPDF(HyCollection hyCollection, HttpServletResponse response) throws Exception;

	/**
	 * 导出PDF
	 * 
	 * @param response
	 * @throws Exception
	 */
	public int collectionPDF(HttpServletResponse response) throws Exception;

	/**
	 * 删除收款管理修改中间表数据
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteHyCollectionAndUpdate(String ids);

}
