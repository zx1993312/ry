package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyBuildingMapper;
import com.ruoyi.system.mapper.HyResidentialQuartersMapper;
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.service.IHyBuildingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 楼宇Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-22
 */
@Service
public class HyBuildingServiceImpl implements IHyBuildingService 
{
    @Autowired
    private HyBuildingMapper hyBuildingMapper;
    
    @Autowired
    private HyResidentialQuartersMapper hyResidentialQuartersMapper;
    
    /**
     * 查询楼宇
     * 
     * @param id 楼宇ID
     * @return 楼宇
     */
    @Override
    public HyBuilding selectHyBuildingById(Long id)
    {
        return hyBuildingMapper.selectHyBuildingById(id);
    }

    /**
     * 查询楼宇列表
     * 
     * @param hyBuilding 楼宇
     * @return 楼宇
     */
    @Override
    public List<HyBuilding> selectHyBuildingList(HyBuilding hyBuilding)
    {
        return hyBuildingMapper.selectHyBuildingList(hyBuilding);
    }

    /**
     * 新增楼宇
     * 
     * @param hyBuilding 楼宇
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyBuilding(HyBuilding hyBuilding)
    {
    	String buildingAddress = hyBuilding.getBuildingAddress();
    	Long quartersId = hyBuilding.getQuartersId();
    	HyResidentialQuarters hyResidentialQuarters = new HyResidentialQuarters();
    	hyResidentialQuarters.setId(quartersId);
    	List<HyResidentialQuarters> list = hyResidentialQuartersMapper.selectHyResidentialQuartersList(hyResidentialQuarters);
    	hyResidentialQuarters = list.get(0);
    	String communityName = hyResidentialQuarters.getCommunityName();
    	String buildingName = communityName+"-"+buildingAddress;
    	hyBuilding.setBuildingName(buildingName);
        return hyBuildingMapper.insertHyBuilding(hyBuilding);
    }

    /**
     * 修改楼宇
     * 
     * @param hyBuilding 楼宇
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyBuilding(HyBuilding hyBuilding)
    {
    	String buildingAddress = hyBuilding.getBuildingAddress();
    	Long quartersId = hyBuilding.getQuartersId();
    	HyResidentialQuarters hyResidentialQuarters = new HyResidentialQuarters();
    	hyResidentialQuarters.setId(quartersId);
    	List<HyResidentialQuarters> list = hyResidentialQuartersMapper.selectHyResidentialQuartersList(hyResidentialQuarters);
    	hyResidentialQuarters = list.get(0);
    	String communityName = hyResidentialQuarters.getCommunityName();
    	String buildingName = communityName+"-"+buildingAddress;
    	hyBuilding.setBuildingName(buildingName);
        return hyBuildingMapper.updateHyBuilding(hyBuilding);
    }

    /**
     * 删除楼宇对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBuildingByIds(String ids)
    {
        return hyBuildingMapper.deleteHyBuildingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除楼宇信息
     * 
     * @param id 楼宇ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBuildingById(Long id)
    {
        return hyBuildingMapper.deleteHyBuildingById(id);
    }
}
