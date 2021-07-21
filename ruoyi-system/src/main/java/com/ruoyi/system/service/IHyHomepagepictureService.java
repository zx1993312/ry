package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyHomepagepicture;

/**
 * 首页轮播图Service接口
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public interface IHyHomepagepictureService 
{
    /**
     * 查询首页轮播图
     * 
     * @param id 首页轮播图ID
     * @return 首页轮播图
     */
    public HyHomepagepicture selectHyHomepagepictureById(Long id);

    /**
     * 查询首页轮播图列表
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 首页轮播图集合
     */
    public List<HyHomepagepicture> selectHyHomepagepictureList(HyHomepagepicture hyHomepagepicture);
    
    /**
     * 查询首页轮播图列表App
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 首页轮播图集合
     */
    public List<HyHomepagepicture> selectHyHomepagepictureListByState(HyHomepagepicture hyHomepagepicture);

    /**
     * 新增首页轮播图
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 结果
     */
    public int insertHyHomepagepicture(HyHomepagepicture hyHomepagepicture);

    /**
     * 修改首页轮播图
     * 
     * @param hyHomepagepicture 首页轮播图
     * @return 结果
     */
    public int updateHyHomepagepicture(HyHomepagepicture hyHomepagepicture);

    /**
     * 批量删除首页轮播图
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyHomepagepictureByIds(String ids);

    /**
     * 删除首页轮播图信息
     * 
     * @param id 首页轮播图ID
     * @return 结果
     */
    public int deleteHyHomepagepictureById(Long id);
    
    /**
     * 删除上传图片
     * @return
     */
	public boolean deleteFile(String fileName);
}
