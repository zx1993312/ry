package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyEntry;

/**
 * 入账处理Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public interface HyEntryMapper 
{
    /**
     * 查询入账处理
     * 
     * @param id 入账处理ID
     * @return 入账处理
     */
    public HyEntry selectHyEntryById(Long id);

    /**
     * 查询入账处理列表
     * 
     * @param hyEntry 入账处理
     * @return 入账处理集合
     */
    public List<HyEntry> selectHyEntryList(HyEntry hyEntry);

    /**
     * 新增入账处理
     * 
     * @param hyEntry 入账处理
     * @return 结果
     */
    public int insertHyEntry(HyEntry hyEntry);

    /**
     * 修改入账处理
     * 
     * @param hyEntry 入账处理
     * @return 结果
     */
    public int updateHyEntry(HyEntry hyEntry);

    /**
     * 删除入账处理
     * 
     * @param id 入账处理ID
     * @return 结果
     */
    public int deleteHyEntryById(Long id);

    /**
     * 批量删除入账处理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEntryByIds(String[] ids);
}
