package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyBillSet;
import com.ruoyi.system.mapper.HyBillSetMapper;

@Service("set")
public class SetService {
	
	@Autowired
	HyBillSetMapper hyBillSetMapper;

	public List<HyBillSet> getSet(){
		return hyBillSetMapper.selectHyBillSetList(new HyBillSet());
		
	}
}
