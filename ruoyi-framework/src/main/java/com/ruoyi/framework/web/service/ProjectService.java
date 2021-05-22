package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyProject;
import com.ruoyi.system.mapper.HyProjectMapper;


@Service("project")
public class ProjectService {
	
	@Autowired
	HyProjectMapper hyProjectMapper;

	public List<HyProject> getProject(){
		return hyProjectMapper.selectHyProjectList(new HyProject());
	}
}
