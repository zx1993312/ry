package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyScrap;

/**
 * 设备报废申请Service接口
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public interface IHyScrapService 
{
    /**
     * 查询设备报废申请
     * 
     * @param id 设备报废申请ID
     * @return 设备报废申请
     */
    public HyScrap selectHyScrapById(Long id);

    /**
     * 查询设备报废申请列表
     * 
     * @param hyScrap 设备报废申请
     * @return 设备报废申请集合
     */
    public List<HyScrap> selectHyScrapList(HyScrap hyScrap);

    /**
     * 新增设备报废申请
     * 
     * @param hyScrap 设备报废申请
     * @return 结果
     */
    public int insertHyScrap(HyScrap hyScrap);

    /**
     * 修改设备报废申请
     * 
     * @param hyScrap 设备报废申请
     * @return 结果
     */
    public int updateHyScrap(HyScrap hyScrap);

    /**
     * 批量删除设备报废申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyScrapByIds(String ids);

    /**
     * 删除设备报废申请信息
     * 
     * @param id 设备报废申请ID
     * @return 结果
     */
    public int deleteHyScrapById(Long id);
}
