package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyLableMapper;
import com.ruoyi.system.domain.HyLable;
import com.ruoyi.system.service.IHyLableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 标签Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-16
 */
@Service
public class HyLableServiceImpl implements IHyLableService 
{
    @Autowired
    private HyLableMapper hyLableMapper;

    /**
     * 查询标签
     * 
     * @param id 标签ID
     * @return 标签
     */
    @Override
    public HyLable selectHyLableById(Long id)
    {
        return hyLableMapper.selectHyLableById(id);
    }

    /**
     * 查询标签列表
     * 
     * @param hyLable 标签
     * @return 标签
     */
    @Override
    public List<HyLable> selectHyLableList(HyLable hyLable)
    {
        return hyLableMapper.selectHyLableList(hyLable);
    }

    /**
     * 新增标签
     * 
     * @param hyLable 标签
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyLable(HyLable hyLable)
    {
        return hyLableMapper.insertHyLable(hyLable);
    }

    /**
     * 修改标签
     * 
     * @param hyLable 标签
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyLable(HyLable hyLable)
    {
        return hyLableMapper.updateHyLable(hyLable);
    }

    /**
     * 删除标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyLableByIds(String ids)
    {
        return hyLableMapper.deleteHyLableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除标签信息
     * 
     * @param id 标签ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyLableById(Long id)
    {
        return hyLableMapper.deleteHyLableById(id);
    }
}
