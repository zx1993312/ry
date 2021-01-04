package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyProject;

/**
 * 项目列Service接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IHyProjectService 
{
    /**
     * 查询项目列
     * 
     * @param id 项目列ID
     * @return 项目列
     */
    public HyProject selectHyProjectById(Long id);

    /**
     * 查询项目列列表
     * 
     * @param hyProject 项目列
     * @return 项目列集合
     */
    public List<HyProject> selectHyProjectList(HyProject hyProject);

    /**
     * 新增项目列
     * 
     * @param hyProject 项目列
     * @return 结果
     */
    public int insertHyProject(HyProject hyProject);

    /**
     * 修改项目列
     * 
     * @param hyProject 项目列
     * @return 结果
     */
    public int updateHyProject(HyProject hyProject);

    /**
     * 批量删除项目列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyProjectByIds(String ids);

    /**
     * 删除项目列信息
     * 
     * @param id 项目列ID
     * @return 结果
     */
    public int deleteHyProjectById(Long id);
}
