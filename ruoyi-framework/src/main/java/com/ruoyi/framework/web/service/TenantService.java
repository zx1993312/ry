package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.HyTenant;
import com.ruoyi.system.mapper.HyTenantMapper;

@Service("tenant")
public class TenantService {
	@Autowired
	HyTenantMapper hyTenantMapper;
	public List<HyTenant> getTenant(){
		return hyTenantMapper.selectHyTenantList(new HyTenant());
		
	}

}
