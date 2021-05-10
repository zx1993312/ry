package com.ruoyi.framework.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;

@Service("user")
public class UserService {
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<SysUser> getUser(){
		return sysUserMapper.selectUserLists(new SysUser());
		
	}
}
