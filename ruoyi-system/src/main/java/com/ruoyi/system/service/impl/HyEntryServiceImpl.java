package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.mapper.HyEntryMapper;
import com.ruoyi.system.service.IHyEntryService;

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
     * 查询收款管理 Collection management
     * 
     * @param id 收款管理 Collection managementID
     * @return 收款管理 Collection management
     */
    @Override
    public HyCollection selectHyCollectionById(Long id)
    {
        return hyEntryMapper.selectHyCollectionById(id);
    }

    /**
     * 查询收款管理 Collection management列表
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 收款管理 Collection management
     */
    @Override
    public List<HyCollection> selectHyCollectionList(HyCollection hyCollection)
    {
        return hyEntryMapper.selectHyCollectionList(hyCollection);
    }

    /**
     * 修改收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyCollection(HyCollection hyCollection)
    {
        return hyEntryMapper.updateHyCollection(hyCollection);
    }
}
