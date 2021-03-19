package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyScoreMapper;
import com.ruoyi.system.domain.HyScore;
import com.ruoyi.system.service.IHyScoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评价Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyScoreServiceImpl implements IHyScoreService 
{
    @Autowired
    private HyScoreMapper hyScoreMapper;

    /**
     * 查询评价
     * 
     * @param id 评价ID
     * @return 评价
     */
    @Override
    public HyScore selectHyScoreById(Long id)
    {
        return hyScoreMapper.selectHyScoreById(id);
    }

    /**
     * 查询评价列表
     * 
     * @param hyScore 评价
     * @return 评价
     */
    @Override
    public List<HyScore> selectHyScoreList(HyScore hyScore)
    {
        return hyScoreMapper.selectHyScoreList(hyScore);
    }

    /**
     * 新增评价
     * 
     * @param hyScore 评价
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyScore(HyScore hyScore)
    {
        return hyScoreMapper.insertHyScore(hyScore);
    }

    /**
     * 修改评价
     * 
     * @param hyScore 评价
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyScore(HyScore hyScore)
    {
        return hyScoreMapper.updateHyScore(hyScore);
    }

    /**
     * 删除评价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyScoreByIds(String ids)
    {
        return hyScoreMapper.deleteHyScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评价信息
     * 
     * @param id 评价ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyScoreById(Long id)
    {
        return hyScoreMapper.deleteHyScoreById(id);
    }
}
