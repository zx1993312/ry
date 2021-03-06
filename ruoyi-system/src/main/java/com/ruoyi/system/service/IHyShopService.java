package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyShop;

/**
 * 店铺Service接口
 * 
 * @author Administrator
 * @date 2021-03-05
 */
public interface IHyShopService 
{
    /**
     * 查询店铺
     * 
     * @param id 店铺ID
     * @return 店铺
     */
    public HyShop selectHyShopById(Long id);

    /**
     * 查询店铺列表
     * 
     * @param hyShop 店铺
     * @return 店铺集合
     */
    public List<HyShop> selectHyShopList(HyShop hyShop);
    
    public List<HyShop> selectHyShopVoDistinct(HyShop hyShop);

    /**
     * 查询店铺列表（测试方法）
     * @param hyShop
     * @return
     */
    public List<HyShop> selectHyShopListTest(HyShop hyShop);
    
    /**
     * 新增店铺
     * 
     * @param hyShop 店铺
     * @return 结果
     */
    public int insertHyShop(HyShop hyShop);

    /**
     * 修改店铺
     * 
     * @param hyShop 店铺
     * @return 结果
     */
    public int updateHyShop(HyShop hyShop);

    /**
     * 批量删除店铺
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyShopByIds(String ids);

    /**
     * 删除店铺信息
     * 
     * @param id 店铺ID
     * @return 结果
     */
    public int deleteHyShopById(Long id);
}
