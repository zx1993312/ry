package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyPollingPeriodMapper;
import com.ruoyi.system.domain.HyPollingPeriod;
import com.ruoyi.system.service.IHyPollingPeriodService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检周期Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyPollingPeriodServiceImpl implements IHyPollingPeriodService 
{
    @Autowired
    private HyPollingPeriodMapper hyPollingPeriodMapper;

    /**
     * 查询巡检周期
     * 
     * @param id 巡检周期ID
     * @return 巡检周期
     */
    @Override
    public HyPollingPeriod selectHyPollingPeriodById(Long id)
    {
        return hyPollingPeriodMapper.selectHyPollingPeriodById(id);
    }

    /**
     * 查询巡检周期列表
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 巡检周期
     */
    @Override
    public List<HyPollingPeriod> selectHyPollingPeriodList(HyPollingPeriod hyPollingPeriod)
    {
        return hyPollingPeriodMapper.selectHyPollingPeriodList(hyPollingPeriod);
    }

    /**
     * 新增巡检周期
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPollingPeriod(HyPollingPeriod hyPollingPeriod)
    {
        return hyPollingPeriodMapper.insertHyPollingPeriod(hyPollingPeriod);
    }

    /**
     * 修改巡检周期
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPollingPeriod(HyPollingPeriod hyPollingPeriod)
    {
        return hyPollingPeriodMapper.updateHyPollingPeriod(hyPollingPeriod);
    }

    /**
     * 删除巡检周期对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPollingPeriodByIds(String ids)
    {
        return hyPollingPeriodMapper.deleteHyPollingPeriodByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检周期信息
     * 
     * @param id 巡检周期ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPollingPeriodById(Long id)
    {
        return hyPollingPeriodMapper.deleteHyPollingPeriodById(id);
    }
}
