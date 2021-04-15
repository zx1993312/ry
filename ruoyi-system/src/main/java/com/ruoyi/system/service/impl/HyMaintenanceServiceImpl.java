package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceMapper;
import com.ruoyi.system.mapper.HyResidentialQuartersMapper;
import com.ruoyi.system.domain.HyMaintenance;
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.service.IHyMaintenanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修费用Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Service
public class HyMaintenanceServiceImpl implements IHyMaintenanceService 
{
    @Autowired
    private HyMaintenanceMapper hyMaintenanceMapper;

    @Autowired
    private HyResidentialQuartersMapper hyResidentialQuartersMapper;
    /**
     * 查询维修费用
     * 
     * @param id 维修费用ID
     * @return 维修费用
     */
    @Override
    public HyMaintenance selectHyMaintenanceById(Long id)
    {
        return hyMaintenanceMapper.selectHyMaintenanceById(id);
    }

    /**
     * 查询维修费用列表
     * 
     * @param hyMaintenance 维修费用
     * @return 维修费用
     */
    @Override
    public List<HyMaintenance> selectHyMaintenanceList(HyMaintenance hyMaintenance)
    {
        return hyMaintenanceMapper.selectHyMaintenanceList(hyMaintenance);
    }

    /**
     * 新增维修费用
     * 
     * @param hyMaintenance 维修费用
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenance(HyMaintenance hyMaintenance)
    {
    	HyResidentialQuarters hyResidentialQuarters = new HyResidentialQuarters();
    	String address = hyMaintenance.getMaintenanceAddress();
    	String[] quarters = address.split("-");
    	String communityName = quarters[0];
    	hyResidentialQuarters.setCommunityName(communityName);
    	List<HyResidentialQuarters> list = hyResidentialQuartersMapper.selectHyResidentialQuartersList(hyResidentialQuarters);
    	hyResidentialQuarters = list.get(0);
    	Long quartersId = hyResidentialQuarters.getId();
    	hyMaintenance.setQuartersId(quartersId);
        hyMaintenance.setCreateTime(DateUtils.getNowDate());
        
        return hyMaintenanceMapper.insertHyMaintenance(hyMaintenance);
    }

    /**
     * 修改维修费用
     * 
     * @param hyMaintenance 维修费用
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenance(HyMaintenance hyMaintenance)
    {
        return hyMaintenanceMapper.updateHyMaintenance(hyMaintenance);
    }

    /**
     * 删除维修费用对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceByIds(String ids)
    {
        return hyMaintenanceMapper.deleteHyMaintenanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修费用信息
     * 
     * @param id 维修费用ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceById(Long id)
    {
        return hyMaintenanceMapper.deleteHyMaintenanceById(id);
    }
}
