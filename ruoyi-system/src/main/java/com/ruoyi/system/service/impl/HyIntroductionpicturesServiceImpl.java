package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyIntroductionpicturesMapper;
import com.ruoyi.system.domain.HyIntroductionpictures;
import com.ruoyi.system.service.IHyIntroductionpicturesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物业简介图片Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Service
public class HyIntroductionpicturesServiceImpl implements IHyIntroductionpicturesService 
{
    @Autowired
    private HyIntroductionpicturesMapper hyIntroductionpicturesMapper;

    /**
     * 查询物业简介图片
     * 
     * @param id 物业简介图片ID
     * @return 物业简介图片
     */
    @Override
    public HyIntroductionpictures selectHyIntroductionpicturesById(Long id)
    {
        return hyIntroductionpicturesMapper.selectHyIntroductionpicturesById(id);
    }

    /**
     * 查询物业简介图片列表
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 物业简介图片
     */
    @Override
    public List<HyIntroductionpictures> selectHyIntroductionpicturesList(HyIntroductionpictures hyIntroductionpictures)
    {
        return hyIntroductionpicturesMapper.selectHyIntroductionpicturesList(hyIntroductionpictures);
    }

    /**
     * 新增物业简介图片
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyIntroductionpictures(HyIntroductionpictures hyIntroductionpictures)
    {
        return hyIntroductionpicturesMapper.insertHyIntroductionpictures(hyIntroductionpictures);
    }

    /**
     * 修改物业简介图片
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyIntroductionpictures(HyIntroductionpictures hyIntroductionpictures)
    {
        return hyIntroductionpicturesMapper.updateHyIntroductionpictures(hyIntroductionpictures);
    }

    /**
     * 删除物业简介图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyIntroductionpicturesByIds(String ids)
    {
        return hyIntroductionpicturesMapper.deleteHyIntroductionpicturesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业简介图片信息
     * 
     * @param id 物业简介图片ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyIntroductionpicturesById(Long id)
    {
        return hyIntroductionpicturesMapper.deleteHyIntroductionpicturesById(id);
    }
}
