package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMemo;

/**
 * 设备维修保养备忘录Service接口
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public interface IHyMemoService 
{
    /**
     * 查询设备维修保养备忘录
     * 
     * @param id 设备维修保养备忘录ID
     * @return 设备维修保养备忘录
     */
    public HyMemo selectHyMemoById(Long id);

    /**
     * 查询设备维修保养备忘录列表
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 设备维修保养备忘录集合
     */
    public List<HyMemo> selectHyMemoList(HyMemo hyMemo);

    /**
     * 新增设备维修保养备忘录
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 结果
     */
    public int insertHyMemo(HyMemo hyMemo);

    /**
     * 修改设备维修保养备忘录
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 结果
     */
    public int updateHyMemo(HyMemo hyMemo);

    /**
     * 批量删除设备维修保养备忘录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMemoByIds(String ids);

    /**
     * 删除设备维修保养备忘录信息
     * 
     * @param id 设备维修保养备忘录ID
     * @return 结果
     */
    public int deleteHyMemoById(Long id);
}
