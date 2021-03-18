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
 * 社区咨询Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-15
 */
@Service
public class HyCommunityInformationServiceImpl implements IHyCommunityInformationService 
{
    @Autowired
    private HyCommunityInformationMapper hyCommunityInformationMapper;

    /**
     * 查询社区咨询
     * 
     * @param id 社区咨询ID
     * @return 社区咨询
     */
    @Override
    public HyCommunityInformation selectHyCommunityInformationById(Long id)
    {
        return hyCommunityInformationMapper.selectHyCommunityInformationById(id);
    }

    /**
     * 查询社区咨询列表
     * 
     * @param hyCommunityInformation 社区咨询
     * @return 社区咨询
     */
    @Override
    public List<HyCommunityInformation> selectHyCommunityInformationList(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.selectHyCommunityInformationList(hyCommunityInformation);
    }

    /**
     * 新增社区咨询
     * 
     * @param hyCommunityInformation 社区咨询
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityInformation(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.insertHyCommunityInformation(hyCommunityInformation);
    }

    /**
     * 修改社区咨询
     * 
     * @param hyCommunityInformation 社区咨询
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityInformation(HyCommunityInformation hyCommunityInformation)
    {
        return hyCommunityInformationMapper.updateHyCommunityInformation(hyCommunityInformation);
    }

    /**
     * 删除社区咨询对象
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
     * 删除社区咨询信息
     * 
     * @param id 社区咨询ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityInformationById(Long id)
    {
        return hyCommunityInformationMapper.deleteHyCommunityInformationById(id);
    }
}
