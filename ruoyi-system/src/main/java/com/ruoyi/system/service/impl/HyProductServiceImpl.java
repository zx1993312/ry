package com.ruoyi.system.service.impl;

import java.util.List;

import org.apache.poi.poifs.property.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPictureMapper;
import com.ruoyi.system.mapper.HyProductMapper;
import com.ruoyi.system.domain.HyPicture;
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
public class HyProductServiceImpl implements IHyProductService {
	@Autowired
	private HyProductMapper hyProductMapper;

	@Autowired
    private HyPictureMapper hyPictureMapper;
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
		return hyProductMapper.selectHyProductListTest(hyProduct);
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
		HyPicture hyPicture = new HyPicture();
		String pcitureAddress = hyProduct.getHyPicture().getPcitureAddress();
		hyPicture.setPcitureAddress(pcitureAddress);
		String a = hyProductMapper.selectNextValue("hy_database", "hy_product");
		Long productId = Long.valueOf(a);
		hyPicture.setProductId(productId);
		int row = hyProductMapper.insertHyProduct(hyProduct);
		if(row>0) {
			return hyPictureMapper.insertHyPicture(hyPicture);
		}
		return 0;
		
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
		System.out.println("=========hyProduct==========="+hyProduct);
		HyPicture hyPicture = new HyPicture();
		Long productId = hyProduct.getId();
		System.out.println("=========productId==========="+productId);
		hyPicture.setProductId(productId);
		System.out.println("=========hyPicture.getProductId()==========="+hyPicture.getProductId());
		List<HyPicture> list = hyPictureMapper.selectHyPictureList(hyPicture);
		System.out.println("=========HyPicture的list==========="+list);
		HyPicture hy = (HyPicture)list.get(0);
		System.out.println("=========hy==========="+hy);
		Long id = hy.getId();
		System.out.println("=========HyPicture的id==========="+id);
		hyPicture.setId(id);
		String pcitureAddress = hyProduct.getHyPicture().getPcitureAddress();
		hyPicture.setPcitureAddress(pcitureAddress);
		System.out.println("=========HyPicture==========="+hyPicture);
		System.out.println("=========hyProduct==========="+hyProduct);
		int row = hyPictureMapper.updateHyPicture(hyPicture);
		if(row>0) {
			return hyProductMapper.updateHyProduct(hyProduct);
		}
		return 0;
		
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
