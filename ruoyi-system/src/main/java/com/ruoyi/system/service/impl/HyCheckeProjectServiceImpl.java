package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCheckeProjectMapper;
import com.ruoyi.system.domain.HyCheckeProject;
import com.ruoyi.system.service.IHyCheckeProjectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyCheckeProjectServiceImpl implements IHyCheckeProjectService 
{
    @Autowired
    private HyCheckeProjectMapper hyCheckeProjectMapper;

    /**
     * 查询巡检项目
     * 
     * @param id 巡检项目ID
     * @return 巡检项目
     */
    @Override
    public HyCheckeProject selectHyCheckeProjectById(Long id)
    {
        return hyCheckeProjectMapper.selectHyCheckeProjectById(id);
    }

    /**
     * 查询巡检项目列表
     * 
     * @param hyCheckeProject 巡检项目
     * @return 巡检项目
     */
    @Override
    public List<HyCheckeProject> selectHyCheckeProjectList(HyCheckeProject hyCheckeProject)
    {
        return hyCheckeProjectMapper.selectHyCheckeProjectList(hyCheckeProject);
    }

    /**
     * 新增巡检项目
     * 
     * @param hyCheckeProject 巡检项目
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCheckeProject(HyCheckeProject hyCheckeProject)
    {
        return hyCheckeProjectMapper.insertHyCheckeProject(hyCheckeProject);
    }

    /**
     * 修改巡检项目
     * 
     * @param hyCheckeProject 巡检项目
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCheckeProject(HyCheckeProject hyCheckeProject)
    {
        return hyCheckeProjectMapper.updateHyCheckeProject(hyCheckeProject);
    }

    /**
     * 删除巡检项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckeProjectByIds(String ids)
    {
        return hyCheckeProjectMapper.deleteHyCheckeProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检项目信息
     * 
     * @param id 巡检项目ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckeProjectById(Long id)
    {
        return hyCheckeProjectMapper.deleteHyCheckeProjectById(id);
    }
}
