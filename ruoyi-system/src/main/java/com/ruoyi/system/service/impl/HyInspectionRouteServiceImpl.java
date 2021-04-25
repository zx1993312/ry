package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyInspectionRouteMapper;
import com.ruoyi.system.domain.HyInspectionRoute;
import com.ruoyi.system.service.IHyInspectionRouteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检线路Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyInspectionRouteServiceImpl implements IHyInspectionRouteService 
{
    @Autowired
    private HyInspectionRouteMapper hyInspectionRouteMapper;

    /**
     * 查询巡检线路
     * 
     * @param id 巡检线路ID
     * @return 巡检线路
     */
    @Override
    public HyInspectionRoute selectHyInspectionRouteById(Long id)
    {
        return hyInspectionRouteMapper.selectHyInspectionRouteById(id);
    }

    /**
     * 查询巡检线路列表
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 巡检线路
     */
    @Override
    public List<HyInspectionRoute> selectHyInspectionRouteList(HyInspectionRoute hyInspectionRoute)
    {
        return hyInspectionRouteMapper.selectHyInspectionRouteList(hyInspectionRoute);
    }

    /**
     * 新增巡检线路
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyInspectionRoute(HyInspectionRoute hyInspectionRoute)
    {
        return hyInspectionRouteMapper.insertHyInspectionRoute(hyInspectionRoute);
    }

    /**
     * 修改巡检线路
     * 
     * @param hyInspectionRoute 巡检线路
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyInspectionRoute(HyInspectionRoute hyInspectionRoute)
    {
        return hyInspectionRouteMapper.updateHyInspectionRoute(hyInspectionRoute);
    }

    /**
     * 删除巡检线路对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionRouteByIds(String ids)
    {
        return hyInspectionRouteMapper.deleteHyInspectionRouteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检线路信息
     * 
     * @param id 巡检线路ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyInspectionRouteById(Long id)
    {
        return hyInspectionRouteMapper.deleteHyInspectionRouteById(id);
    }
}
