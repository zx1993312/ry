package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.ProductAndSpecificationMapper;
import com.ruoyi.system.domain.ProductAndSpecification;
import com.ruoyi.system.service.IProductAndSpecificationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品和规格关联Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Service
public class ProductAndSpecificationServiceImpl implements IProductAndSpecificationService 
{
    @Autowired
    private ProductAndSpecificationMapper productAndSpecificationMapper;

    /**
     * 查询商品和规格关联
     * 
     * @param productId 商品和规格关联ID
     * @return 商品和规格关联
     */
    @Override
    public ProductAndSpecification selectProductAndSpecificationById(Long productId)
    {
        return productAndSpecificationMapper.selectProductAndSpecificationById(productId);
    }

    /**
     * 查询商品和规格关联列表
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 商品和规格关联
     */
    @Override
    public List<ProductAndSpecification> selectProductAndSpecificationList(ProductAndSpecification productAndSpecification)
    {
        return productAndSpecificationMapper.selectProductAndSpecificationList(productAndSpecification);
    }

    /**
     * 新增商品和规格关联
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertProductAndSpecification(ProductAndSpecification productAndSpecification)
    {
        return productAndSpecificationMapper.insertProductAndSpecification(productAndSpecification);
    }

    /**
     * 修改商品和规格关联
     * 
     * @param productAndSpecification 商品和规格关联
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateProductAndSpecification(ProductAndSpecification productAndSpecification)
    {
        return productAndSpecificationMapper.updateProductAndSpecification(productAndSpecification);
    }

    /**
     * 删除商品和规格关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteProductAndSpecificationByIds(String ids)
    {
        return productAndSpecificationMapper.deleteProductAndSpecificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品和规格关联信息
     * 
     * @param productId 商品和规格关联ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteProductAndSpecificationById(Long productId)
    {
        return productAndSpecificationMapper.deleteProductAndSpecificationById(productId);
    }
}
