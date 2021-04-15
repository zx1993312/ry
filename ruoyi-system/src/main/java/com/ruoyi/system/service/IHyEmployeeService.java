package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyEmployee;

/**
 * 员工Service接口
 * 
 * @author Administrator
 * @date 2021-04-14
 */
public interface IHyEmployeeService 
{
    /**
     * 查询员工
     * 
     * @param id 员工ID
     * @return 员工
     */
    public HyEmployee selectHyEmployeeById(Long id);

    /**
     * 查询员工列表
     * 
     * @param hyEmployee 员工
     * @return 员工集合
     */
    public List<HyEmployee> selectHyEmployeeList(HyEmployee hyEmployee);

    /**
     * 新增员工
     * 
     * @param hyEmployee 员工
     * @return 结果
     */
    public int insertHyEmployee(HyEmployee hyEmployee);

    /**
     * 修改员工
     * 
     * @param hyEmployee 员工
     * @return 结果
     */
    public int updateHyEmployee(HyEmployee hyEmployee);

    /**
     * 批量删除员工
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEmployeeByIds(String ids);

    /**
     * 删除员工信息
     * 
     * @param id 员工ID
     * @return 结果
     */
    public int deleteHyEmployeeById(Long id);
}
