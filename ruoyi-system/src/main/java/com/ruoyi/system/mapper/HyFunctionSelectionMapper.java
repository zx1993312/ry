package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyFunctionSelection;

/**
 * 功能选择Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-16
 */
public interface HyFunctionSelectionMapper 
{
    /**
     * 查询功能选择
     * 
     * @param id 功能选择ID
     * @return 功能选择
     */
    public HyFunctionSelection selectHyFunctionSelectionById(Long id);

    /**
     * 查询功能选择列表
     * 
     * @param hyFunctionSelection 功能选择
     * @return 功能选择集合
     */
    public List<HyFunctionSelection> selectHyFunctionSelectionList(HyFunctionSelection hyFunctionSelection);

    /**
     * 新增功能选择
     * 
     * @param hyFunctionSelection 功能选择
     * @return 结果
     */
    public int insertHyFunctionSelection(HyFunctionSelection hyFunctionSelection);

    /**
     * 修改功能选择
     * 
     * @param hyFunctionSelection 功能选择
     * @return 结果
     */
    public int updateHyFunctionSelection(HyFunctionSelection hyFunctionSelection);

    /**
     * 删除功能选择
     * 
     * @param id 功能选择ID
     * @return 结果
     */
    public int deleteHyFunctionSelectionById(Long id);

    /**
     * 批量删除功能选择
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyFunctionSelectionByIds(String[] ids);
}
