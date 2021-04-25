package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyInspectionRoute;

/**
 * 巡检线路Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyInspectionRouteService 
{
    /**
     * 查询巡检线路
     * 
     * @param id 巡检线路ID
     * @return 巡检线路
     */
    public HyInspectionRoute selectHyInspectionRouteById(Long id);

    /**
     * 查询巡检线路列表
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 巡检线路集合
     */
    public List<HyInspectionRoute> selectHyInspectionRouteList(HyInspectionRoute hyInspectionRoute);

    /**
     * 新增巡检线路
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 结果
     */
    public int insertHyInspectionRoute(HyInspectionRoute hyInspectionRoute);

    /**
     * 修改巡检线路
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 结果
     */
    public int updateHyInspectionRoute(HyInspectionRoute hyInspectionRoute);

    /**
     * 批量删除巡检线路
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyInspectionRouteByIds(String ids);

    /**
     * 删除巡检线路信息
     * 
     * @param id 巡检线路ID
     * @return 结果
     */
    public int deleteHyInspectionRouteById(Long id);
}
