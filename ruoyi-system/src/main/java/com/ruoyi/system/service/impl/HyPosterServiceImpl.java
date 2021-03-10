package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPosterMapper;
import com.ruoyi.system.domain.HyPoster;
import com.ruoyi.system.service.IHyPosterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 海报Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Service
public class HyPosterServiceImpl implements IHyPosterService 
{
    @Autowired
    private HyPosterMapper hyPosterMapper;

    /**
     * 查询海报
     * 
     * @param id 海报ID
     * @return 海报
     */
    @Override
    public HyPoster selectHyPosterById(Long id)
    {
        return hyPosterMapper.selectHyPosterById(id);
    }

    /**
     * 查询海报列表
     * 
     * @param hyPoster 海报
     * @return 海报
     */
    @Override
    public List<HyPoster> selectHyPosterList(HyPoster hyPoster)
    {
        return hyPosterMapper.selectHyPosterList(hyPoster);
    }

    /**
     * 新增海报
     * 
     * @param hyPoster 海报
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPoster(HyPoster hyPoster)
    {
        return hyPosterMapper.insertHyPoster(hyPoster);
    }

    /**
     * 修改海报
     * 
     * @param hyPoster 海报
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPoster(HyPoster hyPoster)
    {
        return hyPosterMapper.updateHyPoster(hyPoster);
    }

    /**
     * 删除海报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPosterByIds(String ids)
    {
        return hyPosterMapper.deleteHyPosterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除海报信息
     * 
     * @param id 海报ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPosterById(Long id)
    {
        return hyPosterMapper.deleteHyPosterById(id);
    }
}
