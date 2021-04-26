package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAssessorMapper;
import com.ruoyi.system.mapper.HyBillMapper;
import com.ruoyi.system.mapper.HyDeliveryMapper;
import com.ruoyi.system.mapper.HyLiftingMapper;
import com.ruoyi.system.mapper.HyMaterialMapper;
import com.ruoyi.system.mapper.HyStockRecordMapper;
import com.ruoyi.system.domain.HyAssessor;
import com.ruoyi.system.domain.HyBill;
import com.ruoyi.system.domain.HyDelivery;
import com.ruoyi.system.domain.HyLifting;
import com.ruoyi.system.domain.HyMaterial;
import com.ruoyi.system.domain.HyStockRecord;
import com.ruoyi.system.service.IHyAssessorService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

/**
 * 审核管理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-21
 */
@Service
public class HyAssessorServiceImpl implements IHyAssessorService 
{
    @Autowired
    private HyAssessorMapper hyAssessorMapper;
    
    @Autowired
    private HyMaterialServiceImpl hyMaterialServiceImpl;
    
    @Autowired
    private HyStockRecordMapper hyStockRecordMapper;
    
    @Autowired
    private HyLiftingMapper hyLiftingMapper;
    
    @Autowired
    private HyBillMapper hyBillMapper;
    
    @Autowired
    private HyMaterialMapper hyMaterialMapper;
    
    @Autowired
    private HyDeliveryMapper hyDeliveryMapper;

    /**
     * 查询审核管理
     * 
     * @param id 审核管理ID
     * @return 审核管理
     */
    @Override
    public HyAssessor selectHyAssessorById(Long id)
    {
        return hyAssessorMapper.selectHyAssessorById(id);
    }

    /**
     * 查询审核管理列表
     * 
     * @param hyAssessor 审核管理
     * @return 审核管理
     */
    @Override
    public List<HyAssessor> selectHyAssessorList(HyAssessor hyAssessor)
    {
        return hyAssessorMapper.selectHyAssessorList(hyAssessor);
    }

    /**
     * 新增审核管理
     * 
     * @param hyAssessor 审核管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAssessor(HyAssessor hyAssessor)
    {
        return hyAssessorMapper.insertHyAssessor(hyAssessor);
    }

    /**
     * 修改审核管理入库
     * 
     * @param hyAssessor 审核管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAssessor(HyAssessor hyAssessor)
    {
    	hyAssessorMapper.updateHyAssessor(hyAssessor);
    	List<HyAssessor> list = hyAssessorMapper.selectHyAssessorList(hyAssessor);
    	hyAssessor = list.get(0);
    	HyMaterial hyMaterial = new HyMaterial();
    	hyMaterial.setAssessorId(hyAssessor.getId());
    	hyMaterial.setId(hyAssessor.getMaterialId());
    	hyMaterial.setState("3");
    	hyMaterial.setSpecimen(hyAssessor.getHySpecimen().getSysUser().getUserName());
    	hyMaterial.setSpecimendept(hyAssessor.getHySpecimen().getSysDept().getDeptName());
    	//hyMaterialMapper.updateHyMaterial(hyMaterial);
        return hyMaterialServiceImpl.updateHyMaterials(hyMaterial);
    }
    
    /**
     * 修改审核管理出库
     * 
     * @param hyAssessor 审核管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAssessors(HyAssessor hyAssessor)
    {
    	List<HyAssessor> list = hyAssessorMapper.selectHyAssessorList(hyAssessor);
    	hyAssessor = list.get(0);
    	Long materialId = hyAssessor.getMaterialId();
    	HyStockRecord hyStockRecord = new HyStockRecord();
    	hyStockRecord.setMaterialId(materialId);
    	List<HyStockRecord> list1 = hyStockRecordMapper.selectHyStockRecordList(hyStockRecord);
    	hyStockRecord = list1.get(0);
    	hyStockRecord.setOutboundTime(DateUtils.getNowDate());
    	if(hyStockRecord.getOutboundNumber()!=null) {
    		Long outboundNumber1 = list1.get(0).getOutboundNumber();
    		int outboundNumber2 =(int) (outboundNumber1+1);
    		Long outboundNumber3 = (long) outboundNumber2;
    		hyStockRecord.setOutboundNumber(outboundNumber3);
    		hyStockRecordMapper.updateHyStockRecord(hyStockRecord);
    	}else if(hyStockRecord.getOutboundNumber()==null){
    		Long outboundNumber = (long) 1;
        	hyStockRecord.setOutboundNumber(outboundNumber);
        	hyStockRecordMapper.updateHyStockRecord(hyStockRecord);
    	}
    	HyLifting hyLifting = new HyLifting();
    	hyLifting.setMaterialId(materialId);
    	List<HyLifting> list2 = hyLiftingMapper.selectHyLiftingList(hyLifting);
    	hyLifting= list2.get(0);
    	String materialUse = hyLifting.getMaterialUse();
    	HyBill hyBill = new HyBill();
    	hyBill.setMaterialId(materialId);
    	List<HyBill> list3 = hyBillMapper.selectHyBillList(hyBill);
    	hyBill = list3.get(0);
    	hyBill.setMaterialUse(materialUse);
    	hyBillMapper.updateHyBill(hyBill);
    	HyDelivery hyDelivery = new HyDelivery();
    	Long liftingId =hyLifting.getId();
    	hyDelivery.setLiftingId(liftingId);
    	hyDeliveryMapper.insertHyDelivery(hyDelivery);
    	HyMaterial hyMaterial = new HyMaterial();
    	hyMaterial.setState("3");
    	hyMaterial.setId(materialId);
    	Long AssessorId = hyAssessor.getId();
    	hyAssessorMapper.deleteHyAssessorById(AssessorId);
    	return hyMaterialMapper.updateHyMaterial(hyMaterial);
    }

    /**
     * 删除审核管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAssessorByIds(String ids)
    {
        return hyAssessorMapper.deleteHyAssessorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审核管理信息
     * 
     * @param id 审核管理ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAssessorById(Long id)
    {
        return hyAssessorMapper.deleteHyAssessorById(id);
    }
}
