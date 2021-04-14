package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDeatilPicture;

/**
 * 商品详情的图片Service接口
 * 
 * @author Administrator
 * @date 2021-04-08
 */
public interface IHyDeatilPictureService{ 

    /**
       * 查询商品详情的图片

     * 
     * @param id 商品详情的图片ID
     * @return 商品详情的图片

     */
    public HyDeatilPicture selectHyDeatilPictureById(Long id);

    /**
      * 查询商品详情的图片列表
     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 商品详情的图片集合
     */
    public List<HyDeatilPicture> selectHyDeatilPictureList(HyDeatilPicture hyDeatilPicture);

    /**
      * 新增商品详情的图片

     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 结果
     */
    public int insertHyDeatilPicture(HyDeatilPicture hyDeatilPicture);

    /**
       * 修改商品详情的图片

     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 结果
     */
    public int updateHyDeatilPicture(HyDeatilPicture hyDeatilPicture);

    /**
     * 批量删除商品详情的图片

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDeatilPictureByIds(String ids);

    /**
      * 删除商品详情的图片信息
     * 
     * @param id 商品详情的图片ID
     * @return 结果
     */
    public int deleteHyDeatilPictureById(Long id);
}
