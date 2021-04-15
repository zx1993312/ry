package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyReport;

/**
 * 报事管理Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public interface HyReportMapper 
{
    /**
     * 查询报事管理
     * 
     * @param id 报事管理ID
     * @return 报事管理
     */
    public HyReport selectHyReportById(Long id);

    /**
     * 查询报事管理列表
     * 
     * @param hyReport 报事管理
     * @return 报事管理集合
     */
    public List<HyReport> selectHyReportList(HyReport hyReport);

    /**
     * 新增报事管理
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    public int insertHyReport(HyReport hyReport);

    /**
     * 修改报事管理
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    public int updateHyReport(HyReport hyReport);
    
    /**
     * 一键全部审核
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    public int updateAudit(HyReport hyReport);
    
    /**
     * 删除报事管理
     * 
     * @param id 报事管理ID
     * @return 结果
     */
    public int deleteHyReportById(Long id);

    /**
     * 批量删除报事管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyReportByIds(String[] ids);

}
