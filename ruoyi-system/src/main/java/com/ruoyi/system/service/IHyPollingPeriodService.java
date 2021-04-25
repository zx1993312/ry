package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPollingPeriod;

/**
 * 巡检周期Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyPollingPeriodService 
{
    /**
     * 查询巡检周期
     * 
     * @param id 巡检周期ID
     * @return 巡检周期
     */
    public HyPollingPeriod selectHyPollingPeriodById(Long id);

    /**
     * 查询巡检周期列表
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 巡检周期集合
     */
    public List<HyPollingPeriod> selectHyPollingPeriodList(HyPollingPeriod hyPollingPeriod);

    /**
     * 新增巡检周期
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 结果
     */
    public int insertHyPollingPeriod(HyPollingPeriod hyPollingPeriod);

    /**
     * 修改巡检周期
     * 
     * @param hyPollingPeriod 巡检周期
     * @return 结果
     */
    public int updateHyPollingPeriod(HyPollingPeriod hyPollingPeriod);

    /**
     * 批量删除巡检周期
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPollingPeriodByIds(String ids);

    /**
     * 删除巡检周期信息
     * 
     * @param id 巡检周期ID
     * @return 结果
     */
    public int deleteHyPollingPeriodById(Long id);
}
