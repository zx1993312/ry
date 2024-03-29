package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyReportMapper;
import com.ruoyi.system.domain.HyReport;
import com.ruoyi.system.service.IHyReportService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报事管理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Service
public class HyReportServiceImpl implements IHyReportService 
{
    @Autowired
    private HyReportMapper hyReportMapper;

    /**
     * 查询报事管理
     * 
     * @param id 报事管理ID
     * @return 报事管理
     */
    @Override
    public HyReport selectHyReportById(Long id)
    {
        return hyReportMapper.selectHyReportById(id);
    }

    /**
     * 查询报事管理列表
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportList(HyReport hyReport)
    {
        return hyReportMapper.selectHyReportList(hyReport);
    }
    
    /**
     * 查询待派报事管理列表APP
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
	public List<HyReport> selectHyReportListByDP(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByDP(hyReport);
	}
    
    /**
     * 查询已派报事管理列表APP
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByYP(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByYP(hyReport);
    }
    
    /**
     * 查询已完成报事管理列表APP
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByYWC(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByYWC(hyReport);
    }
    
    /**
     * 查询待完成报事管理列表任务
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByWait(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByWait(hyReport);
    }
    
    /**
     * 查询进行中报事管理列表任务
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByUnderway(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByUnderway(hyReport);
    }
    
    /**
     * 查询已完成报事管理列表任务
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByFinished(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByFinished(hyReport);
    }
    
    /**
     * 查询未完成报事管理列表任务
     * 
     * @param hyReport 报事管理
     * @return 报事管理
     */
    @Override
    public List<HyReport> selectHyReportListByUnfinished(HyReport hyReport) {
    	return hyReportMapper.selectHyReportListByUnfinished(hyReport);
    }

    /**
     * 新增报事管理
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyReport(HyReport hyReport)
    {
        return hyReportMapper.insertHyReport(hyReport);
    }
    
    /**
     * 新增报事管理App
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
	public int insertHyReportByApp(HyReport hyReport) {
    	return hyReportMapper.insertHyReport(hyReport);
	}

    /**
     * 修改报事管理
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyReport(HyReport hyReport)
    {
        return hyReportMapper.updateHyReport(hyReport);
    }
    
    /**
     * 一键全部审核
     * 
     * @param hyReport 报事管理
     * @return 结果
     */
    @Override
	public int updateAudit(HyReport hyReport) {
		return hyReportMapper.updateAudit(hyReport);
	}

    /**
     * 删除报事管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyReportByIds(String ids)
    {
        return hyReportMapper.deleteHyReportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报事管理信息
     * 
     * @param id 报事管理ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyReportById(Long id)
    {
        return hyReportMapper.deleteHyReportById(id);
    }
}
