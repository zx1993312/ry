package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.MeterAndCase;

/**
 * 箱
Service接口
 * 
 * @author Administrator
 * @date 2021-01-12
 */
public interface IHyMeterCaseService 
{
    /**
     * 查询箱

     * 
     * @param id 箱
ID
     * @return 箱

     */
    public HyMeterCase selectHyMeterCaseById(Long id);

    /**
     * 查询箱
列表
     * 
     * @param hyMeterCase 箱

     * @return 箱
集合
     */
    public List<HyMeterCase> selectHyMeterCaseList(HyMeterCase hyMeterCase);

    /**
     * 新增箱

     * 
     * @param hyMeterCase 箱

     * @return 结果
     */
    public int insertHyMeterCase(MeterAndCase meterAndCase);

    /**
     * 修改箱

     * 
     * @param hyMeterCase 箱

     * @return 结果
     */
    public int updateHyMeterCase(HyMeterCase hyMeterCase);

    /**
     * 批量删除箱

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMeterCaseByIds(String ids);

    /**
     * 删除箱
信息
     * 
     * @param id 箱
ID
     * @return 结果
     */
    public int deleteHyMeterCaseById(Long id);
}
