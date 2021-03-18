package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyFunctionSelection;

/**
 * 功能选择Service接口
 * 
 * @author Administrator
 * @date 2021-03-16
 */
public interface IHyFunctionSelectionService 
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
     * 批量删除功能选择
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyFunctionSelectionByIds(String ids);

    /**
     * 删除功能选择信息
     * 
     * @param id 功能选择ID
     * @return 结果
     */
    public int deleteHyFunctionSelectionById(Long id);
}
