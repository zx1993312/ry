package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyShoppingCartMapper;
import com.ruoyi.system.domain.HyShoppingCart;
import com.ruoyi.system.service.IHyShoppingCartService;
import com.ruoyi.common.core.text.Convert;

/**
 * 购物车Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-16
 */
@Service
public class HyShoppingCartServiceImpl implements IHyShoppingCartService 
{
    @Autowired
    private HyShoppingCartMapper hyShoppingCartMapper;

    /**
     * 查询购物车
     * 
     * @param id 购物车ID
     * @return 购物车
     */
    @Override
    public HyShoppingCart selectHyShoppingCartById(Long id)
    {
        return hyShoppingCartMapper.selectHyShoppingCartById(id);
    }

    /**
     * 查询购物车列表
     * 
     * @param hyShoppingCart 购物车
     * @return 购物车
     */
    @Override
    public List<HyShoppingCart> selectHyShoppingCartList(HyShoppingCart hyShoppingCart)
    {
        return hyShoppingCartMapper.selectHyShoppingCartList(hyShoppingCart);
    }

    /**
     * 新增购物车
     * 
     * @param hyShoppingCart 购物车
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyShoppingCart(HyShoppingCart hyShoppingCart)
    {
        return hyShoppingCartMapper.insertHyShoppingCart(hyShoppingCart);
    }

    /**
     * 修改购物车
     * 
     * @param hyShoppingCart 购物车
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyShoppingCart(HyShoppingCart hyShoppingCart)
    {
        return hyShoppingCartMapper.updateHyShoppingCart(hyShoppingCart);
    }

    /**
     * 删除购物车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyShoppingCartByIds(String ids)
    {
        return hyShoppingCartMapper.deleteHyShoppingCartByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除购物车信息
     * 
     * @param id 购物车ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyShoppingCartById(Long id)
    {
        return hyShoppingCartMapper.deleteHyShoppingCartById(id);
    }
}
