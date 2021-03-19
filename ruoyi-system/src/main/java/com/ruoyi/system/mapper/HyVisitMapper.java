package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyVisit;

/**
 * 访客Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface HyVisitMapper 
{
    /**
     * 查询访客
     * 
     * @param id 访客ID
     * @return 访客
     */
    public HyVisit selectHyVisitById(Long id);

    /**
     * 查询访客列表
     * 
     * @param hyVisit 访客
     * @return 访客集合
     */
    public List<HyVisit> selectHyVisitList(HyVisit hyVisit);

    /**
     * 新增访客
     * 
     * @param hyVisit 访客
     * @return 结果
     */
    public int insertHyVisit(HyVisit hyVisit);

    /**
     * 修改访客
     * 
     * @param hyVisit 访客
     * @return 结果
     */
    public int updateHyVisit(HyVisit hyVisit);

    /**
     * 删除访客
     * 
     * @param id 访客ID
     * @return 结果
     */
    public int deleteHyVisitById(Long id);

    /**
     * 批量删除访客
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyVisitByIds(String[] ids);
}
