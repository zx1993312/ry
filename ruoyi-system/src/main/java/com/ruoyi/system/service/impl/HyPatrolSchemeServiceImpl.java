package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyPatrolSchemeMapper;
import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.service.IHyPatrolSchemeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检计划Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyPatrolSchemeServiceImpl implements IHyPatrolSchemeService 
{
    @Autowired
    private HyPatrolSchemeMapper hyPatrolSchemeMapper;

    /**
     * 查询巡检计划
     * 
     * @param id 巡检计划ID
     * @return 巡检计划
     */
    @Override
    public HyPatrolScheme selectHyPatrolSchemeById(Long id)
    {
        return hyPatrolSchemeMapper.selectHyPatrolSchemeById(id);
    }

    /**
     * 查询巡检计划列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划
     */
    @Override
    public List<HyPatrolScheme> selectHyPatrolSchemeList(HyPatrolScheme hyPatrolScheme)
    {
        return hyPatrolSchemeMapper.selectHyPatrolSchemeList(hyPatrolScheme);
    }
    
    /**
     * 查询巡检计划明细列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划
     */
    @Override
    public List<HyPatrolScheme> selectHyPatrolSchemeDetailList(HyPatrolScheme hyPatrolScheme)
    {
    	return hyPatrolSchemeMapper.selectHyPatrolSchemeDetailList(hyPatrolScheme);
    }

    /**
     * 新增巡检计划
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPatrolScheme(HyPatrolScheme hyPatrolScheme)
    {
        return hyPatrolSchemeMapper.insertHyPatrolScheme(hyPatrolScheme);
    }

    /**
     * 修改巡检计划
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPatrolScheme(HyPatrolScheme hyPatrolScheme)
    {
        return hyPatrolSchemeMapper.updateHyPatrolScheme(hyPatrolScheme);
    }

    /**
     * 删除巡检计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPatrolSchemeByIds(String ids)
    {
        return hyPatrolSchemeMapper.deleteHyPatrolSchemeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检计划信息
     * 
     * @param id 巡检计划ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPatrolSchemeById(Long id)
    {
        return hyPatrolSchemeMapper.deleteHyPatrolSchemeById(id);
    }
}
