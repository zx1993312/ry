package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyBuilding;

/**
 * 楼宇Service接口
 * 
 * @author Administrator
 * @date 2021-05-22
 */
public interface IHyBuildingService 
{
    /**
     * 查询楼宇
     * 
     * @param id 楼宇ID
     * @return 楼宇
     */
    public HyBuilding selectHyBuildingById(Long id);

    /**
     * 查询楼宇列表
     * 
     * @param hyBuilding 楼宇
     * @return 楼宇集合
     */
    public List<HyBuilding> selectHyBuildingList(HyBuilding hyBuilding);

    /**
     * 新增楼宇
     * 
     * @param hyBuilding 楼宇
     * @return 结果
     */
    public int insertHyBuilding(HyBuilding hyBuilding);

    /**
     * 修改楼宇
     * 
     * @param hyBuilding 楼宇
     * @return 结果
     */
    public int updateHyBuilding(HyBuilding hyBuilding);

    /**
     * 批量删除楼宇
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyBuildingByIds(String ids);

    /**
     * 删除楼宇信息
     * 
     * @param id 楼宇ID
     * @return 结果
     */
    public int deleteHyBuildingById(Long id);
}
