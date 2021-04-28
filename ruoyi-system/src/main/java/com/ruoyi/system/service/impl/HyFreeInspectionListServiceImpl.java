package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.mapper.HyFreeInspectionListMapper;
import com.ruoyi.system.service.IHyFreeInspectionListService;
@Service
public class HyFreeInspectionListServiceImpl implements IHyFreeInspectionListService{
	
	@Autowired
	HyFreeInspectionListMapper hyFreeInspectionListMapper;
	@Override
	public HyPatrolScheme selectHyPatrolSchemeById(Long id) {

		return hyFreeInspectionListMapper.selectHyPatrolSchemeById(id);
	}

	@Override
	public List<HyPatrolScheme> selectHyPatrolSchemeList(HyPatrolScheme hyPatrolScheme) {

		return hyFreeInspectionListMapper.selectHyPatrolSchemeList(hyPatrolScheme);
	}

}
