package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.mapper.HyPatrolSchemeMapper;

@Service("scheme")
public class SchemeService {
	
	@Autowired
	HyPatrolSchemeMapper hyPatrolSchemeMapper;
	/**
	 * 查询所有计划方法
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyPatrolScheme> getScheme(){
		return hyPatrolSchemeMapper.selectHyPatrolSchemeList(new HyPatrolScheme());
	}
}
