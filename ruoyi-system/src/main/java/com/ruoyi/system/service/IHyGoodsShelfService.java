package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyGoodsShelf;

/**
 * 货架Service接口
 * 
 * @author Administrator
 * @date 2021-06-21
 */
public interface IHyGoodsShelfService 
{
    /**
     * 查询货架
     * 
     * @param id 货架ID
     * @return 货架
     */
    public HyGoodsShelf selectHyGoodsShelfById(Long id);

    /**
     * 查询货架列表
     * 
     * @param hyGoodsShelf 货架
     * @return 货架集合
     */
    public List<HyGoodsShelf> selectHyGoodsShelfList(HyGoodsShelf hyGoodsShelf);

    /**
     * 新增货架
     * 
     * @param hyGoodsShelf 货架
     * @return 结果
     */
    public int insertHyGoodsShelf(HyGoodsShelf hyGoodsShelf);

    /**
     * 修改货架
     * 
     * @param hyGoodsShelf 货架
     * @return 结果
     */
    public int updateHyGoodsShelf(HyGoodsShelf hyGoodsShelf);

    /**
     * 批量删除货架
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyGoodsShelfByIds(String ids);

    /**
     * 删除货架信息
     * 
     * @param id 货架ID
     * @return 结果
     */
    public int deleteHyGoodsShelfById(Long id);
}
