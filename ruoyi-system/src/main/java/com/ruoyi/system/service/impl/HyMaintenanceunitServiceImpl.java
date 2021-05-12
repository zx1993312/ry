package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceunitMapper;
import com.ruoyi.system.domain.HyMaintenanceunit;
import com.ruoyi.system.service.IHyMaintenanceunitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 保养单位Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Service
public class HyMaintenanceunitServiceImpl implements IHyMaintenanceunitService 
{
    @Autowired
    private HyMaintenanceunitMapper hyMaintenanceunitMapper;

    /**
     * 查询保养单位
     * 
     * @param id 保养单位ID
     * @return 保养单位
     */
    @Override
    public HyMaintenanceunit selectHyMaintenanceunitById(Long id)
    {
        return hyMaintenanceunitMapper.selectHyMaintenanceunitById(id);
    }

    /**
     * 查询保养单位列表
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 保养单位
     */
    @Override
    public List<HyMaintenanceunit> selectHyMaintenanceunitList(HyMaintenanceunit hyMaintenanceunit)
    {
        return hyMaintenanceunitMapper.selectHyMaintenanceunitList(hyMaintenanceunit);
    }

    /**
     * 新增保养单位
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceunit(HyMaintenanceunit hyMaintenanceunit)
    {
        return hyMaintenanceunitMapper.insertHyMaintenanceunit(hyMaintenanceunit);
    }

    /**
     * 修改保养单位
     * 
     * @param hyMaintenanceunit 保养单位
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceunit(HyMaintenanceunit hyMaintenanceunit)
    {
        return hyMaintenanceunitMapper.updateHyMaintenanceunit(hyMaintenanceunit);
    }

    /**
     * 删除保养单位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceunitByIds(String ids)
    {
        return hyMaintenanceunitMapper.deleteHyMaintenanceunitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保养单位信息
     * 
     * @param id 保养单位ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceunitById(Long id)
    {
        return hyMaintenanceunitMapper.deleteHyMaintenanceunitById(id);
    }
}
