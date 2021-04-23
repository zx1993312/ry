package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAssessorMapper;
import com.ruoyi.system.mapper.HyBillMapper;
import com.ruoyi.system.mapper.HyCheckMapper;
import com.ruoyi.system.mapper.HyInventoryMapper;
import com.ruoyi.system.mapper.HyMaterialMapper;
import com.ruoyi.system.mapper.HyStockRecordMapper;
import com.ruoyi.system.domain.HyAssessor;
import com.ruoyi.system.domain.HyBill;
import com.ruoyi.system.domain.HyCheck;
import com.ruoyi.system.domain.HyInventory;
import com.ruoyi.system.domain.HyMaterial;
import com.ruoyi.system.domain.HyStockRecord;
import com.ruoyi.system.service.IHyMaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物料Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyMaterialServiceImpl implements IHyMaterialService 
{
    @Autowired
    private HyMaterialMapper hyMaterialMapper;
    
    @Autowired
    private HyAssessorMapper hyAssessorMapper;
    
    @Autowired
    private HyInventoryMapper hyInventoryMapper;
    
    @Autowired
    private HyCheckMapper hyCheckMapper;
    
    @Autowired
    private HyBillMapper hyBillMapper;
    
    @Autowired
    private HyStockRecordMapper hyStockRecordMapper;
    /**
     * 查询物料
     * 
     * @param id 物料ID
     * @return 物料
     */
    @Override
    public HyMaterial selectHyMaterialById(Long id)
    {
        return hyMaterialMapper.selectHyMaterialById(id);
    }

    /**
     * 查询物料列表
     * 
     * @param hyMaterial 物料
     * @return 物料
     */
    @Override
    public List<HyMaterial> selectHyMaterialList(HyMaterial hyMaterial)
    {
        return hyMaterialMapper.selectHyMaterialList(hyMaterial);
    }

    /**
     * 新增物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaterial(HyMaterial hyMaterial)
    {
    	hyMaterial.setMaterialCode(new Date().getTime());
        hyMaterial.setCreateTime(DateUtils.getNowDate());
        return hyMaterialMapper.insertHyMaterial(hyMaterial);
    }

    /**
     * 修改物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaterial(HyMaterial hyMaterial)
    {
    	Long materialId = hyMaterial.getId();
    	HyAssessor hyAssessor = new HyAssessor();
		hyAssessor.setMaterialId(materialId);
		hyAssessorMapper.insertHyAssessor(hyAssessor);
		HyInventory hyInventory = new HyInventory();
		hyInventory.setMaterialId(materialId);
		hyInventoryMapper.insertHyInventory(hyInventory);
        return hyMaterialMapper.updateHyMaterial(hyMaterial);
    }
    
    /**
     * 修改物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaterials(HyMaterial hyMaterial)
    {
    	Long materialId = hyMaterial.getId();
    	HyInventory hyInventory = new HyInventory();
    	hyInventory.setMaterialId(materialId);
    	List<HyInventory> list = hyInventoryMapper.selectHyInventoryList(hyInventory);
    	hyInventory = list.get(0);
    	Long checkId = hyInventory.getCheckId();
    	HyCheck hyCheck = new HyCheck();
    	hyCheck.setId(checkId);
    	List<HyCheck> list1 = hyCheckMapper.selectHyCheckList(hyCheck);
    	hyCheck = list1.get(0);
    	String checkmen = hyCheck.getHyEmployee().getEmployeeName();
    	hyMaterial.setCheckmen(checkmen);
    	Long assessorId = hyMaterial.getAssessorId();
    	hyAssessorMapper.deleteHyAssessorById(assessorId);
    	HyBill hyBill = new HyBill();
    	hyBill.setMaterialId(materialId);
    	hyBill.setIsStock("是");
    	hyBillMapper.insertHyBill(hyBill);
    	HyStockRecord hyStockRecord = new HyStockRecord();
    	hyStockRecord.setMaterialId(materialId);
    	hyStockRecord.setState("是");
    	List<HyStockRecord> list2 = hyStockRecordMapper.selectHyStockRecordList(hyStockRecord);
    	if(list2.size()!=0) {
    		Long warehouseNumber1 = list2.get(0).getWarehouseNumber();
    		int warehouseNumber2 =(int) (warehouseNumber1+1);
    		Long warehouseNumber3 = (long) warehouseNumber2;
    		hyStockRecord.setWarehouseNumber(warehouseNumber3);
    		hyStockRecord.setWarehouseTime(DateUtils.getNowDate());
    		hyStockRecordMapper.updateHyStockRecord(hyStockRecord);
    	}else if(list2.size()==0) {
    		Long warehouseNumber = (long) 1;
        	hyStockRecord.setWarehouseNumber(warehouseNumber);
        	hyStockRecord.setMaterialId(materialId);
        	hyStockRecord.setWarehouseTime(DateUtils.getNowDate());
        	hyStockRecordMapper.insertHyStockRecord(hyStockRecord);
    	}
    	
    	return hyMaterialMapper.updateHyMaterial(hyMaterial);
    }

    /**
     * 删除物料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaterialByIds(String ids)
    {
    	
        return hyMaterialMapper.deleteHyMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物料信息
     * 
     * @param id 物料ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaterialById(Long id)
    {
        return hyMaterialMapper.deleteHyMaterialById(id);
    }
}
