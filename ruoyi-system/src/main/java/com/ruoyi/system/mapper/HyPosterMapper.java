package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyPoster;

/**
 * 海报Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public interface HyPosterMapper 
{
    /**
     * 查询海报
     * 
     * @param id 海报ID
     * @return 海报
     */
    public HyPoster selectHyPosterById(Long id);

    /**
     * 查询海报列表
     * 
     * @param hyPoster 海报
     * @return 海报集合
     */
    public List<HyPoster> selectHyPosterList(HyPoster hyPoster);

    /**
     * 新增海报
     * 
     * @param hyPoster 海报
     * @return 结果
     */
    public int insertHyPoster(HyPoster hyPoster);

    /**
     * 修改海报
     * 
     * @param hyPoster 海报
     * @return 结果
     */
    public int updateHyPoster(HyPoster hyPoster);

    /**
     * 删除海报
     * 
     * @param id 海报ID
     * @return 结果
     */
    public int deleteHyPosterById(Long id);

    /**
     * 批量删除海报
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPosterByIds(String[] ids);
}
