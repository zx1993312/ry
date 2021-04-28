package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyPatrolScheme;

public interface IHyFreeInspectionListService {
	 /**
     * 查询巡检计划
     * 
     * @param id 巡检计划ID
     * @return 巡检计划
     */
    public HyPatrolScheme selectHyPatrolSchemeById(Long id);

    /**
     * 查询巡检计划列表
     * 
     * @param hyPatrolScheme 巡检计划
     * @return 巡检计划集合
     */
    public List<HyPatrolScheme> selectHyPatrolSchemeList(HyPatrolScheme hyPatrolScheme);
}
