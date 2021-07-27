package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommercialSpecification;

/**
 * 商品规格Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public interface HyCommercialSpecificationMapper 
{
    /**
     * 查询商品规格
     * 
     * @param id 商品规格ID
     * @return 商品规格
     */
    public HyCommercialSpecification selectHyCommercialSpecificationById(Long id);

    /**
     * 查询商品规格列表
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 商品规格集合
     */
    public List<HyCommercialSpecification> selectHyCommercialSpecificationList(HyCommercialSpecification hyCommercialSpecification);

    /**
     * 新增商品规格
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 结果
     */
    public int insertHyCommercialSpecification(HyCommercialSpecification hyCommercialSpecification);

    /**
     * 修改商品规格
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 结果
     */
    public int updateHyCommercialSpecification(HyCommercialSpecification hyCommercialSpecification);

    /**
     * 删除商品规格
     * 
     * @param id 商品规格ID
     * @return 结果
     */
    public int deleteHyCommercialSpecificationById(Long id);

    /**
     * 批量删除商品规格
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommercialSpecificationByIds(String[] ids);
}
