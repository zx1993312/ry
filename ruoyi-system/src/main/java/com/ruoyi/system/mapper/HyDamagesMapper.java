package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyDamages;

/**
 * 违约金Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-28
 */
public interface HyDamagesMapper 
{
    /**
     * 查询违约金
     * 
     * @param id 违约金ID
     * @return 违约金
     */
    public HyDamages selectHyDamagesById(Long id);

    /**
     * 查询违约金列表
     * 
     * @param hyDamages 违约金
     * @return 违约金集合
     */
    public List<HyDamages> selectHyDamagesList(HyDamages hyDamages);

    /**
     * 新增违约金
     * 
     * @param hyDamages 违约金
     * @return 结果
     */
    public int insertHyDamages(HyDamages hyDamages);

    /**
     * 修改违约金
     * 
     * @param hyDamages 违约金
     * @return 结果
     */
    public int updateHyDamages(HyDamages hyDamages);

    /**
     * 删除违约金
     * 
     * @param id 违约金ID
     * @return 结果
     */
    public int deleteHyDamagesById(Long id);

    /**
     * 批量删除违约金
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDamagesByIds(String[] ids);
}
