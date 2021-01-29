package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyEntryMapper;
import com.ruoyi.system.domain.HyEntry;
import com.ruoyi.system.service.IHyEntryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 入账处理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Service
public class HyEntryServiceImpl implements IHyEntryService 
{
    @Autowired
    private HyEntryMapper hyEntryMapper;

    /**
     * 查询入账处理
     * 
     * @param id 入账处理ID
     * @return 入账处理
     */
    @Override
    public HyEntry selectHyEntryById(Long id)
    {
        return hyEntryMapper.selectHyEntryById(id);
    }

    /**
     * 查询入账处理列表
     * 
     * @param hyEntry 入账处理
     * @return 入账处理
     */
    @Override
    public List<HyEntry> selectHyEntryList(HyEntry hyEntry)
    {
        return hyEntryMapper.selectHyEntryList(hyEntry);
    }

    /**
     * 新增入账处理
     * 
     * @param hyEntry 入账处理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyEntry(HyEntry hyEntry)
    {
        return hyEntryMapper.insertHyEntry(hyEntry);
    }

    /**
     * 修改入账处理
     * 
     * @param hyEntry 入账处理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyEntry(HyEntry hyEntry)
    {
        return hyEntryMapper.updateHyEntry(hyEntry);
    }

    /**
     * 删除入账处理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyEntryByIds(String ids)
    {
        return hyEntryMapper.deleteHyEntryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除入账处理信息
     * 
     * @param id 入账处理ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyEntryById(Long id)
    {
        return hyEntryMapper.deleteHyEntryById(id);
    }
}
