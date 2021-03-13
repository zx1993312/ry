package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyCommunityMapper;
import com.ruoyi.system.domain.HyCommunity;
import com.ruoyi.system.service.IHyCommunityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Service
public class HyCommunityServiceImpl implements IHyCommunityService 
{
    @Autowired
    private HyCommunityMapper hyCommunityMapper;

    /**
     * 查询社区
     * 
     * @param id 社区ID
     * @return 社区
     */
    @Override
    public HyCommunity selectHyCommunityById(Long id)
    {
        return hyCommunityMapper.selectHyCommunityById(id);
    }

    /**
     * 查询社区列表
     * 
     * @param hyCommunity 社区
     * @return 社区
     */
    @Override
    public List<HyCommunity> selectHyCommunityList(HyCommunity hyCommunity)
    {
        return hyCommunityMapper.selectHyCommunityList(hyCommunity);
    }

    /**
     * 新增社区
     * 
     * @param hyCommunity 社区
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunity(HyCommunity hyCommunity)
    {
        return hyCommunityMapper.insertHyCommunity(hyCommunity);
    }

    /**
     * 修改社区
     * 
     * @param hyCommunity 社区
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunity(HyCommunity hyCommunity)
    {
        return hyCommunityMapper.updateHyCommunity(hyCommunity);
    }

    /**
     * 删除社区对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityByIds(String ids)
    {
        return hyCommunityMapper.deleteHyCommunityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区信息
     * 
     * @param id 社区ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityById(Long id)
    {
        return hyCommunityMapper.deleteHyCommunityById(id);
    }
}
