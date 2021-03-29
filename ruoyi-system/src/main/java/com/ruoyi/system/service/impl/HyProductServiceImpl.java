package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyProductMapper;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Service
public class HyProductServiceImpl implements /*继承*/ IHyProductService /*service接口*/ {
	/**
	 * 注入mapper接口
	 */
	@Autowired
	private HyProductMapper hyProductMapper;

	/**
	 * 查询产品
	 * 
	 * @param id 产品ID
	 * @return 产品
	 */
	@Override
	public HyProduct selectHyProductById(Long id) {
		return hyProductMapper.selectHyProductById(id);
	}

	/**
	 * 查询产品列表
	 * 
	 * @param hyProduct 产品
	 * @return 产品
	 */
	@Override
	public List<HyProduct> selectHyProductList(HyProduct hyProduct) {
		return hyProductMapper.selectHyProductList(hyProduct);
	}
	
	
	/**
	 * 查询产品列表(测试方法)
	 * 
	 * @param hyProduct 产品
	 * @return 产品
	 */

	@Override
	public List<HyProduct> selectHyProductListTest(HyProduct hyProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增产品
	 * 
	 * @param hyProduct 产品
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyProduct(HyProduct hyProduct) {
		return hyProductMapper.insertHyProduct(hyProduct);
	}

	/**
	 * 修改产品
	 * 
	 * @param hyProduct 产品
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyProduct(HyProduct hyProduct) {
		return hyProductMapper.updateHyProduct(hyProduct);
	}

	/**
	 * 删除产品对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyProductByIds(String ids) {
		return hyProductMapper.deleteHyProductByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除产品信息
	 * 
	 * @param id 产品ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyProductById(Long id) {
		return hyProductMapper.deleteHyProductById(id);
	}

	/**
	 * 查询产品
	 * 
	 * @param hyProduct 产品
	 * @return 产品
	 */
	@Override
	public List<HyProduct> selectHyProductVoDistinct(HyProduct hyProduct) {
		return hyProductMapper.selectHyProductVoDistinct(hyProduct);
	}

}
