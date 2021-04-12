package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCommunitySuggest;

/**
 * 社区建议Service接口
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public interface IHyCommunitySuggestService 
{
    /**
     * 查询社区建议
     * 
     * @param id 社区建议ID
     * @return 社区建议
     */
    public HyCommunitySuggest selectHyCommunitySuggestById(Long id);

    /**
     * 查询社区建议列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议集合
     */
    public List<HyCommunitySuggest> selectHyCommunitySuggestList(HyCommunitySuggest hyCommunitySuggest);

    /**
     * 新增社区建议
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 结果
     */
    public int insertHyCommunitySuggest(HyCommunitySuggest hyCommunitySuggest);

    /**
     * 修改社区建议
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 结果
     */
    public int updateHyCommunitySuggest(HyCommunitySuggest hyCommunitySuggest);

    /**
     * 批量删除社区建议
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunitySuggestByIds(String ids);

    /**
     * 删除社区建议信息
     * 
     * @param id 社区建议ID
     * @return 结果
     */
    public int deleteHyCommunitySuggestById(Long id);
}
