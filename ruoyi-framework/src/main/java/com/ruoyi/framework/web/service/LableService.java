package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyLable;
import com.ruoyi.system.service.IHyLableService;

@Service("lable")
public class LableService {
	@Autowired
	private IHyLableService hyLableService;
	
	public List<HyLable> getLable(){
		return hyLableService.selectHyLableList(new HyLable());
		 
	}
}
