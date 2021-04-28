package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyInspectionDetailMapper;
import com.ruoyi.system.domain.HyInspectionDetail;
import com.ruoyi.system.service.IHyInspectionDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检线路明细Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyInspectionDetailServiceImpl implements IHyInspectionDetailService 
{
    @Autowired
    private HyInspectionDetailMapper hyInspectionDetailMapper;

    /**
     * 查询巡检线路明细
     * 
     * @param id 巡检线路明细ID
     * @return 巡检线路明细
     */
    @Override
    public HyInspectionDetail selectHyInspectionDetailById(Long id)
    {
        return hyInspectionDetailMapper.selectHyInspectionDetailById(id);
    }

    /**
     * 查询巡检线路明细列表
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 巡检线路明细
     */
    @Override
    public List<HyInspectionDetail> selectHyInspectionDetailList(HyInspectionDetail hyInspectionDetail)
    {
        return hyInspectionDetailMapper.selectHyInspectionDetailList(hyInspectionDetail);
    }

    /**
     * 新增巡检线路明细
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyInspectionDetail(HyInspectionDetail hyInspectionDetail)
    {
        return hyInspectionDetailMapper.insertHyInspectionDetail(hyInspectionDetail);
    }

    /**
     * 修改巡检线路明细
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyInspectionDetail(HyInspectionDetail hyInspectionDetail)
    {
        return hyInspectionDetailMapper.updateHyInspectionDetail(hyInspectionDetail);
    }

    /**
     * 删除巡检线路明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionDetailByIds(String ids)
    {
        return hyInspectionDetailMapper.deleteHyInspectionDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检线路明细信息
     * 
     * @param id 巡检线路明细ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionDetailById(Long id)
    {
        return hyInspectionDetailMapper.deleteHyInspectionDetailById(id);
    }
}
