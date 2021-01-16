package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HyProject;
import com.ruoyi.system.mapper.HyProjectMapper;
import com.ruoyi.system.service.IHyProjectService;

/**
 * 项目列Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-04
 */
@Service
public class HyProjectServiceImpl implements IHyProjectService {
	@Autowired
	private HyProjectMapper hyProjectMapper;

	/**
	 * 查询项目列
	 * 
	 * @param id 项目列ID
	 * @return 项目列
	 */
	@Override
	public HyProject selectHyProjectById(Long id) {
		return hyProjectMapper.selectHyProjectById(id);
	}

	/**
	 * 查询项目列列表
	 * 
	 * @param hyProject 项目列
	 * @return 项目列
	 */
	@Override
	public List<HyProject> selectHyProjectList(HyProject hyProject) {
		return hyProjectMapper.selectHyProjectList(hyProject);
	}

	/**
	 * 新增项目列
	 * 
	 * @param hyProject 项目列
	 * @return 结果
	 */
	@Override
	public int insertHyProject(HyProject hyProject) {
		return hyProjectMapper.insertHyProject(hyProject);
	}

	/**
	 * 修改项目列
	 * 
	 * @param hyProject 项目列
	 * @return 结果
	 */
	@Override
	public int updateHyProject(HyProject hyProject) {
		return hyProjectMapper.updateHyProject(hyProject);
	}

	/**
	 * 删除项目列对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHyProjectByIds(String ids) {
		return hyProjectMapper.deleteHyProjectByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除项目列信息
	 * 
	 * @param id 项目列ID
	 * @return 结果
	 */
	@Override
	public int deleteHyProjectById(Long id) {
		return hyProjectMapper.deleteHyProjectById(id);
	}

	@Override
	public List<Ztree> selectHyProjectListTree(HyProject hyProject) {
		List<Ztree> ztrees = initZtree(hyProjectMapper.selectHyProjectList(hyProject));
		return ztrees;
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyProject> hyProjectList) {
		return initZtree(hyProjectList, null);
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyProject> hyProjectList, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (HyProject hyProject : hyProjectList) {
			if (UserConstants.DEPT_NORMAL.equals("0")) {
				Ztree ztree = new Ztree();
				ztree.setId(hyProject.getId());
				ztree.setpId(Long.valueOf(null == hyProject.getParentId() ? -1l : hyProject.getParentId()));
				ztree.setName(hyProject.getProjectName());
				ztree.setTitle(hyProject.getProjectName());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(hyProject.getId() + hyProject.getProjectName()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
}
