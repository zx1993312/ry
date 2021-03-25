package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPicture;

/**
 * 图片Service接口
 * 
 * @author Administrator
 * @date 2021-03-08
 */
public interface IHyPictureService 
{
    /**
     * 查询图片
     * 
     * @param id 图片ID
     * @return 图片
     */
    public HyPicture selectHyPictureById(Long id);

    /**
     * 查询图片列表
     * 
     * @param hyPicture 图片
     * @return 图片集合
     */
    public List<HyPicture> selectHyPictureList(HyPicture hyPicture);
    /**
     * 根据图片地址查询图片列表
     * @param hyPicture
     * @return
     */
    public List<HyPicture> selectHyPictureAddress(HyPicture hyPicture);

    /**
     * 新增图片
     * 
     * @param hyPicture 图片
     * @return 结果
     */
    public int insertHyPicture(HyPicture hyPicture);

    /**
     * 修改图片
     * 
     * @param hyPicture 图片
     * @return 结果
     */
    public int updateHyPicture(HyPicture hyPicture);

    /**
     * 批量删除图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPictureByIds(String ids);

    /**
     * 删除图片信息
     * 
     * @param id 图片ID
     * @return 结果
     */
    public int deleteHyPictureById(Long id);
}
