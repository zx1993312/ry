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
import com.ruoyi.system.domain.HyProject;
import com.ruoyi.system.domain.HyRefund;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyProjectMapper;
import com.ruoyi.system.mapper.HyRefundMapper;
import com.ruoyi.system.service.IHyRefundService;
import com.ruoyi.system.utils.ChineseCapitalUtil;
import com.ruoyi.system.utils.HyPrintPDFUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 退款申请Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-29
 */
@Service
@Slf4j
public class HyRefundServiceImpl implements IHyRefundService {
	@Autowired
	private HyRefundMapper hyRefundMapper;

	@Autowired
	private HyCollectionMapper hyCollectionMapper;

	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;

	@Autowired
	private HyCostMapper hyCostMapper;

	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;

	@Autowired
	private HyProjectMapper hyProjectMapper;

	/**
	 * 查询退款申请
	 * 
	 * @param id 退款申请ID
	 * @return 退款申请
	 */
	@Override
	public HyRefund selectHyRefundById(Long id) {
		return hyRefundMapper.selectHyRefundById(id);
	}

	/**
	 * 查询退款申请列表
	 * 
	 * @param hyRefund 退款申请
	 * @return 退款申请
	 */
	@Override
	public List<HyRefund> selectHyRefundList(HyRefund hyRefund) {
		return hyRefundMapper.selectHyRefundList(hyRefund);
	}

	/**
	 * 新增退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyRefund(HyRefund hyRefund) {
		HyCollection hyCollection = new HyCollection();
		hyCollection.setIsRefund("0");
		hyCollection.setId(hyRefund.getCollectionId());
		hyCollectionMapper.updateHyCollection(hyCollection);
		return hyRefundMapper.insertHyRefund(hyRefund);
	}

	/**
	 * 修改退款申请
	 * 
	 * @param hyRefund 退款申请
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyRefund(HyRefund hyRefund) {
		return hyRefundMapper.updateHyRefund(hyRefund);
	}

	/**
	 * 删除退款申请对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyRefundByIds(String ids) {
		return hyRefundMapper.deleteHyRefundByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除退款申请信息
	 * 
	 * @param id 退款申请ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyRefundById(Long id) {
		return hyRefundMapper.deleteHyRefundById(id);
	}

	/**
	 * 导出PDF
	 * @throws JRException 
	 * @throws PrinterException 
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 */
	@Override
	public int exportPDF(HyRefund hyRefund, HttpServletResponse response) throws JRException, InvalidPasswordException, IOException, PrinterException{
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/refund_db.jasper");
			// 2、准备数据库连接
			Map<String, Object> params = new HashMap<String, Object>();
			Long id = hyRefund.getId();
			HyRefund hyRefund1 = hyRefundMapper.selectHyRefundById(id);
			Long collectionId = hyRefund1.getCollectionId();
			HyCollection hyCollection = hyCollectionMapper.selectHyCollectionById(collectionId);
			Long houseId = hyCollection.getHouseId();
			HyHouseInf hyHouseInf = hyHouseInfMapper.selectHyHouseInfById(houseId);
			Long costId = hyCollection.getCostId();
			HyCost hyCost = hyCostMapper.selectHyCostById(costId);
			Long ownerId = hyCollection.getOwnerId();
			HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper.selectHyOwnerRegistrationById(ownerId);
			Long projectId = hyOwnerRegistration.getProjectId();
			HyProject hyProject = hyProjectMapper.selectHyProjectById(projectId);

			String refundAmount = hyRefund.getRefundAmount() + "";
			String payee = hyRefund.getPayee();
			String refundRemark = hyRefund.getRefundRemark();
			String refundVoucherNo = hyRefund.getRefundVoucherNo();
			String idCard = hyRefund.getIdCard();
			String ICard = "身份证";
			String refundReasons = hyRefund1.getRefundReasons();
			String projectName = hyProject.getProjectName();
			String ownerName = hyOwnerRegistration.getOwnerName();
			String houseNumber = hyHouseInf.getHouseNumber();
			String costItems = hyCost.getCostItems();
			Date feeDate = hyCost.getFeeDate();
			Date collectionTime = hyCollection.getCollectionTime();
			String amount = hyCollection.getAmount() + "";
			String receiptNumber = hyCollection.getReceiptNumber();
			params.put("refundAmount", refundAmount);
			params.put("refundableAmountB", ChineseCapitalUtil.toChinese(refundAmount));
			params.put("refundableAmountS", refundAmount);
			params.put("payee", payee);
			params.put("refundRemark", refundRemark);
			params.put("refundVoucherNo", refundVoucherNo);
			params.put("idCard", idCard);
			params.put("ICard", ICard);
			params.put("refundReasons", refundReasons);
			params.put("projectName", projectName);
			params.put("ownerName", ownerName);
			params.put("houseNumber", houseNumber);
			params.put("costItems", costItems);
			params.put("feeDate", feeDate);
			params.put("collectionTime", collectionTime);
			params.put("amount", amount);
			params.put("receiptNumber", receiptNumber);
			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params,
					new JREmptyDataSource());
			Date date = new Date();
			Long time = date.getTime();
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream("d:\\" + time + "退款凭据.pdf"));
			HyPrintPDFUtil.printPDF("d:\\" + time + "退款凭据.pdf", "A4");
			
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		
		HyCollection hyCollection = new HyCollection();
		Long id = hyRefund.getId();
		HyRefund hyRefund1 = hyRefundMapper.selectHyRefundById(id);
		Long collectionId = hyRefund1.getCollectionId();
		hyCollection.setId(collectionId);
		hyCollection.setIsRefund("0");
		int result = hyCollectionMapper.updateHyCollection(hyCollection);
		return result;
	}

}