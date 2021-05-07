package com.ruoyi.framework.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;

@Service("employee")
public class EmployeeService {
	@Autowired
	SysUserMapper sysUserMapper;
	/**
	 * 查询所有员工方法
	 * 
	 * @return
	 */
	public List<SysUser> getEmployee() {
		return sysUserMapper.selectUserLists(new SysUser());
	}
}
