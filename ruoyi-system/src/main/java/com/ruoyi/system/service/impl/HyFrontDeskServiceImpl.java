package com.ruoyi.system.service.impl;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.OwnerAndCost;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyFrontDeskMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.OwnerAndCostMapper;
import com.ruoyi.system.service.IHyFrontDeskService;
import com.ruoyi.system.utils.ChineseCapitalUtil;
import com.ruoyi.system.utils.HyPrintPDFUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
@Slf4j
public class HyFrontDeskServiceImpl implements IHyFrontDeskService {
	@Autowired
	private HyFrontDeskMapper hyFrontDeskMapper;

	@Autowired
	private HyCostMapper hyCostMapper;
	
	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;
	
	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;
	
	@Autowired
	private OwnerAndCostMapper ownerAndCostMapper;

	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	@Override
	public HyCost selectHyCostById(Long id) {
		return hyFrontDeskMapper.selectHyCostById(id);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostList(HyCost hyCost) {
		return hyFrontDeskMapper.selectHyCostList(hyCost);
	}

	/**
	 * 新增费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyCost(HyCost hyCost) {
		OwnerAndCost ownerAndCost = new OwnerAndCost();
		Long ownerId = hyCost.getOwnerAndCost().getOwnerId();
		String a = hyFrontDeskMapper.selectNextValue("hy_database", "hy_cost");
		Long costId = Long.valueOf(a);
		ownerAndCost.setCostId(costId);
		ownerAndCost.setOwnerId(ownerId);
		ownerAndCostMapper.insertOwnerAndCost(ownerAndCost);
		return hyFrontDeskMapper.insertHyCost(hyCost);
	}

	/**
	 * 修改费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyCost(HyCost hyCost) {
		Long ownerId = hyCost.getOwnerAndCost().getOwnerId();
		Long costId = hyCost.getId();
		OwnerAndCost ownerAndCost = new OwnerAndCost();
		ownerAndCost.setOwnerId(ownerId);
		ownerAndCost.setCostId(costId);
		ownerAndCostMapper.updateOwnerAndCost(ownerAndCost);
		return hyFrontDeskMapper.updateHyCost(hyCost);
	}

	/**
	 * 删除费用项目对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCostByIds(String ids) {
		return hyFrontDeskMapper.deleteHyCostByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除费用项目信息
	 * 
	 * @param id 费用项目ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCostById(Long id) {
		return hyFrontDeskMapper.deleteHyCostById(id);
	}

	@Override
	public int downloadPDF(HyCollection hyCollection, HttpServletResponse response)
			throws JRException, InvalidPasswordException, IOException, PrinterException {
		try {
			String fileName = "d:\\" + new Date().getTime() + "盛邦物业项目收据.pdf";
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/receipt_db.jasper");
			// 2、准备数据库连接
			Map<String, Object> params = new HashMap<String, Object>();
			String pic = rootFile+"\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";
			Long houseId = hyCollection.getHouseId();
			HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(houseId);
			String houseName = hyHouseInf.getHouseName();
			Long ownerId = hyCollection.getOwnerId();
			HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper.selectHyOwnerRegistrationById(ownerId);
			String ownerName = hyOwnerRegistration.getOwnerName();
			String  receiptNumber = hyCollection.getReceiptNumber();
			String houseNumber = hyHouseInf.getHouseNumber();
			Long costId = hyCollection.getCostId();
			HyCost hyCost = hyCostMapper.selectHyCostById(costId);
			String costItems = hyCost.getCostItems();
			Date feeDate = hyCost.getFeeDate();
			Date bilingStartDate = hyCost.getBilingStartDate();
			Date bilingEndDate = hyCost.getBilingEndDate();
			String amount = hyCollection.getAmount()+"";
			String amountReceivable = hyCollection.getHyCost().getAmountReceivable().setScale(2)+"";
			String collectionRemark = hyCollection.getCollectionRemark();
			String writeOff = hyCost.getWriteOff().setScale(2)+"";
			String advancePaymentOffset = hyCost.getAdvancePaymentOffset().setScale(2)+"";
			String remarks = hyCost.getRemark();
			String collectionType = hyCollection.getCollectionType();
			String payee = hyCollection.getPayee();
			params.put("pic", pic);
			params.put("houseName", houseName);
			params.put("ownerName", ownerName);
			params.put("receiptNumber", receiptNumber);
			params.put("houseNumber", houseNumber);
			params.put("costItems", costItems);
			params.put("feeDate", feeDate);
			params.put("bilingStartDate", bilingStartDate);
			params.put("bilingEndDate", bilingEndDate);
			params.put("amount", amount);
			params.put("collectionRemark", collectionRemark);
			params.put("amountReceivableB", ChineseCapitalUtil.toChinese(amountReceivable));
			params.put("amountReceivableS", amountReceivable);
			params.put("writeOffB", ChineseCapitalUtil.toChinese(writeOff));
			params.put("writeOffS", writeOff);
			params.put("amountActuallyB", ChineseCapitalUtil.toChinese(amount));
			params.put("amountActuallyS", amount);
			params.put("amountActuallyS", amount);
			params.put("advancePaymentOffset", advancePaymentOffset);
			params.put("remarks", remarks);
			params.put("collectionType", collectionType);
			params.put("payee", payee);
			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params,
					new JREmptyDataSource());
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
			HyPrintPDFUtil.printPDF(fileName, "RECEIPT");
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return 1;

	}

}
