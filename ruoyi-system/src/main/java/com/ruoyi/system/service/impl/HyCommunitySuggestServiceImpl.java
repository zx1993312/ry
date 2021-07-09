package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCommunitySuggestMapper;
import com.ruoyi.system.domain.HyCommunitySuggest;
import com.ruoyi.system.service.IHyCommunitySuggestService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区建议Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-12
 */
@Service
public class HyCommunitySuggestServiceImpl implements IHyCommunitySuggestService 
{
    @Autowired
    private HyCommunitySuggestMapper hyCommunitySuggestMapper;

    /**
     * 查询社区建议
     * 
     * @param id 社区建议ID
     * @return 社区建议
     */
    @Override
    public HyCommunitySuggest selectHyCommunitySuggestById(Long id)
    {
        return hyCommunitySuggestMapper.selectHyCommunitySuggestById(id);
    }

    /**
     * 查询社区建议列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议
     */
    @Override
    public List<HyCommunitySuggest> selectHyCommunitySuggestList(HyCommunitySuggest hyCommunitySuggest)
    {
        return hyCommunitySuggestMapper.selectHyCommunitySuggestList(hyCommunitySuggest);
    }
    
    /**
     * 查询社区建议待审核列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议
     */
    @Override
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByAudit(HyCommunitySuggest hyCommunitySuggest)
    {
    	return hyCommunitySuggestMapper.selectHyCommunitySuggestListByAudit(hyCommunitySuggest);
    }
    /**
     * 查询社区建议已通过列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议
     */
    @Override
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByThrough(HyCommunitySuggest hyCommunitySuggest)
    {
    	return hyCommunitySuggestMapper.selectHyCommunitySuggestListByThrough(hyCommunitySuggest);
    }
    /**
     * 查询社区建议已拒绝列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议
     */
    @Override
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByRefusal(HyCommunitySuggest hyCommunitySuggest)
    {
    	return hyCommunitySuggestMapper.selectHyCommunitySuggestListByRefusal(hyCommunitySuggest);
    }

    /**
     * 新增社区建议
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunitySuggest(HyCommunitySuggest hyCommunitySuggest)
    {
        return hyCommunitySuggestMapper.insertHyCommunitySuggest(hyCommunitySuggest);
    }

    /**
     * 修改社区建议
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunitySuggest(HyCommunitySuggest hyCommunitySuggest)
    {
        return hyCommunitySuggestMapper.updateHyCommunitySuggest(hyCommunitySuggest);
    }

    /**
     * 删除社区建议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySuggestByIds(String ids)
    {
        return hyCommunitySuggestMapper.deleteHyCommunitySuggestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区建议信息
     * 
     * @param id 社区建议ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySuggestById(Long id)
    {
        return hyCommunitySuggestMapper.deleteHyCommunitySuggestById(id);
    }
}
