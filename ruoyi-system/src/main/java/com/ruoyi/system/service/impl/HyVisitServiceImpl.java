package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyVisitMapper;
import com.ruoyi.system.domain.HyVisit;
import com.ruoyi.system.service.IHyVisitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 访客Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyVisitServiceImpl implements IHyVisitService 
{
    @Autowired
    private HyVisitMapper hyVisitMapper;

    /**
     * 查询访客
     * 
     * @param id 访客ID
     * @return 访客
     */
    @Override
    public HyVisit selectHyVisitById(Long id)
    {
        return hyVisitMapper.selectHyVisitById(id);
    }

    /**
     * 查询访客列表
     * 
     * @param hyVisit 访客
     * @return 访客
     */
    @Override
    public List<HyVisit> selectHyVisitList(HyVisit hyVisit)
    {
        return hyVisitMapper.selectHyVisitList(hyVisit);
    }

    /**
     * 新增访客
     * 
     * @param hyVisit 访客
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyVisit(HyVisit hyVisit)
    {
        return hyVisitMapper.insertHyVisit(hyVisit);
    }

    /**
     * 修改访客
     * 
     * @param hyVisit 访客
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyVisit(HyVisit hyVisit)
    {
        return hyVisitMapper.updateHyVisit(hyVisit);
    }

    /**
     * 删除访客对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyVisitByIds(String ids)
    {
        return hyVisitMapper.deleteHyVisitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除访客信息
     * 
     * @param id 访客ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyVisitById(Long id)
    {
        return hyVisitMapper.deleteHyVisitById(id);
    }
}
