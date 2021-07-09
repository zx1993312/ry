package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyFitmentManage;

/**
 * 装修管理Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public interface HyFitmentManageMapper 
{
    /**
     * 查询装修管理
     * 
     * @param id 装修管理ID
     * @return 装修管理
     */
    public HyFitmentManage selectHyFitmentManageById(Long id);

    /**
     * 查询装修管理列表
     * 
     * @param hyFitmentManage 装修管理
     * @return 装修管理集合
     */
    public List<HyFitmentManage> selectHyFitmentManageList(HyFitmentManage hyFitmentManage);
    
    /**
     * 查询装修管理待审核列表
     * 
     * @param hyFitmentManage 装修管理
     * @return 装修管理集合
     */
    public List<HyFitmentManage> selectHyFitmentManageListByAudit(HyFitmentManage hyFitmentManage);
    
    /**
     * 查询装修管理已通过列表
     * 
     * @param hyFitmentManage 装修管理
     * @return 装修管理集合
     */
    public List<HyFitmentManage> selectHyFitmentManageListByThrough(HyFitmentManage hyFitmentManage);
    
    /**
     * 查询装修管理已拒绝列表
     * 
     * @param hyFitmentManage 装修管理
     * @return 装修管理集合
     */
    public List<HyFitmentManage> selectHyFitmentManageListByRefusal(HyFitmentManage hyFitmentManage);

    /**
     * 新增装修管理
     * 
     * @param hyFitmentManage 装修管理
     * @return 结果
     */
    public int insertHyFitmentManage(HyFitmentManage hyFitmentManage);

    /**
     * 修改装修管理
     * 
     * @param hyFitmentManage 装修管理
     * @return 结果
     */
    public int updateHyFitmentManage(HyFitmentManage hyFitmentManage);

    /**
     * 删除装修管理
     * 
     * @param id 装修管理ID
     * @return 结果
     */
    public int deleteHyFitmentManageById(Long id);

    /**
     * 批量删除装修管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyFitmentManageByIds(String[] ids);
}
