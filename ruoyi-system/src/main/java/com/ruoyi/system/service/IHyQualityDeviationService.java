package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyQualityDeviation;

/**
 * 品质异常Service接口
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public interface IHyQualityDeviationService 
{
    /**
     * 查询品质异常
     * 
     * @param id 品质异常ID
     * @return 品质异常
     */
    public HyQualityDeviation selectHyQualityDeviationById(Long id);

    /**
     * 查询品质异常列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常集合
     */
    public List<HyQualityDeviation> selectHyQualityDeviationList(HyQualityDeviation hyQualityDeviation);
    
    /**
     * 查询品质异常待审核列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常集合
     */
    public List<HyQualityDeviation> selectHyQualityDeviationListByAudit(HyQualityDeviation hyQualityDeviation);
    
    /**
     * 查询品质异常已通过列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常集合
     */
    public List<HyQualityDeviation> selectHyQualityDeviationListByThrough(HyQualityDeviation hyQualityDeviation);
    
    /**
     * 查询品质异常已拒绝列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常集合
     */
    public List<HyQualityDeviation> selectHyQualityDeviationListByRefusal(HyQualityDeviation hyQualityDeviation);

    /**
     * 新增品质异常
     * 
     * @param hyQualityDeviation 品质异常
     * @return 结果
     */
    public int insertHyQualityDeviation(HyQualityDeviation hyQualityDeviation);

    /**
     * 修改品质异常
     * 
     * @param hyQualityDeviation 品质异常
     * @return 结果
     */
    public int updateHyQualityDeviation(HyQualityDeviation hyQualityDeviation);

    /**
     * 批量删除品质异常
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyQualityDeviationByIds(String ids);

    /**
     * 删除品质异常信息
     * 
     * @param id 品质异常ID
     * @return 结果
     */
    public int deleteHyQualityDeviationById(Long id);
}
