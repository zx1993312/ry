package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyScrapMapper;
import com.ruoyi.system.domain.HyScrap;
import com.ruoyi.system.service.IHyScrapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备报废申请Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Service
public class HyScrapServiceImpl implements IHyScrapService 
{
    @Autowired
    private HyScrapMapper hyScrapMapper;

    /**
     * 查询设备报废申请
     * 
     * @param id 设备报废申请ID
     * @return 设备报废申请
     */
    @Override
    public HyScrap selectHyScrapById(Long id)
    {
        return hyScrapMapper.selectHyScrapById(id);
    }

    /**
     * 查询设备报废申请列表
     * 
     * @param hyScrap 设备报废申请
     * @return 设备报废申请
     */
    @Override
    public List<HyScrap> selectHyScrapList(HyScrap hyScrap)
    {
        return hyScrapMapper.selectHyScrapList(hyScrap);
    }

    /**
     * 新增设备报废申请
     * 
     * @param hyScrap 设备报废申请
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyScrap(HyScrap hyScrap)
    {
        return hyScrapMapper.insertHyScrap(hyScrap);
    }

    /**
     * 修改设备报废申请
     * 
     * @param hyScrap 设备报废申请
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyScrap(HyScrap hyScrap)
    {
        return hyScrapMapper.updateHyScrap(hyScrap);
    }

    /**
     * 删除设备报废申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyScrapByIds(String ids)
    {
        return hyScrapMapper.deleteHyScrapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备报废申请信息
     * 
     * @param id 设备报废申请ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyScrapById(Long id)
    {
        return hyScrapMapper.deleteHyScrapById(id);
    }
}
