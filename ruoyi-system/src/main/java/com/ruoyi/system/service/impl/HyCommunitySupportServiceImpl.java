package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyCommunitySupportMapper;
import com.ruoyi.system.domain.HyCommunitySupport;
import com.ruoyi.system.service.IHyCommunitySupportService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区配套Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Service
public class HyCommunitySupportServiceImpl implements IHyCommunitySupportService 
{
    @Autowired
    private HyCommunitySupportMapper hyCommunitySupportMapper;

    /**
     * 查询社区配套
     * 
     * @param id 社区配套ID
     * @return 社区配套
     */
    @Override
    public HyCommunitySupport selectHyCommunitySupportById(Long id)
    {
        return hyCommunitySupportMapper.selectHyCommunitySupportById(id);
    }

    /**
     * 查询社区配套列表
     * 
     * @param hyCommunitySupport 社区配套
     * @return 社区配套
     */
    @Override
    public List<HyCommunitySupport> selectHyCommunitySupportList(HyCommunitySupport hyCommunitySupport)
    {
        return hyCommunitySupportMapper.selectHyCommunitySupportList(hyCommunitySupport);
    }

    /**
     * 新增社区配套
     * 
     * @param hyCommunitySupport 社区配套
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunitySupport(HyCommunitySupport hyCommunitySupport)
    {
        return hyCommunitySupportMapper.insertHyCommunitySupport(hyCommunitySupport);
    }

    /**
     * 修改社区配套
     * 
     * @param hyCommunitySupport 社区配套
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunitySupport(HyCommunitySupport hyCommunitySupport)
    {
        return hyCommunitySupportMapper.updateHyCommunitySupport(hyCommunitySupport);
    }

    /**
     * 删除社区配套对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySupportByIds(String ids)
    {
        return hyCommunitySupportMapper.deleteHyCommunitySupportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区配套信息
     * 
     * @param id 社区配套ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySupportById(Long id)
    {
        return hyCommunitySupportMapper.deleteHyCommunitySupportById(id);
    }
}
