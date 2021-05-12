package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAnnualplanMapper;
import com.ruoyi.system.domain.HyAnnualplan;
import com.ruoyi.system.service.IHyAnnualplanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 年度保养计划Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Service
public class HyAnnualplanServiceImpl implements IHyAnnualplanService 
{
    @Autowired
    private HyAnnualplanMapper hyAnnualplanMapper;

    /**
     * 查询年度保养计划
     * 
     * @param id 年度保养计划ID
     * @return 年度保养计划
     */
    @Override
    public HyAnnualplan selectHyAnnualplanById(Long id)
    {
        return hyAnnualplanMapper.selectHyAnnualplanById(id);
    }

    /**
     * 查询年度保养计划列表
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 年度保养计划
     */
    @Override
    public List<HyAnnualplan> selectHyAnnualplanList(HyAnnualplan hyAnnualplan)
    {
        return hyAnnualplanMapper.selectHyAnnualplanList(hyAnnualplan);
    }

    /**
     * 新增年度保养计划
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAnnualplan(HyAnnualplan hyAnnualplan)
    {
        return hyAnnualplanMapper.insertHyAnnualplan(hyAnnualplan);
    }

    /**
     * 修改年度保养计划
     * 
     * @param hyAnnualplan 年度保养计划
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAnnualplan(HyAnnualplan hyAnnualplan)
    {
        return hyAnnualplanMapper.updateHyAnnualplan(hyAnnualplan);
    }

    /**
     * 删除年度保养计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAnnualplanByIds(String ids)
    {
        return hyAnnualplanMapper.deleteHyAnnualplanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除年度保养计划信息
     * 
     * @param id 年度保养计划ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAnnualplanById(Long id)
    {
        return hyAnnualplanMapper.deleteHyAnnualplanById(id);
    }
}
