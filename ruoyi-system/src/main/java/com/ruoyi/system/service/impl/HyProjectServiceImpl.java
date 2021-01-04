package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyProjectMapper;
import com.ruoyi.system.domain.HyProject;
import com.ruoyi.system.service.IHyProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目列Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class HyProjectServiceImpl implements IHyProjectService 
{
    @Autowired
    private HyProjectMapper hyProjectMapper;

    /**
     * 查询项目列
     * 
     * @param id 项目列ID
     * @return 项目列
     */
    @Override
    public HyProject selectHyProjectById(Long id)
    {
        return hyProjectMapper.selectHyProjectById(id);
    }

    /**
     * 查询项目列列表
     * 
     * @param hyProject 项目列
     * @return 项目列
     */
    @Override
    public List<HyProject> selectHyProjectList(HyProject hyProject)
    {
        return hyProjectMapper.selectHyProjectList(hyProject);
    }

    /**
     * 新增项目列
     * 
     * @param hyProject 项目列
     * @return 结果
     */
    @Override
    public int insertHyProject(HyProject hyProject)
    {
        return hyProjectMapper.insertHyProject(hyProject);
    }

    /**
     * 修改项目列
     * 
     * @param hyProject 项目列
     * @return 结果
     */
    @Override
    public int updateHyProject(HyProject hyProject)
    {
        return hyProjectMapper.updateHyProject(hyProject);
    }

    /**
     * 删除项目列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyProjectByIds(String ids)
    {
        return hyProjectMapper.deleteHyProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目列信息
     * 
     * @param id 项目列ID
     * @return 结果
     */
    @Override
    public int deleteHyProjectById(Long id)
    {
        return hyProjectMapper.deleteHyProjectById(id);
    }
}
