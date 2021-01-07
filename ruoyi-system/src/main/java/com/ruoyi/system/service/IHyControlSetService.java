package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyControlSet;

/**
 * 管控模型设置Service接口
 * 
 * @author Administrator
 * @date 2021-01-07
 */
public interface IHyControlSetService 
{
    /**
     * 查询管控模型设置
     * 
     * @param id 管控模型设置ID
     * @return 管控模型设置
     */
    public HyControlSet selectHyControlSetById(Long id);

    /**
     * 查询管控模型设置列表
     * 
     * @param hyControlSet 管控模型设置
     * @return 管控模型设置集合
     */
    public List<HyControlSet> selectHyControlSetList(HyControlSet hyControlSet);

    /**
     * 新增管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    public int insertHyControlSet(HyControlSet hyControlSet);

    /**
     * 修改管控模型设置
     * 
     * @param hyControlSet 管控模型设置
     * @return 结果
     */
    public int updateHyControlSet(HyControlSet hyControlSet);

    /**
     * 批量删除管控模型设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyControlSetByIds(String ids);

    /**
     * 删除管控模型设置信息
     * 
     * @param id 管控模型设置ID
     * @return 结果
     */
    public int deleteHyControlSetById(Long id);
}
