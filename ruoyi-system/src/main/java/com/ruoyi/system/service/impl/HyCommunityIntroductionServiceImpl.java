package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyCommunityIntroductionMapper;
import com.ruoyi.system.domain.HyCommunityIntroduction;
import com.ruoyi.system.service.IHyCommunityIntroductionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区简介Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Service
public class HyCommunityIntroductionServiceImpl implements IHyCommunityIntroductionService 
{
    @Autowired
    private HyCommunityIntroductionMapper hyCommunityIntroductionMapper;

    /**
     * 查询社区简介
     * 
     * @param id 社区简介ID
     * @return 社区简介
     */
    @Override
    public HyCommunityIntroduction selectHyCommunityIntroductionById(Long id)
    {
        return hyCommunityIntroductionMapper.selectHyCommunityIntroductionById(id);
    }

    /**
     * 查询社区简介列表
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 社区简介
     */
    @Override
    public List<HyCommunityIntroduction> selectHyCommunityIntroductionList(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return hyCommunityIntroductionMapper.selectHyCommunityIntroductionList(hyCommunityIntroduction);
    }

    /**
     * 新增社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return hyCommunityIntroductionMapper.insertHyCommunityIntroduction(hyCommunityIntroduction);
    }

    /**
     * 修改社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return hyCommunityIntroductionMapper.updateHyCommunityIntroduction(hyCommunityIntroduction);
    }

    /**
     * 删除社区简介对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityIntroductionByIds(String ids)
    {
        return hyCommunityIntroductionMapper.deleteHyCommunityIntroductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区简介信息
     * 
     * @param id 社区简介ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityIntroductionById(Long id)
    {
        return hyCommunityIntroductionMapper.deleteHyCommunityIntroductionById(id);
    }
}
