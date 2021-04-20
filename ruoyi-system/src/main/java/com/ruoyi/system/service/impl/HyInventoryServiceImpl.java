package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyInventoryMapper;
import com.ruoyi.system.domain.HyInventory;
import com.ruoyi.system.service.IHyInventoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 盘点管理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyInventoryServiceImpl implements IHyInventoryService 
{
    @Autowired
    private HyInventoryMapper hyInventoryMapper;

    /**
     * 查询盘点管理
     * 
     * @param id 盘点管理ID
     * @return 盘点管理
     */
    @Override
    public HyInventory selectHyInventoryById(Long id)
    {
        return hyInventoryMapper.selectHyInventoryById(id);
    }

    /**
     * 查询盘点管理列表
     * 
     * @param hyInventory 盘点管理
     * @return 盘点管理
     */
    @Override
    public List<HyInventory> selectHyInventoryList(HyInventory hyInventory)
    {
        return hyInventoryMapper.selectHyInventoryList(hyInventory);
    }

    /**
     * 新增盘点管理
     * 
     * @param hyInventory 盘点管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyInventory(HyInventory hyInventory)
    {
        return hyInventoryMapper.insertHyInventory(hyInventory);
    }

    /**
     * 修改盘点管理
     * 
     * @param hyInventory 盘点管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyInventory(HyInventory hyInventory)
    {
        return hyInventoryMapper.updateHyInventory(hyInventory);
    }

    /**
     * 删除盘点管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInventoryByIds(String ids)
    {
        return hyInventoryMapper.deleteHyInventoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点管理信息
     * 
     * @param id 盘点管理ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInventoryById(Long id)
    {
        return hyInventoryMapper.deleteHyInventoryById(id);
    }
}
