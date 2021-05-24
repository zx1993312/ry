package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.mapper.HyMeterMapper;

@Service("meter")
public class MeterService {
	
	@Autowired
	HyMeterMapper hyMeterMapper;
	
	public List<HyMeter> getMeter(){
		return hyMeterMapper.selectHyMeter(new HyMeter());
		
	}

}
