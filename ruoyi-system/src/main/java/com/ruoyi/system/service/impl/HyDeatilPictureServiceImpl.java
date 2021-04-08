package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDeatilPictureMapper;
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.service.IHyDeatilPictureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品详情的图片
Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-08
 */
@Service
public class HyDeatilPictureServiceImpl implements IHyDeatilPictureService 
{
    @Autowired
    private HyDeatilPictureMapper hyDeatilPictureMapper;

    /**
     * 查询商品详情的图片

     * 
     * @param id 商品详情的图片
ID
     * @return 商品详情的图片

     */
    @Override
    public HyDeatilPicture selectHyDeatilPictureById(Long id)
    {
        return hyDeatilPictureMapper.selectHyDeatilPictureById(id);
    }

    /**
     * 查询商品详情的图片
列表
     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 商品详情的图片

     */
    @Override
    public List<HyDeatilPicture> selectHyDeatilPictureList(HyDeatilPicture hyDeatilPicture)
    {
        return hyDeatilPictureMapper.selectHyDeatilPictureList(hyDeatilPicture);
    }

    /**
     * 新增商品详情的图片

     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDeatilPicture(HyDeatilPicture hyDeatilPicture)
    {
        return hyDeatilPictureMapper.insertHyDeatilPicture(hyDeatilPicture);
    }

    /**
     * 修改商品详情的图片

     * 
     * @param hyDeatilPicture 商品详情的图片

     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDeatilPicture(HyDeatilPicture hyDeatilPicture)
    {
        return hyDeatilPictureMapper.updateHyDeatilPicture(hyDeatilPicture);
    }

    /**
     * 删除商品详情的图片
对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeatilPictureByIds(String ids)
    {
        return hyDeatilPictureMapper.deleteHyDeatilPictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品详情的图片
信息
     * 
     * @param id 商品详情的图片
ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeatilPictureById(Long id)
    {
        return hyDeatilPictureMapper.deleteHyDeatilPictureById(id);
    }
}
