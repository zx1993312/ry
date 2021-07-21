package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyHomepagepictureMapper;
import com.ruoyi.system.domain.HyHomepagepicture;
import com.ruoyi.system.service.IHyHomepagepictureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页轮播图Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-21
 */
@Service
public class HyHomepagepictureServiceImpl implements IHyHomepagepictureService 
{
    @Autowired
    private HyHomepagepictureMapper hyHomepagepictureMapper;

    /**
     * 查询首页轮播图
     * 
     * @param id 首页轮播图ID
     * @return 首页轮播图
     */
    @Override
    public HyHomepagepicture selectHyHomepagepictureById(Long id)
    {
        return hyHomepagepictureMapper.selectHyHomepagepictureById(id);
    }

    /**
     * 查询首页轮播图列表
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 首页轮播图
     */
    @Override
    public List<HyHomepagepicture> selectHyHomepagepictureList(HyHomepagepicture hyHomepagepicture)
    {
        return hyHomepagepictureMapper.selectHyHomepagepictureList(hyHomepagepicture);
    }
    
    /**
     * 查询首页轮播图列表App
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 首页轮播图
     */
    @Override
    public List<HyHomepagepicture> selectHyHomepagepictureListByState(HyHomepagepicture hyHomepagepicture)
    {
    	return hyHomepagepictureMapper.selectHyHomepagepictureListByState(hyHomepagepicture);
    }

    /**
     * 新增首页轮播图
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyHomepagepicture(HyHomepagepicture hyHomepagepicture)
    {
        hyHomepagepicture.setCreateTime(DateUtils.getNowDate());
        return hyHomepagepictureMapper.insertHyHomepagepicture(hyHomepagepicture);
    }

    /**
     * 修改首页轮播图
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyHomepagepicture(HyHomepagepicture hyHomepagepicture)
    {
    	if(hyHomepagepicture.getPicture()!=null&&!"".equals(hyHomepagepicture.getPicture())) {
    		String deleteFile = hyHomepagepicture.getDeleteFile();
    		deleteFile(deleteFile);
    	}
        return hyHomepagepictureMapper.updateHyHomepagepicture(hyHomepagepicture);
    }

    /**
     * 删除首页轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyHomepagepictureByIds(String ids)
    {
    	String[] idz = ids.split(",");
    	for(String id : idz) {
    		HyHomepagepicture hyHomepagepicture = hyHomepagepictureMapper.selectHyHomepagepictureById(Long.valueOf(id));
    		String deleteFile = hyHomepagepicture.getPicture();
    		deleteFile(deleteFile);
    	}
        return hyHomepagepictureMapper.deleteHyHomepagepictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页轮播图信息
     * 
     * @param id 首页轮播图ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyHomepagepictureById(Long id)
    {
    	HyHomepagepicture hyHomepagepicture = hyHomepagepictureMapper.selectHyHomepagepictureById(id);
		String deleteFile = hyHomepagepicture.getPicture();
		deleteFile(deleteFile);
        return hyHomepagepictureMapper.deleteHyHomepagepictureById(id);
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
