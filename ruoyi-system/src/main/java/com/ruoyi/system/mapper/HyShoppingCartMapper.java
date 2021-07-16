package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyShoppingCart;

/**
 * 购物车Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-16
 */
public interface HyShoppingCartMapper 
{
    /**
     * 查询购物车
     * 
     * @param id 购物车ID
     * @return 购物车
     */
    public HyShoppingCart selectHyShoppingCartById(Long id);

    /**
     * 查询购物车列表
     * 
     * @param hyShoppingCart 购物车
     * @return 购物车集合
     */
    public List<HyShoppingCart> selectHyShoppingCartList(HyShoppingCart hyShoppingCart);

    /**
     * 新增购物车
     * 
     * @param hyShoppingCart 购物车
     * @return 结果
     */
    public int insertHyShoppingCart(HyShoppingCart hyShoppingCart);

    /**
     * 修改购物车
     * 
     * @param hyShoppingCart 购物车
     * @return 结果
     */
    public int updateHyShoppingCart(HyShoppingCart hyShoppingCart);

    /**
     * 删除购物车
     * 
     * @param id 购物车ID
     * @return 结果
     */
    public int deleteHyShoppingCartById(Long id);

    /**
     * 批量删除购物车
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyShoppingCartByIds(String[] ids);
}
