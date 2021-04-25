package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyInspectionResultMapper;
import com.ruoyi.system.domain.HyInspectionResult;
import com.ruoyi.system.service.IHyInspectionResultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检结果Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyInspectionResultServiceImpl implements IHyInspectionResultService 
{
    @Autowired
    private HyInspectionResultMapper hyInspectionResultMapper;

    /**
     * 查询巡检结果
     * 
     * @param id 巡检结果ID
     * @return 巡检结果
     */
    @Override
    public HyInspectionResult selectHyInspectionResultById(Long id)
    {
        return hyInspectionResultMapper.selectHyInspectionResultById(id);
    }

    /**
     * 查询巡检结果列表
     * 
     * @param hyInspectionResult 巡检结果
     * @return 巡检结果
     */
    @Override
    public List<HyInspectionResult> selectHyInspectionResultList(HyInspectionResult hyInspectionResult)
    {
        return hyInspectionResultMapper.selectHyInspectionResultList(hyInspectionResult);
    }

    /**
     * 新增巡检结果
     * 
     * @param hyInspectionResult 巡检结果
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyInspectionResult(HyInspectionResult hyInspectionResult)
    {
        return hyInspectionResultMapper.insertHyInspectionResult(hyInspectionResult);
    }

    /**
     * 修改巡检结果
     * 
     * @param hyInspectionResult 巡检结果
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyInspectionResult(HyInspectionResult hyInspectionResult)
    {
        return hyInspectionResultMapper.updateHyInspectionResult(hyInspectionResult);
    }

    /**
     * 删除巡检结果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionResultByIds(String ids)
    {
        return hyInspectionResultMapper.deleteHyInspectionResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检结果信息
     * 
     * @param id 巡检结果ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionResultById(Long id)
    {
        return hyInspectionResultMapper.deleteHyInspectionResultById(id);
    }
}
