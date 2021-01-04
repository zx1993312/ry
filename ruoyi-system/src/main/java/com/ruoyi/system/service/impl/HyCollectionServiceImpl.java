package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收款管理 Collection managementService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class HyCollectionServiceImpl implements IHyCollectionService 
{
    @Autowired
    private HyCollectionMapper hyCollectionMapper;

    /**
     * 查询收款管理 Collection management
     * 
     * @param id 收款管理 Collection managementID
     * @return 收款管理 Collection management
     */
    @Override
    public HyCollection selectHyCollectionById(Long id)
    {
        return hyCollectionMapper.selectHyCollectionById(id);
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
        return hyCollectionMapper.selectHyCollectionList(hyCollection);
    }

    /**
     * 新增收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    @Override
    public int insertHyCollection(HyCollection hyCollection)
    {
        return hyCollectionMapper.insertHyCollection(hyCollection);
    }

    /**
     * 修改收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    @Override
    public int updateHyCollection(HyCollection hyCollection)
    {
        return hyCollectionMapper.updateHyCollection(hyCollection);
    }

    /**
     * 删除收款管理 Collection management对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyCollectionByIds(String ids)
    {
        return hyCollectionMapper.deleteHyCollectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收款管理 Collection management信息
     * 
     * @param id 收款管理 Collection managementID
     * @return 结果
     */
    @Override
    public int deleteHyCollectionById(Long id)
    {
        return hyCollectionMapper.deleteHyCollectionById(id);
    }
}
