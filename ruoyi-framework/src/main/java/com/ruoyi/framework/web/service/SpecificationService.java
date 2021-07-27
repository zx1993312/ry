package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCommercialSpecification;
import com.ruoyi.system.mapper.HyCommercialSpecificationMapper;

@Service("specification")
public class SpecificationService {
	@Autowired
	HyCommercialSpecificationMapper hyCommercialSpecificationMapper;
	
	public List<HyCommercialSpecification> getSpecification(){
		return hyCommercialSpecificationMapper.selectHyCommercialSpecificationList(new HyCommercialSpecification());
		
	}
}
