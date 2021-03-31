package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyProduct;

/**
 * 产品Service接口
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public interface IHyProductService {
	/**
	 * 查询产品
	 * 
	 * @param id 产品ID
	 * @return 产品
	 */
	public HyProduct selectHyProductById(Long id);
	/**
	 * 查询产品，图片，套餐名，简介根据id
	 * @param id
	 * @return
	 */
	public HyProduct selectHyId(Long id);
	/**
	 * 查询产品列表
	 * 
	 * @param hyProduct 产品
	 * @return 产品集合
	 */
	public List<HyProduct> selectHyProductList(HyProduct hyProduct);

	/**
     * 查询产品列表(测试方法)
     * 
     * @param hyProduct 产品
     * @return 产品集合
     */
    public List<HyProduct> selectHyProductListTest(HyProduct hyProduct);

	/**
	 * 查询产品列表
	 * 
	 * @param hyProduct
	 * @return
	 */
	public List<HyProduct> selectHyProductVoDistinct(HyProduct hyProduct);

	/**
	 * 新增产品
	 * 
	 * @param hyProduct 产品
	 * @return 结果
	 */
	public int insertHyProduct(HyProduct hyProduct);

	/**
	 * 修改产品
	 * 
	 * @param hyProduct 产品
	 * @return 结果
	 */
	public int updateHyProduct(HyProduct hyProduct);

	/**
	 * 批量删除产品
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyProductByIds(String ids);

	/**
	 * 删除产品信息
	 * 
	 * @param id 产品ID
	 * @return 结果
	 */
	public int deleteHyProductById(Long id);
	/**
     * 删除上传图片
     * @return
     */
	public boolean deleteFile(String fileName);
	
}
