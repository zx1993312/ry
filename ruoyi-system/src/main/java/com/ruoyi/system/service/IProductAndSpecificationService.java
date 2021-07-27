package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ProductAndSpecification;

/**
 * 商品和规格关联Service接口
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public interface IProductAndSpecificationService 
{
    /**
     * 查询商品和规格关联
     * 
     * @param productId 商品和规格关联ID
     * @return 商品和规格关联
     */
    public ProductAndSpecification selectProductAndSpecificationById(Long productId);

    /**
     * 查询商品和规格关联列表
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 商品和规格关联集合
     */
    public List<ProductAndSpecification> selectProductAndSpecificationList(ProductAndSpecification productAndSpecification);

    /**
     * 新增商品和规格关联
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 结果
     */
    public int insertProductAndSpecification(ProductAndSpecification productAndSpecification);

    /**
     * 修改商品和规格关联
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 结果
     */
    public int updateProductAndSpecification(ProductAndSpecification productAndSpecification);

    /**
     * 批量删除商品和规格关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductAndSpecificationByIds(String ids);

    /**
     * 删除商品和规格关联信息
     * 
     * @param productId 商品和规格关联ID
     * @return 结果
     */
    public int deleteProductAndSpecificationById(Long productId);
}
