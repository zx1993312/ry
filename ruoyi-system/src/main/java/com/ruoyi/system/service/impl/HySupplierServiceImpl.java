package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HySupplier;
import com.ruoyi.system.mapper.HySupplierMapper;
import com.ruoyi.system.service.IHySupplierService;

/**
 * 供应商Service业务层处理
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Service
public class HySupplierServiceImpl implements IHySupplierService 
{
    @Autowired
    private HySupplierMapper hySupplierMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    @Override
    public HySupplier selectHySupplierById(Long id)
    {
        return hySupplierMapper.selectHySupplierById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param hySupplier 供应商
     * @return 供应商
     */
    @Override
    public List<HySupplier> selectHySupplierList(HySupplier hySupplier)
    {
        return hySupplierMapper.selectHySupplierList(hySupplier);
    }

    /**
     * 新增供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHySupplier(HySupplier hySupplier)
    {
        return hySupplierMapper.insertHySupplier(hySupplier);
    }

    /**
     * 修改供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHySupplier(HySupplier hySupplier)
    {
    	if(!"".equals(hySupplier.getSupplierBusinessLicence())) {
    		String deleteFile = hySupplier.getDeleteFile();
    		deleteFile(deleteFile);
    	}
    	
        return hySupplierMapper.updateHySupplier(hySupplier);
    }

    /**
     * 删除供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySupplierByIds(String ids)
    {
    	String ida [] = ids.split(",");
    	for(String id:ida) {
    		Long idd = Long.valueOf(id);
    		HySupplier hySupplier = hySupplierMapper.selectHySupplierById(idd);
    		String fileName = hySupplier.getSupplierBusinessLicence();
    		deleteFile(fileName);
    	}
        return hySupplierMapper.deleteHySupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySupplierById(Long id)
    {
    	HySupplier hySupplier = hySupplierMapper.selectHySupplierById(id);
    	String fileName = hySupplier.getSupplierBusinessLicence();
		deleteFile(fileName);
        return hySupplierMapper.deleteHySupplierById(id);
    }
    
    /**
     * 删除上传图片
     * @return
     */
	@Override
	public boolean deleteFile(String fileName) {
		String fileName1 = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+fileName;
		File file = new File(fileName1);
		System.out.println("================file================"+file);
		//判断文件存不存在
		if(!file.exists()){
			System.out.println("删除文件失败："+fileName+"不存在！");
			return false;
		}else{
			//判断这是不是一个文件，ps：有可能是文件夹
			if(file.isFile()){
				return file.delete();
			}
		}
		return false;
	}
}
