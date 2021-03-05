package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyShopMapper;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.service.IHyShopService;
import com.ruoyi.common.core.text.Convert;

/**
 * 店铺Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-05
 */
@Service
public class HyShopServiceImpl implements IHyShopService 
{
    @Autowired
    private HyShopMapper hyShopMapper;

    /**
     * 查询店铺
     * 
     * @param id 店铺ID
     * @return 店铺
     */
    @Override
    public HyShop selectHyShopById(Long id)
    {
        return hyShopMapper.selectHyShopById(id);
    }

    /**
     * 查询店铺列表
     * 
     * @param hyShop 店铺
     * @return 店铺
     */
    @Override
    public List<HyShop> selectHyShopList(HyShop hyShop)
    {
        return hyShopMapper.selectHyShopList(hyShop);
    }

    /**
     * 新增店铺
     * 
     * @param hyShop 店铺
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyShop(HyShop hyShop)
    {
        return hyShopMapper.insertHyShop(hyShop);
    }

    /**
     * 修改店铺
     * 
     * @param hyShop 店铺
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyShop(HyShop hyShop)
    {
        return hyShopMapper.updateHyShop(hyShop);
    }

    /**
     * 删除店铺对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyShopByIds(String ids)
    {
        return hyShopMapper.deleteHyShopByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除店铺信息
     * 
     * @param id 店铺ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyShopById(Long id)
    {
        return hyShopMapper.deleteHyShopById(id);
    }
}
