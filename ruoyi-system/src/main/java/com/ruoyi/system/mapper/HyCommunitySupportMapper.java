package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunitySupport;

/**
 * 社区配套Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public interface HyCommunitySupportMapper 
{
    /**
     * 查询社区配套
     * 
     * @param id 社区配套ID
     * @return 社区配套
     */
    public HyCommunitySupport selectHyCommunitySupportById(Long id);

    /**
     * 查询社区配套列表
     * 
     * @param hyCommunitySupport 社区配套
     * @return 社区配套集合
     */
    public List<HyCommunitySupport> selectHyCommunitySupportList(HyCommunitySupport hyCommunitySupport);

    /**
     * 新增社区配套
     * 
     * @param hyCommunitySupport 社区配套
     * @return 结果
     */
    public int insertHyCommunitySupport(HyCommunitySupport hyCommunitySupport);

    /**
     * 修改社区配套
     * 
     * @param hyCommunitySupport 社区配套
     * @return 结果
     */
    public int updateHyCommunitySupport(HyCommunitySupport hyCommunitySupport);

    /**
     * 删除社区配套
     * 
     * @param id 社区配套ID
     * @return 结果
     */
    public int deleteHyCommunitySupportById(Long id);

    /**
     * 批量删除社区配套
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunitySupportByIds(String[] ids);
}
