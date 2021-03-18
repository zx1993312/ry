package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HySetMealMapper;
import com.ruoyi.system.domain.HySetMeal;
import com.ruoyi.system.service.IHySetMealService;
import com.ruoyi.common.core.text.Convert;

/**
 * 套餐Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Service
public class HySetMealServiceImpl implements IHySetMealService 
{
    @Autowired
    private HySetMealMapper hySetMealMapper;

    /**
     * 查询套餐
     * 
     * @param id 套餐ID
     * @return 套餐
     */
    @Override
    public HySetMeal selectHySetMealById(Long id)
    {
        return hySetMealMapper.selectHySetMealById(id);
    }

    /**
     * 查询套餐列表
     * 
     * @param hySetMeal 套餐
     * @return 套餐
     */
    @Override
    public List<HySetMeal> selectHySetMealList(HySetMeal hySetMeal)
    {
        return hySetMealMapper.selectHySetMealList(hySetMeal);
    }

    /**
     * 新增套餐
     * 
     * @param hySetMeal 套餐
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHySetMeal(HySetMeal hySetMeal)
    {
        return hySetMealMapper.insertHySetMeal(hySetMeal);
    }

    /**
     * 修改套餐
     * 
     * @param hySetMeal 套餐
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHySetMeal(HySetMeal hySetMeal)
    {
        return hySetMealMapper.updateHySetMeal(hySetMeal);
    }

    /**
     * 删除套餐对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySetMealByIds(String ids)
    {
        return hySetMealMapper.deleteHySetMealByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除套餐信息
     * 
     * @param id 套餐ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySetMealById(Long id)
    {
        return hySetMealMapper.deleteHySetMealById(id);
    }
}
