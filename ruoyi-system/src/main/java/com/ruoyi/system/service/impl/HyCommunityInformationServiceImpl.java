package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCommunityInformationMapper;
import com.ruoyi.system.domain.HyCommunityInformation;
import com.ruoyi.system.service.IHyCommunityInformationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区资询Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-13
 */
@Service
public class HyCommunityInformationServiceImpl implements IHyCommunityInformationService 
{
    @Autowired
    private HyCommunityInformationMapper hyCommunityInformationMapper;

    /**
     * 查询社区资询
     * 
     * @param id 社区资询ID
     * @return 社区资询
     */
    @Override
    public HyCommunityInformation selectHyCommunityInformationById(Long id)
    {
        return hyCommunityInformationMapper.selectHyCommunityInformationById(id);
    }

    /**
     * 查询社区资询列表
     * 
     * @param hyCommunityInformation 社区资询
     * @return 社区资询
     */
    @Override
    public List<HyCommunityInformation> selectHyCommunityInformationList(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.selectHyCommunityInformationList(hyCommunityInformation);
    }

    /**
     * 新增社区资询
     * 
     * @param hyCommunityInformation 社区资询
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityInformation(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.insertHyCommunityInformation(hyCommunityInformation);
    }

    /**
     * 修改社区资询
     * 
     * @param hyCommunityInformation 社区资询
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityInformation(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.updateHyCommunityInformation(hyCommunityInformation);
    }

    /**
     * 删除社区资询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityInformationByIds(String ids)
    {
        return hyCommunityInformationMapper.deleteHyCommunityInformationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区资询信息
     * 
     * @param id 社区资询ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityInformationById(Long id)
    {
        return hyCommunityInformationMapper.deleteHyCommunityInformationById(id);
    }
}