package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenancesuppliesMapper;
import com.ruoyi.system.domain.HyMaintenancesupplies;
import com.ruoyi.system.service.IHyMaintenancesuppliesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备保养物料Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Service
public class HyMaintenancesuppliesServiceImpl implements IHyMaintenancesuppliesService 
{
    @Autowired
    private HyMaintenancesuppliesMapper hyMaintenancesuppliesMapper;

    /**
     * 查询设备保养物料
     * 
     * @param id 设备保养物料ID
     * @return 设备保养物料
     */
    @Override
    public HyMaintenancesupplies selectHyMaintenancesuppliesById(Long id)
    {
        return hyMaintenancesuppliesMapper.selectHyMaintenancesuppliesById(id);
    }

    /**
     * 查询设备保养物料列表
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 设备保养物料
     */
    @Override
    public List<HyMaintenancesupplies> selectHyMaintenancesuppliesList(HyMaintenancesupplies hyMaintenancesupplies)
    {
        return hyMaintenancesuppliesMapper.selectHyMaintenancesuppliesList(hyMaintenancesupplies);
    }

    /**
     * 新增设备保养物料
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenancesupplies(HyMaintenancesupplies hyMaintenancesupplies)
    {
        return hyMaintenancesuppliesMapper.insertHyMaintenancesupplies(hyMaintenancesupplies);
    }

    /**
     * 修改设备保养物料
     * 
     * @param hyMaintenancesupplies 设备保养物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenancesupplies(HyMaintenancesupplies hyMaintenancesupplies)
    {
        return hyMaintenancesuppliesMapper.updateHyMaintenancesupplies(hyMaintenancesupplies);
    }

    /**
     * 删除设备保养物料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenancesuppliesByIds(String ids)
    {
        return hyMaintenancesuppliesMapper.deleteHyMaintenancesuppliesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备保养物料信息
     * 
     * @param id 设备保养物料ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenancesuppliesById(Long id)
    {
        return hyMaintenancesuppliesMapper.deleteHyMaintenancesuppliesById(id);
    }
}
