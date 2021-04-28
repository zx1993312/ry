package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.mapper.HyFreeInspectionListMapper;
import com.ruoyi.system.mapper.HyPerformanceMapper;
import com.ruoyi.system.service.IHyFreeInspectionListService;
import com.ruoyi.system.service.IHyPerformanceService;
@Service
public class HyPerformanceServiceImpl implements IHyPerformanceService{
	
	@Autowired
	HyPerformanceMapper hyPerformanceMapper;
	@Override
	public HyPatrolScheme selectHyPatrolSchemeById(Long id) {

		return hyPerformanceMapper.selectHyPatrolSchemeById(id);
	}

	@Override
	public List<HyPatrolScheme> selectHyPatrolSchemeList(HyPatrolScheme hyPatrolScheme) {

		return hyPerformanceMapper.selectHyPatrolSchemeList(hyPatrolScheme);
	}

}
