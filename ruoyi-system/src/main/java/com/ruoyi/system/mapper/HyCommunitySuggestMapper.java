package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunitySuggest;

/**
 * 社区建议Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public interface HyCommunitySuggestMapper 
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
     * 查询社区建议待审核列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议集合
     */
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByAudit(HyCommunitySuggest hyCommunitySuggest);
    
    /**
     * 查询社区建议已通过列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议集合
     */
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByThrough(HyCommunitySuggest hyCommunitySuggest);
    
    /**
     * 查询社区建议已拒绝列表
     * 
     * @param hyCommunitySuggest 社区建议
     * @return 社区建议集合
     */
    public List<HyCommunitySuggest> selectHyCommunitySuggestListByRefusal(HyCommunitySuggest hyCommunitySuggest);

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
     * 删除社区建议
     * 
     * @param id 社区建议ID
     * @return 结果
     */
    public int deleteHyCommunitySuggestById(Long id);

    /**
     * 批量删除社区建议
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunitySuggestByIds(String[] ids);
}
