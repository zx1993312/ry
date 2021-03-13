package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunityIntroduction;

/**
 * 社区简介Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public interface HyCommunityIntroductionMapper 
{
    /**
     * 查询社区简介
     * 
     * @param id 社区简介ID
     * @return 社区简介
     */
    public HyCommunityIntroduction selectHyCommunityIntroductionById(Long id);

    /**
     * 查询社区简介列表
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 社区简介集合
     */
    public List<HyCommunityIntroduction> selectHyCommunityIntroductionList(HyCommunityIntroduction hyCommunityIntroduction);

    /**
     * 新增社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    public int insertHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction);

    /**
     * 修改社区简介
     * 
     * @param hyCommunityIntroduction 社区简介
     * @return 结果
     */
    public int updateHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction);

    /**
     * 删除社区简介
     * 
     * @param id 社区简介ID
     * @return 结果
     */
    public int deleteHyCommunityIntroductionById(Long id);

    /**
     * 批量删除社区简介
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunityIntroductionByIds(String[] ids);
}
