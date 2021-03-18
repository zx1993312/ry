package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyResidentialQuartersPictureMapper;
import com.ruoyi.system.domain.HyResidentialQuartersPicture;
import com.ruoyi.system.service.IHyResidentialQuartersPictureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小区图片Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyResidentialQuartersPictureServiceImpl implements IHyResidentialQuartersPictureService 
{
    @Autowired
    private HyResidentialQuartersPictureMapper hyResidentialQuartersPictureMapper;

    /**
     * 查询小区图片
     * 
     * @param id 小区图片ID
     * @return 小区图片
     */
    @Override
    public HyResidentialQuartersPicture selectHyResidentialQuartersPictureById(Long id)
    {
        return hyResidentialQuartersPictureMapper.selectHyResidentialQuartersPictureById(id);
    }

    /**
     * 查询小区图片列表
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 小区图片
     */
    @Override
    public List<HyResidentialQuartersPicture> selectHyResidentialQuartersPictureList(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        return hyResidentialQuartersPictureMapper.selectHyResidentialQuartersPictureList(hyResidentialQuartersPicture);
    }

    /**
     * 新增小区图片
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyResidentialQuartersPicture(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        return hyResidentialQuartersPictureMapper.insertHyResidentialQuartersPicture(hyResidentialQuartersPicture);
    }

    /**
     * 修改小区图片
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyResidentialQuartersPicture(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        return hyResidentialQuartersPictureMapper.updateHyResidentialQuartersPicture(hyResidentialQuartersPicture);
    }

    /**
     * 删除小区图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyResidentialQuartersPictureByIds(String ids)
    {
        return hyResidentialQuartersPictureMapper.deleteHyResidentialQuartersPictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小区图片信息
     * 
     * @param id 小区图片ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyResidentialQuartersPictureById(Long id)
    {
        return hyResidentialQuartersPictureMapper.deleteHyResidentialQuartersPictureById(id);
    }
}
