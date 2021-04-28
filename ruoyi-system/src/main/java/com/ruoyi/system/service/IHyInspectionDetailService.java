package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyInspectionDetail;

/**
 * 巡检线路明细Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyInspectionDetailService 
{
    /**
     * 查询巡检线路明细
     * 
     * @param id 巡检线路明细ID
     * @return 巡检线路明细
     */
    public HyInspectionDetail selectHyInspectionDetailById(Long id);

    /**
     * 查询巡检线路明细列表
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 巡检线路明细集合
     */
    public List<HyInspectionDetail> selectHyInspectionDetailList(HyInspectionDetail hyInspectionDetail);

    /**
     * 新增巡检线路明细
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 结果
     */
    public int insertHyInspectionDetail(HyInspectionDetail hyInspectionDetail);

    /**
     * 修改巡检线路明细
     * 
     * @param hyInspectionDetail 巡检线路明细
     * @return 结果
     */
    public int updateHyInspectionDetail(HyInspectionDetail hyInspectionDetail);

    /**
     * 批量删除巡检线路明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyInspectionDetailByIds(String ids);

    /**
     * 删除巡检线路明细信息
     * 
     * @param id 巡检线路明细ID
     * @return 结果
     */
    public int deleteHyInspectionDetailById(Long id);
}
