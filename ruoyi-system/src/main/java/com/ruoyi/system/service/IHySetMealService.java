package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HySetMeal;

/**
 * 套餐Service接口
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public interface IHySetMealService 
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
     * 查询套餐列表（测试方法）
     * @param hySetMeal
     * @return
     */
    public List<HySetMeal> selectHySetMealVoTest(HySetMeal hySetMeal);


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
     * 批量删除套餐
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHySetMealByIds(String ids);

    /**
     * 删除套餐信息
     * 
     * @param id 套餐ID
     * @return 结果
     */
    public int deleteHySetMealById(Long id);
}
