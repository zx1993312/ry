package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyProduct;

/**
 * 商品Service接口
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public interface IHyProductService {
	/**
	 * 查询商品
	 * 
	 * @param id 商品ID
	 * @return 商品
	 */
	public HyProduct selectHyProductById(Long id);
	
	/**
	 * 查询商品列表
	 * 
	 * @param hyProduct 商品
	 * @return 商品集合
	 */
	public List<HyProduct> selectHyProductList(HyProduct hyProduct);

	/**
	 * 新增商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	public int insertHyProduct(HyProduct hyProduct);

	/**
	 * 修改商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	public int updateHyProduct(HyProduct hyProduct);

	/**
	 * 批量删除商品
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyProductByIds(String ids);

	/**
	 * 删除商品信息
	 * 
	 * @param id 商品ID
	 * @return 结果
	 */
	public int deleteHyProductById(Long id);
	/**
     * 删除上传图片
     * @return
     */
	public boolean deleteFile(String fileName);
	
}
