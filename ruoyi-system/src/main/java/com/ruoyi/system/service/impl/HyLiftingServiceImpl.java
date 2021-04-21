package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyLiftingMapper;
import com.ruoyi.system.domain.HyLifting;
import com.ruoyi.system.service.IHyLiftingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 提料人Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyLiftingServiceImpl implements IHyLiftingService 
{
    @Autowired
    private HyLiftingMapper hyLiftingMapper;

    /**
     * 查询提料人
     * 
     * @param id 提料人ID
     * @return 提料人
     */
    @Override
    public HyLifting selectHyLiftingById(Long id)
    {
        return hyLiftingMapper.selectHyLiftingById(id);
    }

    /**
     * 查询提料人列表
     * 
     * @param hyLifting 提料人
     * @return 提料人
     */
    @Override
    public List<HyLifting> selectHyLiftingList(HyLifting hyLifting)
    {
        return hyLiftingMapper.selectHyLiftingList(hyLifting);
    }

    /**
     * 新增提料人
     * 
     * @param hyLifting 提料人
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyLifting(HyLifting hyLifting)
    {
        hyLifting.setCreateTime(DateUtils.getNowDate());
        return hyLiftingMapper.insertHyLifting(hyLifting);
    }

    /**
     * 修改提料人
     * 
     * @param hyLifting 提料人
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyLifting(HyLifting hyLifting)
    {
        return hyLiftingMapper.updateHyLifting(hyLifting);
    }

    /**
     * 删除提料人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyLiftingByIds(String ids)
    {
        return hyLiftingMapper.deleteHyLiftingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除提料人信息
     * 
     * @param id 提料人ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyLiftingById(Long id)
    {
        return hyLiftingMapper.deleteHyLiftingById(id);
    }
}