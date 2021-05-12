package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaintenanceplandetail;

/**
 * 设备保养计划执行安排Service接口
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public interface IHyMaintenanceplandetailService 
{
    /**
     * 查询设备保养计划执行安排
     * 
     * @param id 设备保养计划执行安排ID
     * @return 设备保养计划执行安排
     */
    public HyMaintenanceplandetail selectHyMaintenanceplandetailById(Long id);

    /**
     * 查询设备保养计划执行安排列表
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 设备保养计划执行安排集合
     */
    public List<HyMaintenanceplandetail> selectHyMaintenanceplandetailList(HyMaintenanceplandetail hyMaintenanceplandetail);

    /**
     * 新增设备保养计划执行安排
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 结果
     */
    public int insertHyMaintenanceplandetail(HyMaintenanceplandetail hyMaintenanceplandetail);

    /**
     * 修改设备保养计划执行安排
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 结果
     */
    public int updateHyMaintenanceplandetail(HyMaintenanceplandetail hyMaintenanceplandetail);

    /**
     * 批量删除设备保养计划执行安排
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaintenanceplandetailByIds(String ids);

    /**
     * 删除设备保养计划执行安排信息
     * 
     * @param id 设备保养计划执行安排ID
     * @return 结果
     */
    public int deleteHyMaintenanceplandetailById(Long id);
}
