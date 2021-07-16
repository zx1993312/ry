package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyLable;

/**
 * 标签Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-16
 */
public interface HyLableMapper 
{
    /**
     * 查询标签
     * 
     * @param id 标签ID
     * @return 标签
     */
    public HyLable selectHyLableById(Long id);

    /**
     * 查询标签列表
     * 
     * @param hyLable 标签
     * @return 标签集合
     */
    public List<HyLable> selectHyLableList(HyLable hyLable);

    /**
     * 新增标签
     * 
     * @param hyLable 标签
     * @return 结果
     */
    public int insertHyLable(HyLable hyLable);

    /**
     * 修改标签
     * 
     * @param hyLable 标签
     * @return 结果
     */
    public int updateHyLable(HyLable hyLable);

    /**
     * 删除标签
     * 
     * @param id 标签ID
     * @return 结果
     */
    public int deleteHyLableById(Long id);

    /**
     * 批量删除标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyLableByIds(String[] ids);
}