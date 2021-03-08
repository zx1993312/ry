package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HySetMeal;

/**
 * 套餐Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public interface HySetMealMapper 
{
    /**
     * 查询套餐
     * 
     * @param id 套餐ID
     * @return 套餐
     */
    public HySetMeal selectHySetMealById(Long id);

    /**
     * 查询套餐列表
     * 
     * @param hySetMeal 套餐
     * @return 套餐集合
     */
    public List<HySetMeal> selectHySetMealList(HySetMeal hySetMeal);

    /**
     * 新增套餐
     * 
     * @param hySetMeal 套餐
     * @return 结果
     */
    public int insertHySetMeal(HySetMeal hySetMeal);

    /**
     * 修改套餐
     * 
     * @param hySetMeal 套餐
     * @return 结果
     */
    public int updateHySetMeal(HySetMeal hySetMeal);

    /**
     * 删除套餐
     * 
     * @param id 套餐ID
     * @return 结果
     */
    public int deleteHySetMealById(Long id);

    /**
     * 批量删除套餐
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHySetMealByIds(String[] ids);
}
