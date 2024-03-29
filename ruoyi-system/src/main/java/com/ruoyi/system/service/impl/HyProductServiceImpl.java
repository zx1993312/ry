package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyCommercialSpecification;
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.domain.ProductAndSpecification;
import com.ruoyi.system.mapper.HyCommercialSpecificationMapper;
import com.ruoyi.system.mapper.HyDeatilPictureMapper;
import com.ruoyi.system.mapper.HyPictureMapper;
import com.ruoyi.system.mapper.HyProductMapper;
import com.ruoyi.system.mapper.ProductAndSpecificationMapper;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.system.utils.HyListUtil;

/**
 * 商品Service业务层处理
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
	
	@Autowired
	private ProductAndSpecificationMapper productAndSpecificationMapper;
	
	@Autowired
	private HyCommercialSpecificationMapper hyCommercialSpecificationMapper;
	
	@Autowired
    private HyDeatilPictureMapper hyDeatilPictureMapper;
	/**
	 * 查询商品
	 * 
	 * @param id 商品ID
	 * @return 商品
	 */
	@Override
	public HyProduct selectHyProductById(Long id) {
		return hyProductMapper.selectHyProductById(id);
	}
	
	/**
	 * 查询商品列表
	 * 
	 * @param hyProduct 商品
	 * @return 商品
	 */
	@Override
	public List<HyProduct> selectHyProductList(HyProduct hyProduct) {
			return hyProductMapper.selectHyProductList(hyProduct);
	}
	
	
	/**
	 * 新增商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyProduct(HyProduct hyProduct) {
		String[] specificationIds = hyProduct.getSpecificationIds().split(",");
		HyPicture hyPicture = new HyPicture();
		String pictureAddress = hyProduct.getHyPicture().getPictureAddress();
		hyPicture.setPictureAddress(pictureAddress);
		String a = hyProductMapper.selectNextValue("hy_database", "hy_product");
		Long productId = Long.valueOf(a);
		for(String specificationId : specificationIds) {
			ProductAndSpecification productAndSpecification = new ProductAndSpecification();
			productAndSpecification.setProductId(productId);
			productAndSpecification.setSpecificationId(Long.valueOf(specificationId));
			productAndSpecificationMapper.insertProductAndSpecification(productAndSpecification);
		}
		hyPicture.setProductId(productId);
		HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
		String picturesAddress = hyProduct.getHyDeatilPicture().getDeatilPicture();
		String pictureAdd = picturesAddress.substring(0,picturesAddress.length()-1);
		String[]pictureArr = pictureAdd.split(",");
		int row1 = 0;
		for(String picture:pictureArr) {
		hyDeatilPicture.setDeatilPicture(picture);
		hyDeatilPicture.setProductId(productId);
		hyDeatilPictureMapper.insertHyDeatilPicture(hyDeatilPicture);
		row1++;
		}
		if(row1>0) {
			int row2 = hyPictureMapper.insertHyPicture(hyPicture);
			if(row1>0&&row2>0) {
				return hyProductMapper.insertHyProduct(hyProduct);
			}
		}
		return 0;
		
	}

	/**
	 * 修改商品
	 * 
	 * @param hyProduct 商品
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyProduct(HyProduct hyProduct) {
		Long productId = hyProduct.getId();
		if(StringUtils.isNotEmpty(hyProduct.getSpecificationIds())) {
			String[] specificationIds = hyProduct.getSpecificationIds().split(",");
 			List<HyCommercialSpecification> commercialSpecificationList = hyCommercialSpecificationMapper.selectHyCommercialSpecificationList(new HyCommercialSpecification());
 			String ids = "";
			for (HyCommercialSpecification commercialSpecification : commercialSpecificationList) {
				Long specificationId = commercialSpecification.getId();
				ids = ids + specificationId + ",";
			}
			String[] id = ids.split(",");
			String[] iii = HyListUtil.minus(specificationIds, id);
			for (String i : iii) {
				ProductAndSpecification pas = new ProductAndSpecification();
				pas.setProductId(productId);
				pas.setSpecificationId(Long.valueOf(i));
				List<ProductAndSpecification> list = productAndSpecificationMapper.selectProductAndSpecificationList(pas);
				if (list != null) {
					productAndSpecificationMapper.deleteProductIdAndSpecificationId(productId,Long.valueOf(i));
				}
			}
			for (String specificationId : specificationIds) {
				ProductAndSpecification pas = new ProductAndSpecification();
				pas.setProductId(productId);
				pas.setSpecificationId(Long.valueOf(specificationId));
				List<ProductAndSpecification> list = productAndSpecificationMapper.selectProductAndSpecificationList(pas);

				if (list.size() == 0) {
					productAndSpecificationMapper.insertProductAndSpecification(pas);
				}

			}
		}
		if(hyProduct.getHyDeatilPicture().getDeatilPicture()!=null && !"".equals(hyProduct.getHyDeatilPicture().getDeatilPicture())) {
			HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
			hyDeatilPicture.setProductId(productId);
			List<HyDeatilPicture> list1 =  hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
			for(HyDeatilPicture lists:list1) {
				hyDeatilPicture = lists;
	    		String deleteFiles = hyDeatilPicture.getDeatilPicture();
	    		deleteFile(deleteFiles);
	    		hyDeatilPictureMapper.deleteHyDeatilPictureById(hyDeatilPicture.getId());
			}
			String deatilPictures = hyProduct.getHyDeatilPicture().getDeatilPicture();
			String pictureAdd = deatilPictures.substring(0,deatilPictures.length()-1);
			String[]pictureArr = pictureAdd.split(",");
			for(String picture:pictureArr) {
				HyDeatilPicture hyDeatilPictures =new HyDeatilPicture();
				hyDeatilPictures.setDeatilPicture(picture);
				hyDeatilPictures.setProductId(productId);
				hyDeatilPictureMapper.insertHyDeatilPicture(hyDeatilPictures);
			}
		}
		if(hyProduct.getHyPicture().getPictureAddress()!=null && !"".equals(hyProduct.getHyPicture().getPictureAddress())) {
			HyPicture hyPicture = new HyPicture();
			hyPicture.setProductId(productId);
			List<HyPicture> list = hyPictureMapper.selectHyPictureList(hyPicture);
			if(StringUtils.isNotEmpty(list)) {
				HyPicture hy = list.get(0);
				Long id = hy.getId();
				String deleteFile = hy.getPictureAddress();
				deleteFile(deleteFile);
				hyPicture.setId(id);
				String pictureAddress = hyProduct.getHyPicture().getPictureAddress();
				hyPicture.setPictureAddress(pictureAddress);
				hyPictureMapper.updateHyPicture(hyPicture);
			}else {
				String pictureAddress = hyProduct.getHyPicture().getPictureAddress();
				hyPicture.setPictureAddress(pictureAddress);
				hyPictureMapper.insertHyPicture(hyPicture);
			}
			
		}
		
		return hyProductMapper.updateHyProduct(hyProduct);
	}

	/**
	 * 删除商品对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyProductByIds(String ids) {
		String ida [] = ids.split(",");
    	for(String id:ida) {
    		HyPicture hyPicture = new HyPicture();
    		hyPicture.setProductId(Long.valueOf(id));
    		List<HyPicture> list =  hyPictureMapper.selectHyPictureList(hyPicture);
    		hyPicture = list.get(0);
    		String fileName = hyPicture.getPictureAddress();
    		deleteFile(fileName);
    		hyPictureMapper.deleteHyPictureById(hyPicture.getId());
    		HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
    		hyDeatilPicture.setProductId(Long.valueOf(id));
    		List<HyDeatilPicture> deatilPictureList =  hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
    		for(HyDeatilPicture deatilPicture : deatilPictureList) {
        		String deleteFiles = deatilPicture.getDeatilPicture();
        		deleteFile(deleteFiles);
        		hyDeatilPictureMapper.deleteHyDeatilPictureById(deatilPicture.getId());
    		}
    	}
    	
    		return hyProductMapper.deleteHyProductByIds(Convert.toStrArray(ids));
    	
	}

	/**
	 * 删除商品信息
	 * 
	 * @param id 商品ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyProductById(Long id) {
		HyPicture hyPicture = new HyPicture();
		hyPicture.setProductId(id);
		List<HyPicture> list =  hyPictureMapper.selectHyPictureList(hyPicture);
		hyPicture = list.get(0);
		String fileName = hyPicture.getPictureAddress();
		deleteFile(fileName);
		hyPictureMapper.deleteHyPictureById(hyPicture.getId());
		HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
		hyDeatilPicture.setProductId(id);
		List<HyDeatilPicture> deatilPictureList =  hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
		for(HyDeatilPicture deatilPicture : deatilPictureList) {
    		String deleteFiles = deatilPicture.getDeatilPicture();
    		deleteFile(deleteFiles);
    		hyDeatilPictureMapper.deleteHyDeatilPictureById(deatilPicture.getId());
		}
		return hyProductMapper.deleteHyProductById(id);
	}
	
	/**
     * 删除上传图片
     * @return
     */
	@Override
	public boolean deleteFile(String fileName) {
		String fileName1 = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+fileName;
		File file = new File(fileName1);
		//判断文件存不存在
		if(!file.exists()){
			System.out.println("删除文件失败："+fileName+"不存在！");
			return false;
		}else{
			//判断这是不是一个文件，ps：有可能是文件夹
			if(file.isFile()){
				return file.delete();
			}
		}
		return false;
	}
	
	
}
