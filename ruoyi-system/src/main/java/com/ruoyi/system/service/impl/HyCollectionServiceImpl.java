package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.ruoyi.common.core.text.Convert;

/**
 * 收款管理 Collection managementService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class HyCollectionServiceImpl implements IHyCollectionService 
{
    @Autowired
    private HyCollectionMapper hyCollectionMapper;

    /**
     * 查询收款管理 Collection management
     * 
     * @param id 收款管理 Collection managementID
     * @return 收款管理 Collection management
     */
    @Override
    public HyCollection selectHyCollectionById(Long id)
    {
        return hyCollectionMapper.selectHyCollectionById(id);
    }

    /**
     * 查询收款管理 Collection management列表
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 收款管理 Collection management
     */
    @Override
    public List<HyCollection> selectHyCollectionList(HyCollection hyCollection)
    {
        return hyCollectionMapper.selectHyCollectionList(hyCollection);
    }

    /**
     * 新增收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyCollection(HyCollection hyCollection)
    {
        return hyCollectionMapper.insertHyCollection(hyCollection);
    }

    /**
     * 修改收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyCollection(HyCollection hyCollection)
    {
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
    public int deleteHyCollectionByIds(String ids)
    {
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
    public int deleteHyCollectionById(Long id)
    {
        return hyCollectionMapper.deleteHyCollectionById(id);
    }

	@Override
	public int downloadPDF(HyCollection hyCollection, HttpServletResponse response) throws Exception{
		//1、获取模版文件
	    File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
	    File templateFile = new File(rootFile,"/pdf_template/paymoney_db.jasper");
	    //2、准备数据库连接
	    Map params = new HashMap();
	    Date startTime = hyCollection.getStartTime();
	    Date endTime = hyCollection.getEndTime();
	    String amount = hyCollection.getAmount()+"";
	    Date applyTime = hyCollection.getApplyTime();
	    String payment = hyCollection.getPayment();
	    String brake = hyCollection.getBrake();
	    params.put("startTime", startTime);
	    params.put("endTime", endTime);
	    params.put("amount", amount);
	    params.put("applyTime", applyTime);
	    params.put("payment", payment);
	    params.put("brake", brake);
	    JasperPrint jasperPrint =JasperFillManager.fillReport(new FileInputStream(templateFile),params,new JREmptyDataSource());
	    /*ServletOutputStream outputStream = response.getOutputStream();
	    String filename="缴费通知单.pdf";
	    //response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	    response.setContentType("application/pdf");
	    response.setHeader("content-disposition", "attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));
	    JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);*/
	    JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream("d:\\交款报表.pdf"));
	    return 1;
	}
}
