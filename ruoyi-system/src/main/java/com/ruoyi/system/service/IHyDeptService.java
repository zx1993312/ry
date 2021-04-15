package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDept;

/**
 * 部门Service接口
 * 
 * @author Administrator
 * @date 2021-04-14
 */
public interface IHyDeptService 
{
    /**
     * 查询部门
     * 
     * @param id 部门ID
     * @return 部门
     */
    public HyDept selectHyDeptById(Long id);

    /**
     * 查询部门列表
     * 
     * @param hyDept 部门
     * @return 部门集合
     */
    public List<HyDept> selectHyDeptList(HyDept hyDept);

    /**
     * 新增部门
     * 
     * @param hyDept 部门
     * @return 结果
     */
    public int insertHyDept(HyDept hyDept);

    /**
     * 修改部门
     * 
     * @param hyDept 部门
     * @return 结果
     */
    public int updateHyDept(HyDept hyDept);

    /**
     * 批量删除部门
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDeptByIds(String ids);

    /**
     * 删除部门信息
     * 
     * @param id 部门ID
     * @return 结果
     */
    public int deleteHyDeptById(Long id);
}
