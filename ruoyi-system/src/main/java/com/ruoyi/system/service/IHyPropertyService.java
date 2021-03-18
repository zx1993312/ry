package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyProperty;

/**
 * 物业Service接口
 * 
 * @author Administrator
 * @date 2021-03-17
 */
public interface IHyPropertyService 
{
    /**
     * 查询物业
     * 
     * @param id 物业ID
     * @return 物业
     */
    public HyProperty selectHyPropertyById(Long id);

    /**
     * 查询物业列表
     * 
     * @param hyProperty 物业
     * @return 物业集合
     */
    public List<HyProperty> selectHyPropertyList(HyProperty hyProperty);

    /**
     * 新增物业
     * 
     * @param hyProperty 物业
     * @return 结果
     */
    public int insertHyProperty(HyProperty hyProperty);

    /**
     * 修改物业
     * 
     * @param hyProperty 物业
     * @return 结果
     */
    public int updateHyProperty(HyProperty hyProperty);

    /**
     * 批量删除物业
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPropertyByIds(String ids);

    /**
     * 删除物业信息
     * 
     * @param id 物业ID
     * @return 结果
     */
    public int deleteHyPropertyById(Long id);
}
