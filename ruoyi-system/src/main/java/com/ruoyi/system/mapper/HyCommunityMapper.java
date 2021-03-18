package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunity;

/**
 * 社区Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public interface HyCommunityMapper 
{
    /**
     * 查询社区
     * 
     * @param id 社区ID
     * @return 社区
     */
    public HyCommunity selectHyCommunityById(Long id);

    /**
     * 查询社区列表
     * 
     * @param hyCommunity 社区
     * @return 社区集合
     */
    public List<HyCommunity> selectHyCommunityList(HyCommunity hyCommunity);

    /**
     * 新增社区
     * 
     * @param hyCommunity 社区
     * @return 结果
     */
    public int insertHyCommunity(HyCommunity hyCommunity);

    /**
     * 修改社区
     * 
     * @param hyCommunity 社区
     * @return 结果
     */
    public int updateHyCommunity(HyCommunity hyCommunity);

    /**
     * 删除社区
     * 
     * @param id 社区ID
     * @return 结果
     */
    public int deleteHyCommunityById(Long id);

    /**
     * 批量删除社区
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunityByIds(String[] ids);
}
