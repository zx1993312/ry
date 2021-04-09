package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;

import org.apache.poi.poifs.property.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyDeatilPictureMapper;
import com.ruoyi.system.mapper.HyPictureMapper;
import com.ruoyi.system.mapper.HyProductMapper;
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.domain.HyLable;
import com.ruoyi.system.domain.HyOrder;
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
	
	@Autowired
    private HyDeatilPictureMapper hyDeatilPictureMapper;
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
	 * 查询产品，图片，套餐名，简介根据id
	 * @param id
	 * @return
	 */
	public HyProduct selectHyId(Long id) {
		return hyProductMapper.selectHyId(id);
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
		HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
		String pictureAddress = hyProduct.getHyDeatilPicture().getDeatilPicture();
		System.out.println("=============pictureAddress============="+pictureAddress);
		String pictureAdd = pictureAddress.substring(0,pictureAddress.length()-1);
		System.out.println("=============pictureAdd============="+pictureAdd);
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
	 * 修改产品
	 * 
	 * @param hyProduct 产品
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyProduct(HyProduct hyProduct) {
		Long productId = hyProduct.getId();
		if(hyProduct.getHyDeatilPicture().getDeatilPicture()!=null||!"".equals(hyProduct.getHyDeatilPicture().getDeatilPicture())) {
			HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
			hyDeatilPicture.setProductId(productId);
			List<HyDeatilPicture> list1 =  hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
			for(HyDeatilPicture lists:list1) {
				hyDeatilPicture = lists;
	    		String deleteFiles = hyDeatilPicture.getDeatilPicture();
	    		deleteFile(deleteFiles);
			}
			String deatilPictures = hyProduct.getHyDeatilPicture().getDeatilPicture();
			String pictureAdd = deatilPictures.substring(0,deatilPictures.length()-1);
			String[]pictureArr = pictureAdd.split(",");
			int i =0;
			for(String picture:pictureArr) {
				HyDeatilPicture hyDeatilPictures =new HyDeatilPicture();
				if(list1.size()>i) {
					hyDeatilPictures = list1.get(i);
					hyDeatilPictures.setDeatilPicture(picture);
					hyDeatilPictureMapper.updateHyDeatilPicture(hyDeatilPictures);
				}
				if(list1.size()<=i) {
				hyDeatilPictures.setDeatilPicture(picture);
				hyDeatilPictures.setProductId(productId);
				hyDeatilPictureMapper.insertHyDeatilPicture(hyDeatilPictures);
				}
				i++;
			}
		}
		if(hyProduct.getHyPicture().getPcitureAddress()!=null||!"".equals(hyProduct.getHyPicture().getPcitureAddress())) {
			HyPicture hyPicture = new HyPicture();
			hyPicture.setProductId(productId);
			List<HyPicture> list = hyPictureMapper.selectHyPictureList(hyPicture);
			HyPicture hy = (HyPicture)list.get(0);
			Long id = hy.getId();
			String deleteFile = hy.getPcitureAddress();
			deleteFile(deleteFile);
			hyPicture.setId(id);
			String pcitureAddress = hyProduct.getHyPicture().getPcitureAddress();
			hyPicture.setPcitureAddress(pcitureAddress);
			hyPictureMapper.updateHyPicture(hyPicture);
		}
		
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
		String ida [] = ids.split(",");
    	for(String id:ida) {
    		Long idd = Long.valueOf(id);
    		HyProduct hyProduct = hyProductMapper.selectHyProductById(idd);
    		String fileName = hyProduct.getHyPicture().getPcitureAddress();
    		deleteFile(fileName);
    		HyPicture hyPicture = new HyPicture();
    		hyPicture.setProductId(idd);
    		List<HyPicture> list =  hyPictureMapper.selectHyPictureList(hyPicture);
    		hyPicture = list.get(0);
    		Long idf = hyPicture.getId();
    		hyPictureMapper.deleteHyPictureById(idf);
    		HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
    		hyDeatilPicture.setProductId(idd);
    		List<HyDeatilPicture> list1 =  hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
    		for(HyDeatilPicture lists:list1) {
    			hyDeatilPicture = lists;
        		Long idg = hyDeatilPicture.getId();
        		String deleteFiles = hyDeatilPicture.getDeatilPicture();
        		deleteFile(deleteFiles);
        		hyDeatilPictureMapper.deleteHyDeatilPictureById(idg);
    		}
    	}
    	
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
	/**
     * 删除上传图片
     * @return
     */
	@Override
	public boolean deleteFile(String fileName) {
		String fileName1 = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+fileName;
		File file = new File(fileName1);
		System.out.println("================file================"+file);
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
