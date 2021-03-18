package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyResidentialQuarters;

/**
 * 小区Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-17
 */
public interface HyResidentialQuartersMapper 
{
    /**
     * 查询小区
     * 
     * @param id 小区ID
     * @return 小区
     */
    public HyResidentialQuarters selectHyResidentialQuartersById(Long id);

    /**
     * 查询小区列表
     * 
     * @param hyResidentialQuarters 小区
     * @return 小区集合
     */
    public List<HyResidentialQuarters> selectHyResidentialQuartersList(HyResidentialQuarters hyResidentialQuarters);

    /**
     * 新增小区
     * 
     * @param hyResidentialQuarters 小区
     * @return 结果
     */
    public int insertHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters);

    /**
     * 修改小区
     * 
     * @param hyResidentialQuarters 小区
     * @return 结果
     */
    public int updateHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters);

    /**
     * 删除小区
     * 
     * @param id 小区ID
     * @return 结果
     */
    public int deleteHyResidentialQuartersById(Long id);

    /**
     * 批量删除小区
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyResidentialQuartersByIds(String[] ids);
}
