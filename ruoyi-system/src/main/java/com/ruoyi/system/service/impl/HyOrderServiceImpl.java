package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyOrderMapper;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.service.IHyOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-15
 */
@Service
public class HyOrderServiceImpl implements IHyOrderService 
{
    @Autowired
    private HyOrderMapper hyOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public HyOrder selectHyOrderById(Long id)
    {
        return hyOrderMapper.selectHyOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderList(HyOrder hyOrder)
    {
        return hyOrderMapper.selectHyOrderList(hyOrder);
    }
    
    /**
     * 查询订单列表（测试方法）
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
	public List<HyOrder> selectHyOrderListTest(HyOrder hyOrder) {
		return hyOrderMapper.selectHyOrderListTest(hyOrder);
	}
    /**
     * 查询订单装态
     */
    public List<HyOrder> selectHyOrderState(HyOrder hyOrder){
    	return hyOrderMapper.selectHyOrderState(hyOrder);
    }
    
    /**
     * 新增订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyOrder(HyOrder hyOrder)
    {
        return hyOrderMapper.insertHyOrder(hyOrder);
    }

    /**
     * 修改订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyOrder(HyOrder hyOrder)
    {
    	System.out.println("===============hyOrder============="+hyOrder);
        return hyOrderMapper.updateHyOrder(hyOrder);
    }

    /**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOrderByIds(String ids)
    {
        return hyOrderMapper.deleteHyOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOrderById(Long id)
    {
        return hyOrderMapper.deleteHyOrderById(id);
    }
    /**
     * 删除上传图片
     * @return
     */
	@Override
	public boolean deleteFile(String fileName) {
		String fileName1 = "C:\\Users\\Administrator\\Desktop\\hykj\\ry\\ruoyi-admin\\src\\main\\resources\\static\\img\\"+fileName;
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
