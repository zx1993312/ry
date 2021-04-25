package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCheckeProject;

/**
 * 巡检项目Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyCheckeProjectService 
{
    /**
     * 查询巡检项目
     * 
     * @param id 巡检项目ID
     * @return 巡检项目
     */
    public HyCheckeProject selectHyCheckeProjectById(Long id);

    /**
     * 查询巡检项目列表
     * 
     * @param hyCheckeProject 巡检项目
     * @return 巡检项目集合
     */
    public List<HyCheckeProject> selectHyCheckeProjectList(HyCheckeProject hyCheckeProject);

    /**
     * 新增巡检项目
     * 
     * @param hyCheckeProject 巡检项目
     * @return 结果
     */
    public int insertHyCheckeProject(HyCheckeProject hyCheckeProject);

    /**
     * 修改巡检项目
     * 
     * @param hyCheckeProject 巡检项目
     * @return 结果
     */
    public int updateHyCheckeProject(HyCheckeProject hyCheckeProject);

    /**
     * 批量删除巡检项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCheckeProjectByIds(String ids);

    /**
     * 删除巡检项目信息
     * 
     * @param id 巡检项目ID
     * @return 结果
     */
    public int deleteHyCheckeProjectById(Long id);
}
