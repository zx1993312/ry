package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPropertyMapper;
import com.ruoyi.system.domain.HyProperty;
import com.ruoyi.system.service.IHyPropertyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物业Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Service
public class HyPropertyServiceImpl implements IHyPropertyService 
{
    @Autowired
    private HyPropertyMapper hyPropertyMapper;

    /**
     * 查询物业
     * 
     * @param id 物业ID
     * @return 物业
     */
    @Override
    public HyProperty selectHyPropertyById(Long id)
    {
        return hyPropertyMapper.selectHyPropertyById(id);
    }

    /**
     * 查询物业列表
     * 
     * @param hyProperty 物业
     * @return 物业
     */
    @Override
    public List<HyProperty> selectHyPropertyList(HyProperty hyProperty)
    {
        return hyPropertyMapper.selectHyPropertyList(hyProperty);
    }

    /**
     * 新增物业
     * 
     * @param hyProperty 物业
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyProperty(HyProperty hyProperty)
    {
        return hyPropertyMapper.insertHyProperty(hyProperty);
    }

    /**
     * 修改物业
     * 
     * @param hyProperty 物业
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyProperty(HyProperty hyProperty)
    {
        return hyPropertyMapper.updateHyProperty(hyProperty);
    }

    /**
     * 删除物业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPropertyByIds(String ids)
    {
        return hyPropertyMapper.deleteHyPropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业信息
     * 
     * @param id 物业ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPropertyById(Long id)
    {
        return hyPropertyMapper.deleteHyPropertyById(id);
    }
}
