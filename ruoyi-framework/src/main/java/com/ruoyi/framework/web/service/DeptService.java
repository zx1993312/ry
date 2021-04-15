package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyDept;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.mapper.HyDeptMapper;

@Service("dept")
public class DeptService {
	
	@Autowired
	HyDeptMapper hydeptMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyDept> getDept(){
		return hydeptMapper.selectHyDeptList(new HyDept());
		
	}
}
