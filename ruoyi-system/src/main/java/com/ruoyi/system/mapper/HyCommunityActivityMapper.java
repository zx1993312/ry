package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunityActivity;

/**
 * 社区活动Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-14
 */
public interface HyCommunityActivityMapper 
{
    /**
     * 查询社区活动
     * 
     * @param id 社区活动ID
     * @return 社区活动
     */
    public HyCommunityActivity selectHyCommunityActivityById(Long id);

    /**
     * 查询社区活动列表
     * 
     * @param hyCommunityActivity 社区活动
     * @return 社区活动集合
     */
    public List<HyCommunityActivity> selectHyCommunityActivityList(HyCommunityActivity hyCommunityActivity);

    /**
     * 新增社区活动
     * 
     * @param hyCommunityActivity 社区活动
     * @return 结果
     */
    public int insertHyCommunityActivity(HyCommunityActivity hyCommunityActivity);

    /**
     * 修改社区活动
     * 
     * @param hyCommunityActivity 社区活动
     * @return 结果
     */
    public int updateHyCommunityActivity(HyCommunityActivity hyCommunityActivity);

    /**
     * 删除社区活动
     * 
     * @param id 社区活动ID
     * @return 结果
     */
    public int deleteHyCommunityActivityById(Long id);

    /**
     * 批量删除社区活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunityActivityByIds(String[] ids);
}