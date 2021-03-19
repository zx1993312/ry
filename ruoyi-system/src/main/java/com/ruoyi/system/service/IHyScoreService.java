package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyScore;

/**
 * 评价Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyScoreService 
{
    /**
     * 查询评价
     * 
     * @param id 评价ID
     * @return 评价
     */
    public HyScore selectHyScoreById(Long id);

    /**
     * 查询评价列表
     * 
     * @param hyScore 评价
     * @return 评价集合
     */
    public List<HyScore> selectHyScoreList(HyScore hyScore);

    /**
     * 新增评价
     * 
     * @param hyScore 评价
     * @return 结果
     */
    public int insertHyScore(HyScore hyScore);

    /**
     * 修改评价
     * 
     * @param hyScore 评价
     * @return 结果
     */
    public int updateHyScore(HyScore hyScore);

    /**
     * 批量删除评价
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyScoreByIds(String ids);

    /**
     * 删除评价信息
     * 
     * @param id 评价ID
     * @return 结果
     */
    public int deleteHyScoreById(Long id);
}
