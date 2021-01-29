package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyControlSetMapper;
import com.ruoyi.system.domain.HyControlSet;
import com.ruoyi.system.service.IHyControlSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 管控模型设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-07
 */
@Service
public class HyControlSetServiceImpl implements IHyControlSetService 
{
    @Autowired
    private HyControlSetMapper hyControlSetMapper;

    /**
     * 查询管控模型设置
     * 
     * @param id 管控模型设置ID
     * @return 管控模型设置
     */
    @Override
    public HyControlSet selectHyControlSetById(Long id)
    {
        return hyControlSetMapper.selectHyControlSetById(id);
    }

    /**
     * 查询管控模型设置列表
     * 
     * @param hyControlSet 管控模型设置
     * @return 管控模型设置
     */
    @Override
    public List<HyControlSet> selectHyControlSetList(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.selectHyControlSetList(hyControlSet);
    }

    /**
     * 新增管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyControlSet(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.insertHyControlSet(hyControlSet);
    }

    /**
     * 修改管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyControlSet(HyControlSet hyControlSet)
    {
        return hyControlSetMapper.updateHyControlSet(hyControlSet);
    }

    /**
     * 删除管控模型设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyControlSetByIds(String ids)
    {
        return hyControlSetMapper.deleteHyControlSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除管控模型设置信息
     * 
     * @param id 管控模型设置ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyControlSetById(Long id)
    {
        return hyControlSetMapper.deleteHyControlSetById(id);
    }
}
