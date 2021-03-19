package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCommunitySettings;

/**
 * 小区设置Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyCommunitySettingsService 
{
    /**
     * 查询小区设置
     * 
     * @param id 小区设置ID
     * @return 小区设置
     */
    public HyCommunitySettings selectHyCommunitySettingsById(Long id);

    /**
     * 查询小区设置列表
     * 
     * @param hyCommunitySettings 小区设置
     * @return 小区设置集合
     */
    public List<HyCommunitySettings> selectHyCommunitySettingsList(HyCommunitySettings hyCommunitySettings);

    /**
     * 新增小区设置
     * 
     * @param hyCommunitySettings 小区设置
     * @return 结果
     */
    public int insertHyCommunitySettings(HyCommunitySettings hyCommunitySettings);

    /**
     * 修改小区设置
     * 
     * @param hyCommunitySettings 小区设置
     * @return 结果
     */
    public int updateHyCommunitySettings(HyCommunitySettings hyCommunitySettings);

    /**
     * 批量删除小区设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunitySettingsByIds(String ids);

    /**
     * 删除小区设置信息
     * 
     * @param id 小区设置ID
     * @return 结果
     */
    public int deleteHyCommunitySettingsById(Long id);
}
