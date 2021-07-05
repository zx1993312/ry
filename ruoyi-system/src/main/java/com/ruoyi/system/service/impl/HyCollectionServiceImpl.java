package com.ruoyi.system.service.impl;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
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

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.mapper.HyCashierDeskMapper;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.service.IHyCollectionService;
import com.ruoyi.system.utils.HyPrintPDFUtil;
import com.ruoyi.system.utils.ReceivableUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 收款管理 Collection managementService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
@Slf4j
public class HyCollectionServiceImpl implements IHyCollectionService {
	@Autowired
	private HyCollectionMapper hyCollectionMapper;

	@Autowired
	private HyCashierDeskMapper hyCashierDeskMapper;

	@Autowired
	private HyCashierDeskServiceImpl hyCashierDeskServiceImpl;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	
	/**
	 * 查询收款管理 Collection management
	 * 
	 * @param id 收款管理 Collection managementID
	 * @return 收款管理 Collection management
	 */
	@Override
	public HyCollection selectHyCollectionById(Long id) {
		return hyCollectionMapper.selectHyCollectionById(id);
	}

	/**
	 * 查询收款管理 Collection management列表
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 收款管理 Collection management
	 */
	@Override
	public List<HyCollection> selectHyCollectionList(HyCollection hyCollection) {
		return hyCollectionMapper.selectHyCollectionList(hyCollection);
	}

	/**
	 * 查询收款管理 Collection management列表
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 收款管理 Collection management
	 */
	@Override
	public List<HyCollection> selectHyPaymoneyList(HyCollection hyCollection) {
		return hyCollectionMapper.selectHyPaymoneyList(hyCollection);
	}

	/**
	 * 新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 * @throws PrinterException
	 * @throws IOException
	 * @throws JRException
	 * @throws InvalidPasswordException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insertHyCollection(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException {
		String fileName = "";
		Long costId = hyCollection.getCostId();
		Long houseId = hyCollection.getHouseId();
		Long ownerId = hyCollection.getOwnerId();
		HyCollection collection = new HyCollection();
		collection.setCostId(costId);
		collection.setHouseId(houseId);
		collection.setOwnerId(ownerId);
		List<HyCollection> list = hyCollectionMapper.selectHyCollectionList(collection);
		if (list.size() == 0) {
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(costId);
			houseAndCost.setHouseId(houseId);
			String payFeeDate = "";
			String beginFeeDate = "";
			int m = 12;
			String feeDate = hyCollection.getHyCost().getHouseAndCost().getFeeDate();
			String a = feeDate.split("-")[1];
			String b = feeDate.split("-")[0];
			String c = feeDate.split("-")[2];
			int n = Integer.parseInt(a);
			int y = Integer.parseInt(b);
			if (m + n > 12) {
				String z = y + 1 + "";
				String p = m + n - 12 + "";
				payFeeDate = z + "-0" + p+"-"+c;
			} else {
				String p = m + n + "";
				if (Integer.parseInt(p) > 9) {
					payFeeDate = b + "-" + p+"-"+c;
				} else {
					payFeeDate = b + "-0" + p+"-"+c;
				}
			}
			beginFeeDate = b+"-"+a+"-"+c;
			houseAndCost.setPayFeeDate(payFeeDate);
			houseAndCost.setBeginFeeDate(beginFeeDate);
			hyCustomerMapper.updateHouseAndCost(houseAndCost);
			hyCollectionMapper.insertHyCollection(hyCollection);
			try {
				fileName = hyCashierDeskServiceImpl.printReceiptOne(hyCollection.getHyCost(), response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		} else {
			return fileName;
		}

	}

	/**
	 * 部分新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 * @throws PrinterException
	 * @throws IOException
	 * @throws JRException
	 * @throws InvalidPasswordException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insertHyCollectionBuFen(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException {
		Long costId = hyCollection.getCostId();
		Long houseId = hyCollection.getHouseId();
		Long ownerId = hyCollection.getOwnerId();
		String fileName = "";
		HyCollection collection = new HyCollection();
		collection.setCostId(costId);
		collection.setHouseId(houseId);
		collection.setOwnerId(ownerId);
		List<HyCollection> list = hyCollectionMapper.selectHyCollectionList(collection);
		if (list.size() == 0) {
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(costId);
			houseAndCost.setHouseId(houseId);
			String payFeeDate = "";
			String beginFeeDate = "";
			int m = hyCollection.getMonth();
			String feeDate = hyCollection.getHyCost().getHouseAndCost().getFeeDate();
			String a = feeDate.split("-")[1];
			String b = feeDate.split("-")[0];
			String c = feeDate.split("-")[2];
			int n = Integer.parseInt(a);
			int y = Integer.parseInt(b);
			if (m + n > 12) {
				String z = y + 1 + "";
				String p = m + n - 12 + "";
				payFeeDate = z + "-0" + p+"-"+c;
			} else {
				String p = m + n + "";
				if (Integer.parseInt(p) > 9) {
					payFeeDate = b + "-" + p+"-"+c;
				} else {
					payFeeDate = b + "-0" + p+"-"+c;
				}
			}
			beginFeeDate = b+"-"+a+"-"+c;
			houseAndCost.setPayFeeDate(payFeeDate);
			houseAndCost.setBeginFeeDate(beginFeeDate);
			hyCustomerMapper.updateHouseAndCost(houseAndCost);
			hyCollectionMapper.insertHyCollection(hyCollection);
			try {
				fileName = hyCashierDeskServiceImpl.printReceiptOne(hyCollection.getHyCost(), response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		} else {
			BigDecimal amount = hyCollection.getAmount().add(list.get(0).getAmount());
			hyCollection.setAmount(amount);
			hyCollection.getHyCost().getHyCollection().setAmount(amount);
			hyCollection.setId(list.get(0).getId());
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(costId);
			houseAndCost.setHouseId(houseId);
			List<HouseAndCost> houseAndCostList = hyCustomerMapper.selectCostIds(houseAndCost);
			houseAndCost = houseAndCostList.get(0);
			String payFeeDate = "";
			int m = hyCollection.getMonth();
			String feeDate = houseAndCost.getPayFeeDate();
			String a = feeDate.split("-")[1];
			String b = feeDate.split("-")[0];
			String c = feeDate.split("-")[2];
			int n = Integer.parseInt(a);
			int y = Integer.parseInt(b);
			if (m + n > 12) {
				String z = y + 1 + "";
				String p = m + n - 12 + "";
				payFeeDate = z + "-0" + p+"-"+c;
			} else {
				String p = m + n + "";
				if (Integer.parseInt(p) > 9) {
					payFeeDate = b + "-" + p+"-"+c;
				} else {
					payFeeDate = b + "-0" + p+"-"+c;
				}
			}
			houseAndCost.setPayFeeDate(payFeeDate);
			hyCustomerMapper.updateHouseAndCost(houseAndCost);
			hyCollectionMapper.updateHyCollection(hyCollection);
			try {
				fileName = hyCashierDeskServiceImpl.printReceiptOne(hyCollection.getHyCost(), response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}

	}

	/**
	 * 新增收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insertHyCollectionByCostIds(HyCollection hyCollection) {
		String result = "";
		String[] ids = hyCollection.getCostIds().split(",");
		try {
			List<Map<String, Object>> beanList = new ArrayList<>();
			for (String ida : ids) {
				Long costIds = Long.valueOf(ida);
				HyCost hyCost = hyCashierDeskMapper.selectHyCashierDeskById(costIds);
				BigDecimal calculationStandard = hyCost.getCalculationStandard();
				String calculationMehod = hyCost.getCalculationMehod();
				BigDecimal bilingArea = hyCost.getHyHouseInf().getBilingArea();
				BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
				if(hyCost.getHouseAndCost().getDiscount()!=null) {
					amountReceivable = amountReceivable.multiply(hyCost.getHouseAndCost().getDiscount());
				}
				Long houseId = hyCost.getHyCollection().getHouseId();
				Long ownerId = hyCost.getHyCollection().getOwnerId();
				String str = hyCost.getHyHouseInf().getHouseNumber() + hyCost.getHyHouseInf().getOwnerId();
				Long costId = Long.valueOf(String.valueOf(ida).split(str)[0]);
				HyCollection collection = (HyCollection) Constants.REFLECT_UTIL.convertBean(new HyCollection(),
						hyCollection);
				collection.setCostId(costId);
				collection.setHouseId(houseId);
				collection.setOwnerId(ownerId);
				List<HyCollection> list = hyCollectionMapper.selectHyCollectionList(collection);
				if (list.size() == 0) {
					collection.setAmount(amountReceivable.setScale(2, RoundingMode.HALF_UP));

					HouseAndCost houseAndCost = new HouseAndCost();
					houseAndCost.setCostId(costId);
					houseAndCost.setHouseId(houseId);
					String payFeeDate = "";
					String beginFeeDate = "";
					int m = 12;
					String feeDate = hyCollection.getHyCost().getHouseAndCost().getFeeDate();
					String a = feeDate.split("-")[1];
					String b = feeDate.split("-")[0];
					String c = feeDate.split("-")[2];
					int n = Integer.parseInt(a);
					int y = Integer.parseInt(b);
					if (m + n > 12) {
						String z = y + 1 + "";
						String p = m + n - 12 + "";
						payFeeDate = z + "-0" + p+"-"+c;
					} else {
						String p = m + n + "";
						if (Integer.parseInt(p) > 9) {
							payFeeDate = b + "-" + p+"-"+c;
						} else {
							payFeeDate = b + "-0" + p+"-"+c;
						}
					}
					beginFeeDate = b+"-"+a+"-"+c;
					houseAndCost.setPayFeeDate(payFeeDate);
					houseAndCost.setBeginFeeDate(beginFeeDate);
					hyCustomerMapper.updateHouseAndCost(houseAndCost);
					hyCollectionMapper.insertHyCollection(collection);
					Map<String, Object> map = new HashMap<>();
					map.put("id", hyCost.getId());
					map.put("costItems", hyCost.getCostItems());
					map.put("communityName", hyCost.getHyResidentialQuarters().getCommunityName());
					map.put("buildingNumber", hyCost.getHyBuilding().getBuildingNumber());
					map.put("receiptNumber", hyCollection.getHyCost().getHyCollection().getReceiptNumber());
					map.put("houseNumber", hyCost.getHyHouseInf().getHouseNumber());
					map.put("ownerName", hyCost.getHyOwnerRegistration().getOwnerName());
					map.put("feeDate", hyCost.getHouseAndCost().getFeeDate());
					map.put("isCollection", hyCollection.getIsCollection());
					map.put("amountReceivable", amountReceivable.setScale(2, RoundingMode.HALF_UP));
					map.put("amount", collection.getAmount());
					map.put("beginFeeDate", beginFeeDate);
					map.put("payFeeDate", payFeeDate);
					beanList.add(map);
				} else {
					return result;
				}
			}
			result = hyCashierDeskServiceImpl.printReceiptMore(JSON.toJSONString(beanList));
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return result;
	}

	/**
	 * 修改收款管理 Collection management
	 * 
	 * @param hyCollection 收款管理 Collection management
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyCollection(HyCollection hyCollection) {
		return hyCollectionMapper.updateHyCollection(hyCollection);
	}

	/**
	 * 删除收款管理 Collection management对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCollectionByIds(String ids) {
		return hyCollectionMapper.deleteHyCollectionByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除收款管理 Collection management信息
	 * 
	 * @param id 收款管理 Collection managementID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCollectionById(Long id) {
		return hyCollectionMapper.deleteHyCollectionById(id);
	}

	@Override
	public int downloadPDF(HyCollection hyCollection, HttpServletResponse response) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "交款报表.pdf";
		// 1、获取模版文件
		File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
		File templateFile = new File(rootFile, "/pdf_template/paymoney_db.jasper");
		// 2、准备数据库连接
		Map<String, Object> params = new HashMap<String, Object>();
		Date startTime = hyCollection.getStartTime();
		Date endTime = hyCollection.getEndTime();
		String amount = hyCollection.getAmount() + "";
		Date applyTime = hyCollection.getApplyTime();
		String payment = hyCollection.getPayment();
		String brake = hyCollection.getCollectionRemark();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("amount", amount);
		params.put("applyTime", applyTime);
		params.put("payment", payment);
		params.put("brake", brake);
		JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params,
				new JREmptyDataSource());
		JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
		HyPrintPDFUtil.printPDF(fileName, "A4");
		return 1;
	}

	@Override
	public int collectionPDF(HttpServletResponse response) throws Exception {
		// 1、获取模版文件
		File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
		File templateFile = new File(rootFile, "/pdf_template/collection_db.jasper");
		// 2、准备数据库连接
		Map<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params, getCon());
		JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream("d:\\收款报表.pdf"));
		return 1;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCollectionAndUpdate(String ids) {
		String[] idss = Convert.toStrArray(ids);
		for (String id : idss) {
			HyCollection hyCollection = hyCollectionMapper.selectHyCollectionById(Long.valueOf(id));
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setHouseId(hyCollection.getHouseId());
			houseAndCost.setCostId(hyCollection.getCostId());

			houseAndCost.setBeginFeeDate("");
			houseAndCost.setPayFeeDate("");
			hyCustomerMapper.updateHouseAndCost(houseAndCost);
		}
		return hyCollectionMapper.deleteHyCollectionByIds(Convert.toStrArray(ids));
	}

	private Connection getCon() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://39.105.185.22:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
				"root", "hangyu123.root");
		return connection;
	}
}
