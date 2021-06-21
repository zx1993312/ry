package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyGoodsShelfMapper;
import com.ruoyi.system.domain.HyGoodsShelf;
import com.ruoyi.system.service.IHyGoodsShelfService;
import com.ruoyi.common.core.text.Convert;

/**
 * 货架Service业务层处理
 * 
 * @author Administrator
 * @date 2021-06-21
 */
@Service
public class HyGoodsShelfServiceImpl implements IHyGoodsShelfService 
{
    @Autowired
    private HyGoodsShelfMapper hyGoodsShelfMapper;

    /**
     * 查询货架
     * 
     * @param id 货架ID
     * @return 货架
     */
    @Override
    public HyGoodsShelf selectHyGoodsShelfById(Long id)
    {
        return hyGoodsShelfMapper.selectHyGoodsShelfById(id);
    }

    /**
     * 查询货架列表
     * 
     * @param hyGoodsShelf 货架
     * @return 货架
     */
    @Override
    public List<HyGoodsShelf> selectHyGoodsShelfList(HyGoodsShelf hyGoodsShelf)
    {
        return hyGoodsShelfMapper.selectHyGoodsShelfList(hyGoodsShelf);
    }

    /**
     * 新增货架
     * 
     * @param hyGoodsShelf 货架
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyGoodsShelf(HyGoodsShelf hyGoodsShelf)
    {
        return hyGoodsShelfMapper.insertHyGoodsShelf(hyGoodsShelf);
    }

    /**
     * 修改货架
     * 
     * @param hyGoodsShelf 货架
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyGoodsShelf(HyGoodsShelf hyGoodsShelf)
    {
        return hyGoodsShelfMapper.updateHyGoodsShelf(hyGoodsShelf);
    }

    /**
     * 删除货架对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyGoodsShelfByIds(String ids)
    {
        return hyGoodsShelfMapper.deleteHyGoodsShelfByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除货架信息
     * 
     * @param id 货架ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyGoodsShelfById(Long id)
    {
        return hyGoodsShelfMapper.deleteHyGoodsShelfById(id);
    }
}
