package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyCommunitySettingsMapper;
import com.ruoyi.system.domain.HyCommunitySettings;
import com.ruoyi.system.service.IHyCommunitySettingsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小区设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyCommunitySettingsServiceImpl implements IHyCommunitySettingsService 
{
    @Autowired
    private HyCommunitySettingsMapper hyCommunitySettingsMapper;

    /**
     * 查询小区设置
     * 
     * @param id 小区设置ID
     * @return 小区设置
     */
    @Override
    public HyCommunitySettings selectHyCommunitySettingsById(Long id)
    {
        return hyCommunitySettingsMapper.selectHyCommunitySettingsById(id);
    }

    /**
     * 查询小区设置列表
     * 
     * @param hyCommunitySettings 小区设置
     * @return 小区设置
     */
    @Override
    public List<HyCommunitySettings> selectHyCommunitySettingsList(HyCommunitySettings hyCommunitySettings)
    {
        return hyCommunitySettingsMapper.selectHyCommunitySettingsList(hyCommunitySettings);
    }

    /**
     * 新增小区设置
     * 
     * @param hyCommunitySettings 小区设置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunitySettings(HyCommunitySettings hyCommunitySettings)
    {
        return hyCommunitySettingsMapper.insertHyCommunitySettings(hyCommunitySettings);
    }

    /**
     * 修改小区设置
     * 
     * @param hyCommunitySettings 小区设置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunitySettings(HyCommunitySettings hyCommunitySettings)
    {
        return hyCommunitySettingsMapper.updateHyCommunitySettings(hyCommunitySettings);
    }

    /**
     * 删除小区设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySettingsByIds(String ids)
    {
        return hyCommunitySettingsMapper.deleteHyCommunitySettingsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小区设置信息
     * 
     * @param id 小区设置ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunitySettingsById(Long id)
    {
        return hyCommunitySettingsMapper.deleteHyCommunitySettingsById(id);
    }
}
