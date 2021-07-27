package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.ProductAndSpecification;

/**
 * 商品和规格关联Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public interface ProductAndSpecificationMapper 
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
     * 删除商品和规格关联
     * 
     * @param productId 商品和规格关联ID
     * @return 结果
     */
    public int deleteProductAndSpecificationById(Long productId);

    /**
     * 批量删除商品和规格关联
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductAndSpecificationByIds(String[] productIds);
    
    /**
     * 删除商品和规格关联通过商品ID和规格ID
     * 
     * @param productId 商品和规格关联ID
     * @return 结果
     */
	public int deleteProductIdAndSpecificationId(@Param("productId") Long productId,@Param("specificationId") Long specificationId);
}
