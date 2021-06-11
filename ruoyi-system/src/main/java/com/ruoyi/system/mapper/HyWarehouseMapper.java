package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyWarehouse;

/**
 * 仓库Mapper接口
 * 
 * @author Administrator
 * @date 2021-06-11
 */
public interface HyWarehouseMapper 
{
    /**
     * 查询仓库
     * 
     * @param id 仓库ID
     * @return 仓库
     */
    public HyWarehouse selectHyWarehouseById(Long id);

    /**
     * 查询仓库列表
     * 
     * @param hyWarehouse 仓库
     * @return 仓库集合
     */
    public List<HyWarehouse> selectHyWarehouseList(HyWarehouse hyWarehouse);

    /**
     * 新增仓库
     * 
     * @param hyWarehouse 仓库
     * @return 结果
     */
    public int insertHyWarehouse(HyWarehouse hyWarehouse);

    /**
     * 修改仓库
     * 
     * @param hyWarehouse 仓库
     * @return 结果
     */
    public int updateHyWarehouse(HyWarehouse hyWarehouse);

    /**
     * 删除仓库
     * 
     * @param id 仓库ID
     * @return 结果
     */
    public int deleteHyWarehouseById(Long id);

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyWarehouseByIds(String[] ids);
}
