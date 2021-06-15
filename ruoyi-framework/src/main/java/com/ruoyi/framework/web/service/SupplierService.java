package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HySupplier;
import com.ruoyi.system.mapper.HySupplierMapper;

@Service("supplier")
public class SupplierService {
	
	@Autowired
	HySupplierMapper hySupplierMapper;
	
	public List<HySupplier> getSupplier(){
		return hySupplierMapper.selectHySupplierList(new HySupplier());
		
	}

}
