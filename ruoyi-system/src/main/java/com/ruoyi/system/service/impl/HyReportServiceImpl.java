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
