package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceproject;

/**
 * 保养项目Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public interface HyMaintenanceprojectMapper 
{
    /**
     * 查询保养项目
     * 
     * @param id 保养项目ID
     * @return 保养项目
     */
    public HyMaintenanceproject selectHyMaintenanceprojectById(Long id);

    /**
     * 查询保养项目列表
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 保养项目集合
     */
    public List<HyMaintenanceproject> selectHyMaintenanceprojectList(HyMaintenanceproject hyMaintenanceproject);

    /**
     * 新增保养项目
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 结果
     */
    public int insertHyMaintenanceproject(HyMaintenanceproject hyMaintenanceproject);

    /**
     * 修改保养项目
     * 
     * @param hyMaintenanceproject 保养项目
     * @return 结果
     */
    public int updateHyMaintenanceproject(HyMaintenanceproject hyMaintenanceproject);

    /**
     * 删除保养项目
     * 
     * @param id 保养项目ID
     * @return 结果
     */
    public int deleteHyMaintenanceprojectById(Long id);

    /**
     * 批量删除保养项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceprojectByIds(String[] ids);
}
