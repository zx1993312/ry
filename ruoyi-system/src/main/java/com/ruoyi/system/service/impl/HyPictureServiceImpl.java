package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPictureMapper;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.service.IHyPictureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 图片Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-08
 */
@Service
public class HyPictureServiceImpl implements IHyPictureService 
{
    @Autowired
    private HyPictureMapper hyPictureMapper;

    /**
     * 查询图片
     * 
     * @param id 图片ID
     * @return 图片
     */
    @Override
    public HyPicture selectHyPictureById(Long id)
    {
        return hyPictureMapper.selectHyPictureById(id);
    }

    /**
     * 查询图片列表
     * 
     * @param hyPicture 图片
     * @return 图片
     */
    @Override
    public List<HyPicture> selectHyPictureList(HyPicture hyPicture)
    {
        return hyPictureMapper.selectHyPictureList(hyPicture);
    }

    /**
     * 新增图片
     * 
     * @param hyPicture 图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPicture(HyPicture hyPicture)
    {
        return hyPictureMapper.insertHyPicture(hyPicture);
    }

    /**
     * 修改图片
     * 
     * @param hyPicture 图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPicture(HyPicture hyPicture)
    {
        return hyPictureMapper.updateHyPicture(hyPicture);
    }

    /**
     * 删除图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPictureByIds(String ids)
    {
        return hyPictureMapper.deleteHyPictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图片信息
     * 
     * @param id 图片ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPictureById(Long id)
    {
        return hyPictureMapper.deleteHyPictureById(id);
    }
}
