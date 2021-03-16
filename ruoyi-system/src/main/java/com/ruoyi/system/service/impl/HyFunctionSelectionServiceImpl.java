package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyFunctionSelectionMapper;
import com.ruoyi.system.domain.HyFunctionSelection;
import com.ruoyi.system.service.IHyFunctionSelectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 功能选择Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-16
 */
@Service
public class HyFunctionSelectionServiceImpl implements IHyFunctionSelectionService 
{
    @Autowired
    private HyFunctionSelectionMapper hyFunctionSelectionMapper;

    /**
     * 查询功能选择
     * 
     * @param id 功能选择ID
     * @return 功能选择
     */
    @Override
    public HyFunctionSelection selectHyFunctionSelectionById(Long id)
    {
        return hyFunctionSelectionMapper.selectHyFunctionSelectionById(id);
    }

    /**
     * 查询功能选择列表
     * 
     * @param hyFunctionSelection 功能选择
     * @return 功能选择
     */
    @Override
    public List<HyFunctionSelection> selectHyFunctionSelectionList(HyFunctionSelection hyFunctionSelection)
    {
        return hyFunctionSelectionMapper.selectHyFunctionSelectionList(hyFunctionSelection);
    }

    /**
     * 新增功能选择
     * 
     * @param hyFunctionSelection 功能选择
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyFunctionSelection(HyFunctionSelection hyFunctionSelection)
    {
        return hyFunctionSelectionMapper.insertHyFunctionSelection(hyFunctionSelection);
    }

    /**
     * 修改功能选择
     * 
     * @param hyFunctionSelection 功能选择
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyFunctionSelection(HyFunctionSelection hyFunctionSelection)
    {
        return hyFunctionSelectionMapper.updateHyFunctionSelection(hyFunctionSelection);
    }

    /**
     * 删除功能选择对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFunctionSelectionByIds(String ids)
    {
        return hyFunctionSelectionMapper.deleteHyFunctionSelectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除功能选择信息
     * 
     * @param id 功能选择ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFunctionSelectionById(Long id)
    {
        return hyFunctionSelectionMapper.deleteHyFunctionSelectionById(id);
    }
}
