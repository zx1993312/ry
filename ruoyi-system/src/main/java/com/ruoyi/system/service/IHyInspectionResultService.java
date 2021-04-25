package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyInspectionResult;

/**
 * 巡检结果Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyInspectionResultService 
{
    /**
     * 查询巡检结果
     * 
     * @param id 巡检结果ID
     * @return 巡检结果
     */
    public HyInspectionResult selectHyInspectionResultById(Long id);

    /**
     * 查询巡检结果列表
     * 
     * @param hyInspectionResult 巡检结果
     * @return 巡检结果集合
     */
    public List<HyInspectionResult> selectHyInspectionResultList(HyInspectionResult hyInspectionResult);

    /**
     * 新增巡检结果
     * 
     * @param hyInspectionResult 巡检结果
     * @return 结果
     */
    public int insertHyInspectionResult(HyInspectionResult hyInspectionResult);

    /**
     * 修改巡检结果
     * 
     * @param hyInspectionResult 巡检结果
     * @return 结果
     */
    public int updateHyInspectionResult(HyInspectionResult hyInspectionResult);

    /**
     * 批量删除巡检结果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyInspectionResultByIds(String ids);

    /**
     * 删除巡检结果信息
     * 
     * @param id 巡检结果ID
     * @return 结果
     */
    public int deleteHyInspectionResultById(Long id);
}
