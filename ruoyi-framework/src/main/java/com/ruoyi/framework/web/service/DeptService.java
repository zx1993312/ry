package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.mapper.SysDeptMapper;

@Service("dept")
public class DeptService {
	
	@Autowired
	SysDeptMapper sysDeptMapper;
	
	/**
	 * 查询所有物业方法
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<SysDept> getDept(){
		SysDept sysDept = new SysDept();
		Long parentId = (long)0;
		sysDept.setParentId(parentId);
		return sysDeptMapper.selectDeptList(sysDept);
		
	}
}
