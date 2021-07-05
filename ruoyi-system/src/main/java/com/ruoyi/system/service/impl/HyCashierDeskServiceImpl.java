package com.ruoyi.system.service.impl;

import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.domain.HyCashierDesk;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.mapper.HyBuildingMapper;
import com.ruoyi.system.mapper.HyCashierDeskMapper;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.service.IHyCashierDeskService;
import com.ruoyi.system.utils.IoUtil;
import com.ruoyi.system.utils.ReceivableUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
@Slf4j
public class HyCashierDeskServiceImpl implements IHyCashierDeskService {
	@Autowired
	private HyCashierDeskMapper hyCashierDeskMapper;

	@Autowired
	private HyBuildingMapper hyBuildingMapper;

	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;

	@Autowired
	private HyHouseInfMapper hyHouseInfMapper;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Autowired
	private HyCostMapper hyCostMapper;

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
	 * 根据已支付未支付查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCashierDeskListByIsCollection(HyCost hyCost) {
		return hyCashierDeskMapper.selectHyCashierDeskListByIsCollection(hyCost);
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

	/**
	 * 打印收据
	 * 
	 * @throws Exception
	 */
	@Override
	public String printReceipt(HttpServletResponse response) throws Exception {

		String fileName = "d:\\" + new Date().getTime() + "printReceipt.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printReceipt_db.jasper");
			// 2、准备数据库连接
			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";

			Map<String, Object> map = new HashMap<>();

			List<HyHouseInf> list = hyHouseInfMapper.selectHyHouseInfList(new HyHouseInf());

			for (HyHouseInf inf : list) {
				List<Map<String, Object>> paramList = new ArrayList<>();
				HyCost hyCost = new HyCost();
				hyCost.setHyHouseInf(inf);
				hyCost.setHyCollection(new HyCollection());
				hyCost.getHyCollection().setIsCollection("0");
				List<HyCost> costList = hyCashierDeskMapper.selectHyCashierDeskList(hyCost);

				if (costList.size() == 0) {
					continue;
				}
				for (HyCost cost : costList) {
					// 2、准备数据库连接
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("id", cost.getId());
					params.put("house_number", inf.getHouseNumber());
					params.put("owner_name", cost.getHyOwnerRegistration().getOwnerName());
					params.put("cost_items", cost.getCostItems());
					params.put("community_name", cost.getHyResidentialQuarters().getCommunityName());
					params.put("building_number", cost.getHyBuilding().getBuildingNumber());
					params.put("receipt_number", cost.getHyCollection().getReceiptNumber());
					params.put("fee_date", cost.getHouseAndCost().getFeeDate());
					params.put("is_collection", cost.getHyCollection().getIsCollection());
					params.put("amount_receivable",
							cost.getHyCollection().getAmount().setScale(2, RoundingMode.HALF_UP));
					params.put("amount", cost.getHyCollection().getAmount() == null ? new BigDecimal(0)
							: cost.getHyCollection().getAmount());
					paramList.add(params);
				}

				String os = System.getProperty("os.name");
				if (os.toLowerCase().startsWith("win")) {
					map.put("pic", pic);
				} else {
					File realPath = new File("/root", "/pdf_template/printReceipt_db.jasper");
					String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
					map.put("pic", img);
					JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

					JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), map,
							dataSource);
					JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
					byte[] buffer = null;
					FileInputStream fis = new FileInputStream(fileName);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] b = new byte[1024];
					int n;
					while ((n = fis.read(b)) != -1) {
						bos.write(b, 0, n);
					}
					fis.close();
					bos.close();
					buffer = bos.toByteArray();

					IoUtil.writePdfFile(buffer, fileName);
					return fileName;
				}

				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), map,
						dataSource);
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[10000000];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
			}
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

	/**
	 * 打印催收单
	 * 
	 * @throws Exception
	 * @throws JRException
	 * @throws PrinterException
	 * @throws IOException
	 * @throws InvalidPasswordException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public String printCollection(HttpServletResponse response) throws JRException, InvalidPasswordException,
			IOException, PrinterException, ClassNotFoundException, SQLException {
		String fileName = "d:\\" + new Date().getTime() + "printCollection.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printCollection_db.jasper");

			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";
			String erweima = rootFile
					+ "\\static\\pdfimg\\src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";

			Map<String, Object> map = new HashMap<>();

			List<HyHouseInf> list = hyHouseInfMapper.selectHyHouseInfList(new HyHouseInf());

			for (HyHouseInf inf : list) {
				List<Map<String, Object>> paramList = new ArrayList<>();
				List<HyCost> costList = hyCashierDeskMapper.selectHyReportDataCollection(inf.getHouseNumber(),
						inf.getOwnerId());

				for (HyCost cost : costList) {
					// 2、准备数据库连接
					Map<String, Object> params = new HashMap<String, Object>();
					BigDecimal calculationStandard = cost.getCalculationStandard();
					String calculationMehod = cost.getCalculationMehod();
					BigDecimal bilingArea = cost.getHyHouseInf().getBilingArea();
					BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod,
							bilingArea);
					if(cost.getHouseAndCost().getDiscount()!=null) {
						amountReceivable = amountReceivable.multiply(cost.getHouseAndCost().getDiscount());
					}
					params.put("id", String.valueOf(cost.getId()));
					params.put("house_number", inf.getHouseNumber());
					params.put("owner_name", cost.getHyOwnerRegistration().getOwnerName());
					params.put("cost_items", cost.getCostItems());
					params.put("community_name", cost.getHyResidentialQuarters().getCommunityName());
					params.put("building_number", cost.getHyBuilding().getBuildingNumber());
					params.put("fee_date", cost.getHouseAndCost().getFeeDate());
					params.put("is_collection", cost.getHyCollection().getIsCollection());
					params.put("amount_receivable", amountReceivable.setScale(2, RoundingMode.HALF_UP) + "");
					params.put("amount", String.valueOf(
							cost.getHyCollection().getAmount() == null ? "0" : cost.getHyCollection().getAmount()));
					paramList.add(params);
				}

				String os = System.getProperty("os.name");
				if (os.toLowerCase().startsWith("win")) {
					map.put("pic", pic);
					map.put("erweima", erweima);
				} else {
					File realPath = new File("/root", "/pdf_template/printCollection_db.jasper");
					String img = "/root/image/src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";
					String rewma = "/root/image/src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";
					map.put("pic", img);
					map.put("erweima", rewma);
					JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

					JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), map,
							dataSource);
					JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
					byte[] buffer = null;
					FileInputStream fis = new FileInputStream(fileName);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] b = new byte[1024];
					int n;
					while ((n = fis.read(b)) != -1) {
						bos.write(b, 0, n);
					}
					fis.close();
					bos.close();
					buffer = bos.toByteArray();

					IoUtil.writePdfFile(buffer, fileName);
					return fileName;
				}

				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), map,
						dataSource);
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[100000000];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
			}

		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	@SuppressWarnings("unused")
	private Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://39.105.185.22:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
				"root", "hangyu123.root");
		return connection;
	}

	@Override
	public String printReceiptMore(String datas) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "printReceiptMore.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printReceipt_db.jasper");
			// 2、准备数据库连接
			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";

			Map<String, Object> map = new HashMap<>();

			List<Map<String, Object>> paramList = new ArrayList<>();

			JSONArray jsonArray = JSONArray.parseArray(datas);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				// 2、准备数据库连接
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", jsonObject.getLong("id"));
				params.put("house_number", jsonObject.getString("houseNumber"));
				params.put("owner_name", jsonObject.getString("ownerName"));
				params.put("cost_items", jsonObject.getString("costItems"));
				params.put("community_name", jsonObject.getString("communityName"));
				params.put("building_number", jsonObject.getString("buildingNumber"));
				params.put("receipt_number", jsonObject.getString("receiptNumber"));
				params.put("fee_date", jsonObject.getString("feeDate"));
				params.put("is_collection", jsonObject.getString("isCollection"));
				params.put("amount_receivable",
						new BigDecimal(jsonObject.getString("amountReceivable")).setScale(2, RoundingMode.HALF_UP));
				params.put("amount", jsonObject.get("amount") == null ? new BigDecimal(0)
						: new BigDecimal(jsonObject.getString("amount")).setScale(2, RoundingMode.HALF_UP));
				params.put("beginFeeDate", jsonObject.getString("beginFeeDate"));
				params.put("payFeeDate", jsonObject.getString("payFeeDate"));
				paramList.add(params);
				
			}
			
			String os = System.getProperty("os.name");
			if (os.toLowerCase().startsWith("win")) {
				map.put("pic", pic);
			} else {
				File realPath = new File("/root", "/pdf_template/printReceipt_db.jasper");
				String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
				map.put("pic", img);
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), map, dataSource);
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
				return fileName;
			}
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), map, dataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
			byte[] buffer = null;
			FileInputStream fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();

			IoUtil.writePdfFile(buffer, fileName);
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

	@Override
	public String printCollectionMore(String datas) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "printCollectionMore.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printCollection_db.jasper");

			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";
			String erweima = rootFile
					+ "\\static\\pdfimg\\src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";

			Map<String, Object> map = new HashMap<>();

			JSONArray jsonArray = JSONArray.parseArray(datas);

			List<Map<String, Object>> paramList = new ArrayList<>();

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				// 2、准备数据库连接
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", jsonObject.getString("id"));
				params.put("house_number", jsonObject.getString("houseNumber"));
				params.put("owner_name", jsonObject.getString("ownerName"));
				params.put("cost_items", jsonObject.getString("costItems"));
				params.put("community_name", jsonObject.getString("communityName"));
				params.put("building_number", jsonObject.getString("buildingNumber"));
				params.put("fee_date", jsonObject.getString("feeDate"));
				params.put("is_collection", jsonObject.getString("isCollection"));
				params.put("amount_receivable", jsonObject.getString("amountReceivable"));
				params.put("amount", jsonObject.getString("amount") == null ? "" : jsonObject.getString("amount"));
				paramList.add(params);

			}

			String os = System.getProperty("os.name");
			if (os.toLowerCase().startsWith("win")) {
				map.put("pic", pic);
				map.put("erweima", erweima);
			} else {
				File realPath = new File("/root", "/pdf_template/printCollection_db.jasper");
				String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
				String rewma = "/root/image/src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";
				map.put("pic", img);
				map.put("erweima", rewma);
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), map, dataSource);
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
				return fileName;
			}

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), map, dataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
			byte[] buffer = null;
			FileInputStream fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();

			IoUtil.writePdfFile(buffer, fileName);
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

	@Override
	public String printReceiptOne(HyCost hyCost, HttpServletResponse response) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "printReceiptOne.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printReceiptOne_db.jasper");
			// 2、准备数据库连接
			Map<String, Object> params = new HashMap<String, Object>();
			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";
			String houseNumber = hyCost.getHyHouseInf().getHouseNumber();
			String ownerName = hyCost.getHyOwnerRegistration().getOwnerName();
			String id = hyCost.getId() + "";
			String costItems = hyCost.getCostItems();
			String communityName = hyCost.getHyResidentialQuarters().getCommunityName();
			String buildingNumber = hyCost.getHyBuilding().getBuildingNumber();
			String receiptNumber = hyCost.getHyCollection().getReceiptNumber();
			String feeDate = hyCost.getHouseAndCost().getFeeDate();
			String isCollection = hyCost.getHyCollection().getIsCollection();
			BigDecimal amountReceivable = hyCost.getAmountReceivable().setScale(2, RoundingMode.HALF_UP);
			BigDecimal amount = hyCost.getHyCollection().getAmount().setScale(2, RoundingMode.HALF_UP);
			String ownerId = hyCost.getHyCollection().getOwnerId() + "";

			Long costId = Long.valueOf(id.split(houseNumber + ownerId)[0]);
			HyHouseInf hyHouseInf = new HyHouseInf();
			HyBuilding hyBuilding = new HyBuilding();
			hyBuilding.setBuildingNumber(buildingNumber);
			List<HyBuilding> buildingList = hyBuildingMapper.selectHyBuildingList(hyBuilding);
			hyBuilding = buildingList.get(0);
			Long buildingId = hyBuilding.getId();
			hyHouseInf.setHouseNumber(houseNumber);
			hyHouseInf.setBuildingId(buildingId);
			List<HyHouseInf> houseInfList = hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
			Long houseId = houseInfList.get(0).getId();
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(costId);
			houseAndCost.setHouseId(houseId);
			List<HouseAndCost> houseAndCostList = hyCustomerMapper.selectCostIds(houseAndCost);
			houseAndCost = houseAndCostList.get(0);
			String beginFeeDate = houseAndCost.getBeginFeeDate();
			String payFeeDate = houseAndCost.getPayFeeDate();
			params.put("house_number", houseNumber);
			params.put("owner_name", ownerName);
			params.put("id", id);
			params.put("cost_items", costItems);
			params.put("community_name", communityName);
			params.put("building_number", buildingNumber);
			params.put("receipt_number", receiptNumber);
			params.put("fee_date", feeDate);
			params.put("is_collection", isCollection);
			params.put("amount_receivable", amountReceivable);
			params.put("amount", amount);
			params.put("beginFeeDate", beginFeeDate);
			params.put("payFeeDate", payFeeDate);

			String os = System.getProperty("os.name");
			if (os.toLowerCase().startsWith("win")) {
				params.put("pic", pic);
			} else {
				File realPath = new File("/root", "/pdf_template/printReceiptOne_db.jasper");
				String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
				params.put("pic", img);
				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), params,
						new JREmptyDataSource());
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
				return fileName;
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params,
					new JREmptyDataSource());
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
//			HyPrintPDFUtil.printPDF(fileName, "RECEIPT");

			byte[] buffer = null;
			FileInputStream fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();

			IoUtil.writePdfFile(buffer, fileName);
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

	@Override
	public String printCollectionOne(HyCost hyCost, HttpServletResponse response) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "printCollectionOne.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printCollectionOne_db.jasper");
			// 2、准备数据库连接
			Map<String, Object> params = new HashMap<String, Object>();
			String erweima = rootFile
					+ "\\static\\pdfimg\\src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";
			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";
			String houseNumber = hyCost.getHyHouseInf().getHouseNumber();
			String ownerName = hyCost.getHyOwnerRegistration().getOwnerName();
			String id = hyCost.getId() + "";
			String costItems = hyCost.getCostItems();
			String communityName = hyCost.getHyResidentialQuarters().getCommunityName();
			String buildingNumber = hyCost.getHyBuilding().getBuildingNumber();
			String feeDate = hyCost.getHouseAndCost().getFeeDate();
			String isCollection = hyCost.getHyCollection().getIsCollection();
			String amountReceivable = hyCost.getAmountReceivable().setScale(2, RoundingMode.HALF_UP) + "";
			String amount = hyCost.getHyCollection().getAmount() + "";

			params.put("house_number", houseNumber);
			params.put("owner_name", ownerName);
			params.put("id", id);
			params.put("cost_items", costItems);
			params.put("community_name", communityName);
			params.put("building_number", buildingNumber);
			params.put("fee_date", feeDate);
			params.put("is_collection", isCollection);
			params.put("amount_receivable", amountReceivable);
			params.put("amount", amount);

			String os = System.getProperty("os.name");
			if (os.toLowerCase().startsWith("win")) {
				params.put("pic", pic);
				params.put("erweima", erweima);
			} else {
				File realPath = new File("/root", "/pdf_template/printCollectionOne_db.jasper");
				String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
				String rewma = "/root/image/src=http___i.nibaku.com_img_0_1433531324x2230376662_26.jpg&refer=http___i.nibaku.jpg";
				params.put("pic", img);
				params.put("erweima", rewma);
				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), params,
						new JREmptyDataSource());
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();
				IoUtil.writePdfFile(buffer, fileName);
				return fileName;
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params,
					new JREmptyDataSource());
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
			byte[] buffer = null;
			FileInputStream fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();

			IoUtil.writePdfFile(buffer, fileName);
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

	/**
	 * 导入费用数据
	 */
	@Override
	public String importCashierDesk(List<HyCashierDesk> cashierDeskList, boolean updateSupport, String operName) {
		if (StringUtils.isNull(cashierDeskList) || cashierDeskList.size() == 0) {
			throw new BusinessException("导入费用数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyCashierDesk hyCashierDesk : cashierDeskList) {

			// 判断这些是否为空
			if (StringUtils.isNull(hyCashierDesk.getBuildingNumber()) || StringUtils.isNull(hyCashierDesk.getUnit())
					|| StringUtils.isNull(hyCashierDesk.getHouseNumber())
					|| StringUtils.isNull(hyCashierDesk.getOwnerName())
					|| StringUtils.isNull(hyCashierDesk.getBilingArea())
					|| StringUtils.isNull(hyCashierDesk.getMobilePhone())
					|| StringUtils.isNull(hyCashierDesk.getIdCardNum())
					|| StringUtils.isNull(hyCashierDesk.getIdCardAddress())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}

			// 查询数据是否存在
			// 楼宇
			HyBuilding hyBuilding = new HyBuilding();
			hyBuilding.setBuildingNumber(hyCashierDesk.getBuildingNumber());
			List<HyBuilding> buildingList = hyBuildingMapper.selectHyBuildingList(hyBuilding);
			if (buildingList == null || buildingList.size() == 0) {
				hyBuilding.setQuartersId((long) 1);
				hyBuildingMapper.insertHyBuilding(hyBuilding);
				successNum++;
				successMsg.append("<br/>" + successNum + "、楼栋为 " + hyBuilding.getBuildingNumber() + "的楼宇 导入成功");
			} /*
				 * else if (updateSupport) { hyBuilding.setId(buildingList.get(0).getId());
				 * hyBuilding.setQuartersId((long) 1);
				 * hyBuildingMapper.updateHyBuilding(hyBuilding); successNum++;
				 * successMsg.append("<br/>" + successNum + "、楼栋为 " +
				 * hyBuilding.getBuildingNumber() + "的楼宇 更新成功"); }
				 */
			// 业主
			HyOwnerRegistration hyOwnerRegistration = new HyOwnerRegistration();
			hyOwnerRegistration.setOwnerName(hyCashierDesk.getOwnerName());
			hyOwnerRegistration.setIdCardNum(hyCashierDesk.getIdCardNum());
			List<HyOwnerRegistration> ownerRegistrationList = hyOwnerRegistrationMapper
					.selectHyOwnerRegistrationList(hyOwnerRegistration);
			if (ownerRegistrationList == null || ownerRegistrationList.size() == 0) {
				hyOwnerRegistration.setMobilePhone(hyCashierDesk.getMobilePhone());
				hyOwnerRegistration.setIdCardAddress(hyCashierDesk.getIdCardAddress());
				hyOwnerRegistrationMapper.insertHyOwnerRegistration(hyOwnerRegistration);
				successNum++;
				successMsg.append("<br/>" + successNum + "、姓名 " + hyOwnerRegistration.getOwnerName() + "、身份证号码为 "
						+ hyOwnerRegistration.getIdCardNum() + "的业主 导入成功");
			} /*
				 * else if (updateSupport) {
				 * hyOwnerRegistration.setId(ownerRegistrationList.get(0).getId());
				 * hyOwnerRegistration.setMobilePhone(hyCashierDesk.getMobilePhone());
				 * hyOwnerRegistration.setIdCardAddress(hyCashierDesk.getIdCardAddress());
				 * hyOwnerRegistrationMapper.updateHyOwnerRegistration(hyOwnerRegistration);
				 * successNum++; successMsg.append("<br/>" + successNum + "、姓名 " +
				 * hyOwnerRegistration.getOwnerName() + "、身份证号码为 " +
				 * hyOwnerRegistration.getIdCardNum() + "的业主 更新成功"); } else { failureNum++;
				 * failureMsg.append("<br/>" + failureNum + "、姓名 " +
				 * hyOwnerRegistration.getOwnerName() + "、身份证号码为 " +
				 * hyOwnerRegistration.getIdCardNum() + "的业主 已存在"); }
				 */

			// 房屋
			HyHouseInf hyHouseInf = new HyHouseInf();
			List<HyBuilding> buildingListBy = hyBuildingMapper.selectHyBuildingList(hyBuilding);
			hyHouseInf.setBuildingId(buildingListBy.get(0).getId());
			hyHouseInf.setUnit(hyCashierDesk.getUnit());
			hyHouseInf.setHouseNumber(hyCashierDesk.getHouseNumber());
			List<HyOwnerRegistration> ownerRegistrationListBy = hyOwnerRegistrationMapper
					.selectHyOwnerRegistrationList(hyOwnerRegistration);
			List<HyHouseInf> houseInfList = hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
			if (houseInfList == null || houseInfList.size() == 0) {
				hyHouseInf.setBuildingId(buildingListBy.get(0).getId());
				hyHouseInf.setOwnerId(ownerRegistrationListBy.get(0).getId());
				hyHouseInf.setBilingArea(hyCashierDesk.getBilingArea());
				hyHouseInfMapper.insertHyHouseInf(hyHouseInf);
				successNum++;
				successMsg.append("<br/>" + successNum + "、单元 " + hyHouseInf.getUnit() + "、房屋编号为 "
						+ hyHouseInf.getHouseNumber() + "的房屋 导入成功");
			} /*
				 * else if (updateSupport) { hyHouseInf.setId(houseInfList.get(0).getId());
				 * hyHouseInf.setBuildingId(buildingListBy.get(0).getId());
				 * hyHouseInf.setOwnerId(ownerRegistrationListBy.get(0).getId());
				 * hyHouseInfMapper.updateHyHouseInf(hyHouseInf); successNum++;
				 * successMsg.append("<br/>" + successNum + "、单元 " + hyHouseInf.getUnit() +
				 * "、房屋编号为 " + hyHouseInf.getHouseNumber() + "的房屋 更新成功"); } else { failureNum++;
				 * failureMsg.append("<br/>" + failureNum + "、单元 " + hyHouseInf.getUnit() +
				 * "、房屋编号为 " + hyHouseInf.getHouseNumber() + "的房屋 已存在"); }
				 */
			// 费用
			List<HyCost> costList = hyCostMapper.selectHyCostListDistinct(new HyCost());
			for (int i = 0; i < costList.size(); i++) {
				HyCost hyCost = new HyCost();
				hyCost = costList.get(i);
				Long costId = hyCost.getId();
				HouseAndCost houseAndCost = new HouseAndCost();
				List<HyHouseInf> houseInfListBy = hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
				houseAndCost.setHouseId(houseInfListBy.get(0).getId());
				houseAndCost.setCostId(costId);
				List<HouseAndCost> houseAndCostList = hyCustomerMapper.selectCostIds(houseAndCost);
				if (houseAndCostList == null || houseAndCostList.size() == 0) {
					hyCustomerMapper.insertHouseAndCost(houseInfListBy.get(0).getId() + "", costId + "");
					successNum++;
					successMsg.append("<br/>" + successNum + "、费用项目为 " + hyCost.getCostItems() + "、和房屋编号为 "
							+ hyHouseInf.getHouseNumber() + " 关系导入成功");
				} /*
					 * else { failureNum++; failureMsg.append("<br/>" + failureNum + "、费用项目为 " +
					 * hyCost.getCostItems() + "、和房屋编号为 " + hyHouseInf.getHouseNumber() + "关系已存在");
					 * }
					 */
			}
		}

		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}

		return successMsg.toString();
	}

	@Override
	public String printReceiptSelect(String datas) throws Exception {
		String fileName = "d:\\" + new Date().getTime() + "printReceiptMore.pdf";
		try {
			// 1、获取模版文件
			File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
			File templateFile = new File(rootFile, "/pdf_template/printReceipt_db.jasper");
			// 2、准备数据库连接
			String pic = rootFile + "\\static\\pdfimg\\e813f89d5a4c8f33b567a553a60649b.png";

			Map<String, Object> map = new HashMap<>();

			List<Map<String, Object>> paramList = new ArrayList<>();

			JSONArray jsonArray = JSONArray.parseArray(datas);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				// 2、准备数据库连接
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", jsonObject.getLong("id"));
				params.put("house_number", jsonObject.getString("houseNumber"));
				params.put("owner_name", jsonObject.getString("ownerName"));
				params.put("cost_items", jsonObject.getString("costItems"));
				params.put("community_name", jsonObject.getString("communityName"));
				params.put("building_number", jsonObject.getString("buildingNumber"));
				params.put("receipt_number", jsonObject.getString("receiptNumber"));
				params.put("fee_date", jsonObject.getString("feeDate"));
				params.put("is_collection", jsonObject.getString("isCollection"));
				params.put("amount_receivable",
						new BigDecimal(jsonObject.getString("amountReceivable")).setScale(2, RoundingMode.HALF_UP));
				params.put("amount",
						new BigDecimal(jsonObject.getString("amountReceivable")).setScale(2, RoundingMode.HALF_UP));
				paramList.add(params);

				//
			}
			String os = System.getProperty("os.name");
			if (os.toLowerCase().startsWith("win")) {
				map.put("pic", pic);
			} else {
				File realPath = new File("/root", "/pdf_template/printReceipt_db.jasper");
				String img = "/root/image/e813f89d5a4c8f33b567a553a60649b.png";
				map.put("pic", img);
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

				JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(realPath), map, dataSource);
				JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
				byte[] buffer = null;
				FileInputStream fis = new FileInputStream(fileName);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1) {
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				IoUtil.writePdfFile(buffer, fileName);
				return fileName;
			}
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paramList);

			JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), map, dataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(fileName));
			byte[] buffer = null;
			FileInputStream fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();

			IoUtil.writePdfFile(buffer, fileName);
		} catch (java.io.EOFException e) {
			log.error("没有字体的异常,没关系，不要在意" + e.getMessage());
		}
		return fileName;
	}

}
