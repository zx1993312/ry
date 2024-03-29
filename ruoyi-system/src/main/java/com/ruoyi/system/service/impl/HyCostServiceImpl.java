package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.BatchHouseInf;
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.mapper.BatchMapper;
import com.ruoyi.system.mapper.HyBuildingMapper;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.service.IHyCostService;

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
public class HyCostServiceImpl implements IHyCostService {
	@Autowired
	private HyCostMapper hyCostMapper;

	@Autowired
	private BatchMapper batchMapper;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Autowired
	private HyBuildingMapper hyBuildingMapper;

	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	@Override
	public HyCost selectHyCostById(Long id) {
		return hyCostMapper.selectHyCostById(id);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostList(HyCost hyCost) {
		return hyCostMapper.selectHyCostList(hyCost);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostListDistinct(HyCost hyCost) {
		List<HyCost> list = hyCostMapper.selectHyCostListDistinct(hyCost);
		List<HyCost> reList = new ArrayList<>();
		for (HyCost cost : list) {
			if (null == cost) {
				continue;
			}
			reList.add(cost);
		}
		return reList;
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Ztree> selectHyCostListTree(HyCost hyCost) {
		List<Ztree> ztrees = initZtree(hyCostMapper.selectHyCostList(hyCost));
		return ztrees;
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
		/*
		 * OwnerAndCost ownerAndCost = new OwnerAndCost(); Long ownerId =
		 * hyCost.getOwnerAndCost().getOwnerId(); String a =
		 * hyCostMapper.selectNextValue("hy_database", "hy_cost"); Long costId =
		 * Long.valueOf(a); ownerAndCost.setCostId(costId);
		 * ownerAndCost.setOwnerId(ownerId);
		 * ownerAndCostMapper.insertOwnerAndCost(ownerAndCost);
		 */
		return hyCostMapper.insertHyCost(hyCost);
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
		/*
		 * Long ownerId = hyCost.getOwnerAndCost().getOwnerId(); Long costId =
		 * hyCost.getId(); OwnerAndCost ownerAndCost = new OwnerAndCost();
		 * ownerAndCost.setOwnerId(ownerId); ownerAndCost.setCostId(costId);
		 * ownerAndCostMapper.updateOwnerAndCost(ownerAndCost);
		 */
		return hyCostMapper.updateHyCost(hyCost);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyCostOther(String currentState) {
		return hyCostMapper.updateHyCostOther(currentState);
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
		return hyCostMapper.deleteHyCostByIds(Convert.toStrArray(ids));
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
		return hyCostMapper.deleteHyCostById(id);
	}

	/**
	 * 对象转费用项目列表树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyCost> hyCostList) {
		return initZtree(hyCostList, null);
	}

	/**
	 * 对象转费用项目列表树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyCost> hyCostList, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (HyCost hyCost : hyCostList) {
			if (UserConstants.DEPT_NORMAL.equals("0")) {
				Ztree ztree = new Ztree();
				ztree.setId(hyCost.getId());
				ztree.setpId(Long.valueOf(null == hyCost.getParentId() ? -1l : hyCost.getParentId()));
				ztree.setName(hyCost.getCostItems());
				ztree.setTitle(hyCost.getCostItems());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(hyCost.getId() + hyCost.getCostItems()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}

	@Override
	public String importCost(List<HyCost> userList, boolean updateSupport, String operName) {

		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入费用项目数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyCost hyCost : userList) {
			List<HyCost> dataList = this.selectHyCostList(hyCost);

			// 判断这些是否为空
			if (StringUtils.isNull(hyCost.getCostItems()) || StringUtils.isNull(hyCost.getExpenseType())) {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}

			// 查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyCost(hyCost);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核 " + hyCost.getCostItems() + " 导入成功");
			} else if (updateSupport) {
				hyCost.setId(dataList.get(0).getId());
				this.updateHyCost(hyCost);
				successNum++;
				successMsg.append("<br/>" + successNum + "、收费科目是否需要审核" + hyCost.getCostItems() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、收费科目是否需要审核 " + hyCost.getCostItems() + " 已存在");
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
	public int batchUpdateCost(String costItems, String standardName, String billingCycle, String currentState,
			String building, String transferTenants, String[] sel) {
		try {
			for (String s : sel) {// 遍历选中的sel值
				List<BatchHouseInf> list = new ArrayList<>();// 用于存放查询后的房屋数据
				if (currentState.equals("0")) {
					list = batchMapper.selectHouseInf(s, null);
				} else {
					HyBuilding hyBuilding = new HyBuilding();
					hyBuilding.setBuildingName(s);
					List<HyBuilding> bulidingList = hyBuildingMapper.selectHyBuildingList(hyBuilding);
					list = batchMapper.selectHouseInf(null, String.valueOf(bulidingList.get(0).getId()));
				}

				for (BatchHouseInf inf : list) {
					List<Long> costList = hyCustomerMapper.selectCostId(String.valueOf(inf.getId()), null);
					for (Long hyCostId : costList) {
						HyCost hyCost = new HyCost();// 给hyCost赋值
						hyCost.setId(hyCostId);
						hyCost.setCostItems(costItems);
						hyCost.setStandardName(standardName);
						hyCost.setBillingCycle(billingCycle);
						hyCost.setTransferTenants(Integer.valueOf(transferTenants));
						hyCostMapper.updateHyCostByIdCostItems(hyCost);
					}
				}
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int downloadPDF(HttpServletResponse response) throws Exception {
		// 1、获取模版文件
		File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
		File templateFile = new File(rootFile, "/pdf_template/cost_db.jasper");
		// 2、准备数据库连接
		Map<String, Object> params = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(templateFile), params, getCon());
		JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream("d:\\收费率报表.pdf"));
		return 1;
	}

	private Connection getCon() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://39.105.185.22:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
				"root", "hangyu123.root");
		return connection;
	}
}
