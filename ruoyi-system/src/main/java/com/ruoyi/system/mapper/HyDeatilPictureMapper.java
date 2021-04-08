package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyDeatilPicture;

/**
 * 商品详情的图片
Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-08
 */
public interface HyDeatilPictureMapper 
{
    /**
     * 查询商品详情的图片

     * 
     * @param id 商品详情的图片
ID
     * @return 商品详情的图片

     */
    public HyDeatilPicture selectHyDeatilPictureById(Long id);

    /**
     * 查询商品详情的图片
列表
     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 商品详情的图片
集合
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
     * 删除商品详情的图片

     * 
     * @param id 商品详情的图片
ID
     * @return 结果
     */
    public int deleteHyDeatilPictureById(Long id);

    /**
     * 批量删除商品详情的图片

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDeatilPictureByIds(String[] ids);
}
