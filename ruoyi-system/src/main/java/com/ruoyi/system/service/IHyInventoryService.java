package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyInventory;

/**
 * 盘点管理Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyInventoryService 
{
    /**
     * 查询盘点管理
     * 
     * @param id 盘点管理ID
     * @return 盘点管理
     */
    public HyInventory selectHyInventoryById(Long id);

    /**
     * 查询盘点管理列表
     * 
     * @param hyInventory 盘点管理
     * @return 盘点管理集合
     */
    public List<HyInventory> selectHyInventoryList(HyInventory hyInventory);

    /**
     * 新增盘点管理
     * 
     * @param hyInventory 盘点管理
     * @return 结果
     */
    public int insertHyInventory(HyInventory hyInventory);

    /**
     * 修改盘点管理
     * 
     * @param hyInventory 盘点管理
     * @return 结果
     */
    public int updateHyInventory(HyInventory hyInventory);

    /**
     * 批量删除盘点管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyInventoryByIds(String ids);

    /**
     * 删除盘点管理信息
     * 
     * @param id 盘点管理ID
     * @return 结果
     */
    public int deleteHyInventoryById(Long id);
}
