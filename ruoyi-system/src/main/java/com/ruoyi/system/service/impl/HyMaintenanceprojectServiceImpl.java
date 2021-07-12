package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyMaintenanceproject;
import com.ruoyi.system.mapper.HyMaintenanceprojectMapper;
import com.ruoyi.system.service.IHyMaintenanceprojectService;

/**
 * 保养项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Service
public class HyMaintenanceprojectServiceImpl implements IHyMaintenanceprojectService 
{
    @Autowired
    private HyMaintenanceprojectMapper hyMaintenanceprojectMapper;

    /**
     * 查询保养项目
     * 
     * @param id 保养项目ID
     * @return 保养项目
     */
    @Override
    public HyMaintenanceproject selectHyMaintenanceprojectById(Long id)
    {
        return hyMaintenanceprojectMapper.selectHyMaintenanceprojectById(id);
    }

    /**
     * 查询保养项目列表
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 保养项目
     */
    @Override
    public List<HyMaintenanceproject> selectHyMaintenanceprojectList(HyMaintenanceproject hyMaintenanceproject)
    {
        return hyMaintenanceprojectMapper.selectHyMaintenanceprojectList(hyMaintenanceproject);
    }

    /**
     * 新增保养项目
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceproject(HyMaintenanceproject hyMaintenanceproject)
    {
        return hyMaintenanceprojectMapper.insertHyMaintenanceproject(hyMaintenanceproject);
    }

    /**
     * 修改保养项目
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceproject(HyMaintenanceproject hyMaintenanceproject)
    {
        return hyMaintenanceprojectMapper.updateHyMaintenanceproject(hyMaintenanceproject);
    }

    /**
     * 删除保养项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceprojectByIds(String ids)
    {
        return hyMaintenanceprojectMapper.deleteHyMaintenanceprojectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保养项目信息
     * 
     * @param id 保养项目ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceprojectById(Long id)
    {
        return hyMaintenanceprojectMapper.deleteHyMaintenanceprojectById(id);
    }
}
