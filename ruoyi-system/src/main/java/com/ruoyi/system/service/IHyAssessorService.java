package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyAssessor;

/**
 * 审核管理Service接口
 * 
 * @author Administrator
 * @date 2021-04-21
 */
public interface IHyAssessorService 
{
    /**
     * 查询审核管理
     * 
     * @param id 审核管理ID
     * @return 审核管理
     */
    public HyAssessor selectHyAssessorById(Long id);

    /**
     * 查询审核管理列表
     * 
     * @param hyAssessor 审核管理
     * @return 审核管理集合
     */
    public List<HyAssessor> selectHyAssessorList(HyAssessor hyAssessor);

    /**
     * 新增审核管理
     * 
     * @param hyAssessor 审核管理
     * @return 结果
     */
    public int insertHyAssessor(HyAssessor hyAssessor);

    /**
     * 修改审核管理
     * 
     * @param hyAssessor 审核管理
     * @return 结果
     */
    public int updateHyAssessor(HyAssessor hyAssessor);

    /**
     * 批量删除审核管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAssessorByIds(String ids);

    /**
     * 删除审核管理信息
     * 
     * @param id 审核管理ID
     * @return 结果
     */
    public int deleteHyAssessorById(Long id);
}
