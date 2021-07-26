package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyCommunityIntroduction;
import com.ruoyi.system.domain.HyIntroductionpictures;
import com.ruoyi.system.mapper.HyCommunityIntroductionMapper;
import com.ruoyi.system.mapper.HyIntroductionpicturesMapper;
import com.ruoyi.system.service.IHyCommunityIntroductionService;

/**
 * 社区简介Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Service
public class HyCommunityIntroductionServiceImpl implements IHyCommunityIntroductionService 
{
    @Autowired
    private HyCommunityIntroductionMapper hyCommunityIntroductionMapper;
    
    @Autowired
    private HyIntroductionpicturesMapper hyIntroductionpicturesMapper;

    /**
     * 查询社区简介
     * 
     * @param id 社区简介ID
     * @return 社区简介
     */
    @Override
    public HyCommunityIntroduction selectHyCommunityIntroductionById(Long id)
    {
        return hyCommunityIntroductionMapper.selectHyCommunityIntroductionById(id);
    }

    /**
     * 查询社区简介列表
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 社区简介
     */
    @Override
    public List<HyCommunityIntroduction> selectHyCommunityIntroductionList(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return hyCommunityIntroductionMapper.selectHyCommunityIntroductionList(hyCommunityIntroduction);
    }

    /**
     * 新增社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction)
    {
    	int row = 0;
    	row = hyCommunityIntroductionMapper.insertHyCommunityIntroduction(hyCommunityIntroduction);
    	if(row>0) {
    		if(StringUtils.isNotEmpty(hyCommunityIntroduction.getIntroductionPhotoAddress())) {
    			String[] introductionPhotoAddress = hyCommunityIntroduction.getIntroductionPhotoAddress().split(",");
    			hyCommunityIntroduction = hyCommunityIntroductionMapper.selectHyCommunityIntroductionList(hyCommunityIntroduction).get(0);
    			Long introductionId = hyCommunityIntroduction.getId();
            	for(String introductionPicture : introductionPhotoAddress) {
            		HyIntroductionpictures hyIntroductionpictures = new HyIntroductionpictures();
            		hyIntroductionpictures.setIntroductionPicture(introductionPicture);
            		hyIntroductionpictures.setIntroductionId(introductionId);
            		hyIntroductionpicturesMapper.insertHyIntroductionpictures(hyIntroductionpictures);
            	}
    		}
    	}
        return row;
    }

    /**
     * 修改社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction)
    {
    	Long introductionId = hyCommunityIntroduction.getId();
    	if(StringUtils.isNotEmpty(hyCommunityIntroduction.getIntroductionPhotoAddress())) {
    		String[] introductionPhotoAddress = hyCommunityIntroduction.getIntroductionPhotoAddress().split(",");
    		HyIntroductionpictures hyIntroductionpictures = new HyIntroductionpictures();
    		hyIntroductionpictures.setIntroductionId(introductionId);
    		List<HyIntroductionpictures> list = hyIntroductionpicturesMapper.selectHyIntroductionpicturesList(hyIntroductionpictures);
    		for(HyIntroductionpictures introductionpictures : list) {
    			String deletePicture = introductionpictures.getIntroductionPicture();
    			deleteFile(deletePicture);
    			hyIntroductionpicturesMapper.deleteHyIntroductionpicturesById(introductionpictures.getId());
    		}
			for(String introductionPicture : introductionPhotoAddress) {
				HyIntroductionpictures introductionpictures = new HyIntroductionpictures();
				introductionpictures.setIntroductionPicture(introductionPicture);
				introductionpictures.setIntroductionId(introductionId);
				hyIntroductionpicturesMapper.insertHyIntroductionpictures(introductionpictures);
			}
    	};
    	
        return hyCommunityIntroductionMapper.updateHyCommunityIntroduction(hyCommunityIntroduction);
    }

    /**
     * 删除社区简介对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityIntroductionByIds(String ids)
    {
    	String ida [] = ids.split(",");
    	for(String id:ida) {
    		HyIntroductionpictures hyIntroductionpictures = new HyIntroductionpictures();
    		hyIntroductionpictures.setIntroductionId(Long.valueOf(id));
    		List<HyIntroductionpictures> list = hyIntroductionpicturesMapper.selectHyIntroductionpicturesList(hyIntroductionpictures);
    		for(HyIntroductionpictures introductionpictures : list) {
        		String deleteFiles = introductionpictures.getIntroductionPicture();
        		deleteFile(deleteFiles);
        		hyIntroductionpicturesMapper.deleteHyIntroductionpicturesById(introductionpictures.getId());
    		}
    	}
        return hyCommunityIntroductionMapper.deleteHyCommunityIntroductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区简介信息
     * 
     * @param id 社区简介ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityIntroductionById(Long id)
    {
    	HyIntroductionpictures hyIntroductionpictures = new HyIntroductionpictures();
		hyIntroductionpictures.setIntroductionId(id);
		List<HyIntroductionpictures> list = hyIntroductionpicturesMapper.selectHyIntroductionpicturesList(hyIntroductionpictures);
		for(HyIntroductionpictures introductionpictures : list) {
    		String deleteFiles = introductionpictures.getIntroductionPicture();
    		deleteFile(deleteFiles);
    		hyIntroductionpicturesMapper.deleteHyIntroductionpicturesById(introductionpictures.getId());
		}
        return hyCommunityIntroductionMapper.deleteHyCommunityIntroductionById(id);
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
